package com.allstargh.ssm.service;

import java.io.IOException;
import java.util.List;

import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.JointStockVO;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.PagingTextII;
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
	 * 分页读取文本
	 * 
	 * @param uid
	 * @param pageth
	 * @param lines
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	abstract PagingTextII readTextOnLimit(Integer uid, Integer pageth, Integer lines)
			throws SelfServiceException, IOException;

	/**
	 * 增
	 * 
	 * @param uid
	 * @param vo
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer addOut(Integer uid, JointStockVO vo) throws SelfServiceException;

	/**
	 * 仓管员从不同的表中get数据
	 * 
	 * @param uid
	 * @param sid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract List<JointStockVO> gainJointData(Integer uid, Integer sid) throws SelfServiceException;

	/**
	 * <b>新改进</b> 展示仓管员要处理的出库队列,分页
	 * 
	 * @param uid
	 * @param deptNum 部门编号
	 * @param operate 1是,0否
	 * @param pageth  页码
	 * @param lines   每页行数
	 * @return
	 * @throws SelfServiceException
	 */
	abstract PaginationII<List<AssociativeEntity>> exhibitionQueuePlus(Integer uid, Integer deptNum, Integer operate,
			Integer pageth, Integer lines) throws SelfServiceException;

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
