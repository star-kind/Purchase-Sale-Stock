package com.allstargh.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TSaleExample;
import com.allstargh.ssm.pojo.TSaleExample.Criteria;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ISaleService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

/**
 * 销售记录实现类
 * 
 * @author admin
 *
 */
@Service
public class SaleServiceImpl implements ISaleService {
	@Autowired
	private TSaleDAO tSaleDAO;

	@Autowired
	private PurchaseMapper pm;

	@Autowired
	private AccountsMapper am;

	@Autowired
	private TSaleDAO sd;

	@Autowired
	private ICommonReplenishService icrs;

	@Override
	public Integer add(Integer uid, TSale tSale) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

		// 从仓库中获取货品名称
		int pid = Integer.parseInt(tSale.getCommodity());
		TSale sale = sd.selectByPrimaryKey(pid);

		tSale.setCommodity(sale.getCommodity());

		tSale.setSaleOperator(uid);
		tSale.setSaleTime(new Date());

		tSale.setSurplusDemand(tSale.getQuantity());

		short hasSubmittedApproval = 0;
		tSale.setHasSubmittedApproval(hasSubmittedApproval);

		int affect = tSaleDAO.insert(tSale);

		return affect;
	}

	@Override
	public Pagination<TSale> pagingDisplay(Integer pageth, Integer rows, Integer uid) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

		Pagination<TSale> pagination = new Pagination<TSale>();

		TSaleExample example = new TSaleExample();

		Criteria criteria = example.createCriteria();

		// 获取全表数据,进而获取总行数
		example.setDistinct(false);
		example.setOrderByClause("amount_money,id asc");

		criteria.andIdIsNotNull();

		List<TSale> list = tSaleDAO.selectByExample(example);

		// 算出总页数
		Integer totalPages = list.size() / rows;

		// 查找每页数据
		List<TSale> pageList = tSaleDAO.selectLimitByPageRows(pageth * rows, rows);

		// 判断是否有上一页和下一页
		if (pageth == 0 && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(false);

		} else if (pageth > 0 && pageth < totalPages) {// 总页数至少3页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(true);

		} else if (pageth == totalPages && totalPages > 0) {// 总页数字少2页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(true);

		} else if (totalPages == 0) {// 总页数仅仅一页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(false);

		}

		pagination.setCurrentPageth(pageth);
		pagination.setData(pageList);
		pagination.setRows(rows);
		pagination.setTotalPages(totalPages);

		return pagination;
	}

	@Override
	public TSale searchSingle(Integer uid, Integer id) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

		TSale sale = tSaleDAO.selectByPrimaryKey(id);

		return sale;
	}

	@Override
	public Integer revision(Integer uid, TSale tSale) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 1);

		TSaleExample e = new TSaleExample();
		Criteria c = e.createCriteria();

		// 获取本行原先数据
		TSale tSale01 = tSaleDAO.selectByPrimaryKey(tSale.getId());

		// 经手人
		String operator = account.getUsrname();

		// 时间
		Date now = new Date();

		// 是否已送审,若是已送,则不可修改
		if (tSale01.getHasSubmittedApproval() == 1) {
			String description = ServiceExceptionEnum.HAS_BEEN_SUBMITTED_TO_APPROVAL_DEPARTMENT.getDescription();
			throw new SelfServiceException(description);
		}

		/*
		 * 计算付款情况
		 */
		String amountPaid = tSale.getAmountPaid().toString();
		Integer paid = Integer.valueOf(amountPaid);

		String amountMoney = tSale.getAmountMoney().toString();
		Integer money = Integer.valueOf(amountMoney);

		Integer percent = paid / money;
		Integer paymentSituation = null;

		if (percent == 0) {
			paymentSituation = 0;

		} else if (percent > 0 && percent < 0.5) {
			paymentSituation = 1;

		} else if (percent > 0.5 && percent < 1) {
			paymentSituation = 2;

		} else if (percent == 1) {
			paymentSituation = 3;

		}

		/*
		 * 存货是否足够
		 */

		/*
		 * 剩余需求量
		 */

		return null;
	}

}
