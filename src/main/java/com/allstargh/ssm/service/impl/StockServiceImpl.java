package com.allstargh.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

@Service
public class StockServiceImpl implements IStcokSevice {
	@Autowired
	private PurchaseMapper pm;

	@Autowired
	private TStockDAO tsd;

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

		// 执行添入
		int row = tsd.insert(stock);

		return row;
	}

}
