package com.allstargh.ssm.service;

import java.util.List;

import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 仓储
 * 
 * @author admin
 *
 */
public interface IStcokSevice {
	/**
	 * 
	 * @param purchaseId
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract TStock findTStockByPurchaseId(Integer purchaseId, Integer usrid) throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract List<TStock> findAll(Integer uid) throws SelfServiceException;

	/**
	 * 登记入库
	 * 
	 * @param purchase
	 * @param stockOperator
	 * @return
	 * @throws SelfServiceException
	 */
	Integer regEntry(Purchase purchase, String stockOperator) throws SelfServiceException;

	/**
	 * 接口中的方法亦可重载
	 * 
	 * @param purchase
	 * @param stockOperator
	 * @param remark
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer regToExternal(String purchase, String stockOperator, String remark) throws SelfServiceException;
}
