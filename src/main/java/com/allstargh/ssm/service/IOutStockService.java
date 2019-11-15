package com.allstargh.ssm.service;

import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 出库,隶属仓储部
 * 
 * @author admin
 *
 */
public interface IOutStockService {
	/**
	 * 
	 * @param uid
	 * @param oid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract TOut getToutProfileById(Integer uid, Integer oid) throws SelfServiceException;
}
