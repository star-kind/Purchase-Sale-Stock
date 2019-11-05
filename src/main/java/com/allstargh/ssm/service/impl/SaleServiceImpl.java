package com.allstargh.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.TSale;
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
public class SaleServiceImpl implements ISaleService{
	@Autowired
	private TSaleDAO tSaleDAO;
	
	@Autowired
	private ICommonReplenishService icrs;
	
	@Override
	public Integer add(Integer uid, TSale tSale) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 3);
		
		tSale.setSaleOperator(uid);
		tSale.setSaleTime(new Date());
		
		return null;
	}

}
