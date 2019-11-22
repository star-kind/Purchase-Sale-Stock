package com.allstargh.ssm.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.SaleControllerUtil;
import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TSaleExample;
import com.allstargh.ssm.pojo.TSaleExample.Criteria;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ISaleService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;
import com.allstargh.ssm.util.SegmentReadTextII;

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
	private TStockDAO tStockDAO;

	@Autowired
	private ICommonReplenishService icrs;

	@Override
	public Integer add(Integer uid, TSale tSale) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

		// 从仓库中获取货品名称
		Long pid = null;
		TStock stock = null;
		try {
			pid = Long.parseLong(tSale.getCommodity());
			stock = tStockDAO.selectByPrimaryKey(pid);
			
		} catch (NumberFormatException ee) {
			ee.printStackTrace();
			String description = ServiceExceptionEnum.SUBMIT_DATA_UNCOMPLETELY.getDescription();
			throw new SelfServiceException(description);
		}

		tSale.setWarehouseGoodsOrder(pid);

		tSale.setCommodity(stock.getStoreCommodity());

		tSale.setSaleOperator(uid);
		tSale.setSaleTime(new Date());

		tSale.setSurplusDemand(tSale.getQuantity());

		short hasSubmittedApproval = 0;
		tSale.setHasSubmittedApproval(hasSubmittedApproval);

		Short isEnoughStock = null;
		if (tSale.getIsEnoughStock() == null) {
			Integer storeQuantity = stock.getStoreQuantity();
			Integer quantity = tSale.getQuantity();

			float percent = quantity / storeQuantity;

			if (percent == 0) {
				isEnoughStock = 0;

			} else if (percent > 0 && percent < 0.45) {
				isEnoughStock = 1;

			} else if (percent >= 0.45 && percent <= 0.55) {
				isEnoughStock = 2;

			} else if (percent >= 0.90 && percent <= 0.99) {
				isEnoughStock = 3;

			} else if (percent >= 1) {
				isEnoughStock = 4;

			}
		}

		tSale.setIsEnoughStock(isEnoughStock);

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

		/*
		 * 判断是否有上一页和下一页
		 */
		if (pageth == 0 && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(false);

		} else if (pageth > 0 && pageth < totalPages) {// 总页数至少3页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(true);

		} else if (pageth == totalPages && totalPages > 0) {// 总页数至少2页
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
		Accounts account = icrs.checkForAccount(uid, 3);

		TSaleExample e = new TSaleExample();
		Criteria c = e.createCriteria();

		// 获取本行原先数据
		TSale tSale01 = tSaleDAO.selectByPrimaryKey(tSale.getId());

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
		Float amountPaid = tSale.getAmountPaid().floatValue();

		Float amountMoney = tSale.getAmountMoney();

		float percent = amountPaid / amountMoney;
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
		int warehouseGoodsOrder = tSale.getWarehouseGoodsOrder().intValue();
		Integer quantity = tSaleDAO.selectByPrimaryKey(warehouseGoodsOrder).getQuantity();// 获取仓储存量

		Short isEnoughStock = null;

		Integer per = tSale.getQuantity() / quantity;

		if (per == 0) {
			isEnoughStock = 0;

		} else if (per > 0 && per < 0.45) {
			isEnoughStock = 1;

		} else if (per >= 0.45 && per <= 0.55) {
			isEnoughStock = 2;

		} else if (per >= 0.90 && per <= 0.99) {
			isEnoughStock = 3;

		} else if (per >= 1) {
			isEnoughStock = 4;

		}

		// 剩余需求量
		Integer demand = tSale.getQuantity() - quantity;

		tSale.setIsPay(paymentSituation);
		tSale.setIsEnoughStock(isEnoughStock);
		tSale.setSurplusDemand(demand);
		tSale.setSaleOperator(account.getUsrid());
		tSale.setSaleTime(now);

		c.andIdEqualTo(tSale.getId());

		int affect = tSaleDAO.updateByExampleSelective(tSale, e);

		return affect;
	}

	@Override
	public Integer submitCensorship(Integer uid, Integer sid) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);

		TSaleExample e = new TSaleExample();
		Criteria c = e.createCriteria();

		TSale tSale = new TSale();

		// 如果业已送审,则不必要再送审
		TSale tSale01 = tSaleDAO.selectByPrimaryKey(sid);

		if (tSale01.getHasSubmittedApproval() == 1) {
			String description = ServiceExceptionEnum.HAS_BEEN_SUBMITTED_TO_APPROVAL_DEPARTMENT.getDescription();
			throw new SelfServiceException(description);
		}

		short s = 1;
		tSale.setHasSubmittedApproval(s);

		Criteria criteria = c.andIdEqualTo(sid);

		int effect = tSaleDAO.updateByExampleSelective(tSale, e);

		return effect;
	}

	@Override
	public PagingTextII viewLog(Integer uid, Integer pageIndex, Integer lines)
			throws SelfServiceException, IOException {
		Accounts account = icrs.checkForAccount(uid, 3);

		StringBuilder builder = new StringBuilder(ControllerUtils.ENGINE_DAILY_PATH);

		String fileUri = builder.append(SaleControllerUtil.LOG_FILE_NAME).toString();

		SegmentReadTextII seg = new SegmentReadTextII(lines, fileUri);

		icrs.checkTextOutOfCapacity(fileUri, 16 * 1024);

		PagingTextII text = seg.packaging(pageIndex);

		return text;
	}

	@Override
	public TSale multiSearchSingle(Integer uid, Integer id) throws SelfServiceException {
		Integer[] competences = { 1, 3 };

		Accounts account = icrs.checkForAccount(uid, competences);

		TSale sale = tSaleDAO.selectByPrimaryKey(id);

		return sale;
	}

}
