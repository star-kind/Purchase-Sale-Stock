package com.allstargh.ssm.service;

import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 销售记录业务
 * 
 * @author admin
 *
 */
public interface ISaleService {
	/**
	 * 
	 * @param uid
	 * @param tSale
	 * @return
	 * @throws SelfServiceException
	 */
	Integer add(Integer uid,TSale tSale) throws SelfServiceException;
}
