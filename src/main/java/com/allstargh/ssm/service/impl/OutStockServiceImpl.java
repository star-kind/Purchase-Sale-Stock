package com.allstargh.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 
 * @author admin
 *
 */
@Service
public class OutStockServiceImpl implements IOutStockService {
	@Autowired
	private TOutDAO tod;

	@Autowired
	private ICommonReplenishService icrs;

	@Override
	public TOut getToutProfileById(Integer uid, Integer oid) throws SelfServiceException {
		Integer[] competence = { 1, 4 };

		Accounts account = icrs.checkForAccount(uid, competence);
		
		TOut out = tod.selectByPrimaryKey(oid);

		return out;
	}

}
