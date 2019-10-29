package com.allstargh.ssm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;
import com.allstargh.ssm.service.util.StockServiceUtil;

@Service
public class StockServiceImpl implements IStcokSevice {
	@Autowired
	private AccountsMapper amp;

	@Autowired
	private PurchaseMapper pm;

	@Autowired
	private ICommonReplenishService ics;

	@Autowired
	private TStockDAO tsd;

	StockServiceUtil ins = StockServiceUtil.getInstance();

	@Override
	public Integer regEntry(Purchase purchase, String stockOperator) throws SelfServiceException {
		/*
		 * 装配仓储实体对象
		 */
		TStock stock = new TStock();

		stock.setPurchaseId(purchase.getPurchaseId());

		String classify = purchase.getClassify().toString();
		byte b = Byte.parseByte(classify);
		stock.setStockTypeArea(b);

		Integer quantity = purchase.getQuantity();
		stock.setStoreQuantity(quantity);

		Float amountMoney = purchase.getAmountMoney();

		int q = quantity.intValue();
		float price = amountMoney / (float) q;
		stock.setUnitPrice((long) price);

		stock.setStoreCommodity(purchase.getCommodity());

		try {
			stock.setStockOperator(stockOperator);
		} catch (SelfServiceException e) {
			e.printStackTrace();
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		stock.setEnterStockTime(new Date());

		stock.setAgreeEnterStock(true);

		int row = tsd.insert(stock);

		return row;
	}

	@Override
	public Integer regToExternal(String purchase, String stockOperator, String remark) throws SelfServiceException {

		HashMap<String, String> hashMap = ins.generateMap(purchase);
		TStock stock = ins.arrangement(hashMap, stockOperator, remark);
		System.err.println(stock);

		int row = tsd.insert(stock);

		return row;
	}

	@Override
	public List<TStock> findAll(Integer uid) throws SelfServiceException {
		Accounts acc = amp.selectAccountByUsrid(uid);

		List<TStock> list = tsd.selectAllRows();

		try {
			if (acc == null || "".equals(acc)) {
				System.err.println("是谁?");
				list = null;

			} else if (acc.getActiveStatus() == 0) {
				String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
				System.err.println(description);
				list = null;

			} else if (acc.getCompetence() != 4) {
				String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
				System.err.println(description);
				list = null;

			}

		} catch (SelfServiceException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public TStock findTStockByPurchaseId(Integer purchaseId, Integer usrid) throws SelfServiceException {
		Accounts accounts = amp.selectAccountByUsrid(usrid);
		ins.checkStockerState(accounts);

		TStock tStock = tsd.selectByPurchaseId(purchaseId);
		return tStock;
	}

	@Override
	public Integer modifiedStoreGood(Integer usrid, String tStock) throws SelfServiceException {
		Accounts accounts = amp.selectAccountByUsrid(usrid);
		ins.checkStockerState(accounts);

		HashMap<String, String> map = ins.generateMapImprove(tStock);
		TStock tStock2 = ins.arrangement(map);

		tStock2.setLastestModifier(accounts.getUsrname());
		tStock2.setLastestModifiedTime(new Date());

		Integer affect = tsd.updateStoreGoodByPurchase(tStock2);

		return affect;
	}

	@Override
	public List<TStock> foundByTypeArea(Integer usrid, Byte areaOrder) throws SelfServiceException {
		Accounts ac = amp.selectAccountByUsrid(usrid);

		boolean b = ics.checkForAccount(ac, 4);

		if (b) {
			List<TStock> list = tsd.selectByPurchaseStockTypeArea(areaOrder);
			return list;
		}

		return null;
	}

}
