package com.allstargh.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;

@Service
public class StockServiceImpl implements IStcokSevice {
	@Autowired
	private PurchaseMapper pm;

	@Override
	public Integer regEntry(Purchase purchase, TStock stock) throws SelfServiceException {
		// 装配仓储实体对象
		stock.setPurchaseId(purchase.getPurchaseId());

		Integer classify = purchase.getClassify();

		byte b = Byte.parseByte(classify + "");
		stock.setStockTypeArea(b);

		return null;
	}

}
