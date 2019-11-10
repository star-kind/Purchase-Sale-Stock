package com.allstargh.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TSaleExample;
import com.allstargh.ssm.pojo.TSaleExample.Criteria;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ISaleService;
import com.allstargh.ssm.service.ex.SelfServiceException;

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
	private ICommonReplenishService icrs;

	@Override
	public Integer add(Integer uid, TSale tSale) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

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

}
