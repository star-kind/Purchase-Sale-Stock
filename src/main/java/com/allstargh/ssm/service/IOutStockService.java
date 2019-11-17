package com.allstargh.ssm.service;

import java.util.List;

import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 出库,隶属仓储部
 * 
 * @author admin
 *
 */
public interface IOutStockService {
	/**
	 * 展示仓管员要处理的出库队列,分页
	 * 
	 * @param uid
	 * @param deptNum 部门编号
	 * @param operate 1是,0否
	 * @param pageth  页码
	 * @param lines   每页行数
	 * @return
	 * @throws SelfServiceException
	 */
	abstract PaginationII<List<TStock>> exhibitionQueue(Integer uid, Integer deptNum, Integer operate, Integer pageth,
			Integer lines) throws SelfServiceException;

	/**
	 * 审核员审批出库
	 * 
	 * @param uid
	 * @param decide
	 * @param id
	 * @return
	 * @throws SelfServiceException
	 */
	Integer updateIsAgreeByApprover(Integer uid, Integer decide, Integer id) throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @param oid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract TOut getToutProfileById(Integer uid, Integer oid) throws SelfServiceException;
}
