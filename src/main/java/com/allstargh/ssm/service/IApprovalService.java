/**
 * 
 */
package com.allstargh.ssm.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * @author admin
 *
 */
public interface IApprovalService {
	/**
	 * 分页显示数据列表
	 * 
	 * @param uid
	 * @param pageNum
	 * @param lines
	 * @return
	 * @throws SelfServiceException
	 */
	abstract PaginationII<List<TApproval>> exhibitionAllOnPagination(Integer uid, Integer pageNum, Integer lines)
			throws SelfServiceException;

	/**
	 * 审批各部门审单
	 * 
	 * @param uid        审批者
	 * @param decide     是否同意,0假1真
	 * @param order      审单ID
	 * @param remark     意见备注
	 * @param deptNumber 部门编号(2采购部,采购申请单;3销售部,提货申请单;4仓储部,出库申请单)
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer agreeOrAgainst(Integer uid, Integer decide, Integer order, String remark, Integer deptNumber)
			throws SelfServiceException;

	/**
	 * 获取已处理的申请单
	 * 
	 * @param uid
	 * @param approvalID
	 * @return
	 * @throws SelfServiceException
	 */
	TApproval obtainTApprovalByID(Integer uid, Integer approvalID) throws SelfServiceException;

	/**
	 * 据ID修改 <br>
	 * 主动:审批操作+意见 <br>
	 * 被动:审核者(由本次修改覆盖)+时间
	 * 
	 * @param uid
	 * @param approveOperates
	 * @param replyOpinion
	 * @param tid
	 * @return
	 * @throws SelfServiceException
	 */
	Integer revampByID(Integer uid, Integer approveOperates, String replyOpinion, Integer tid)
			throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	List<TApproval> exhibitionAll(Integer uid) throws SelfServiceException;

	/**
	 * 读取记录<b>overload</b>
	 * 
	 * @param usrid
	 * @param pageNum
	 * @param lines
	 * @return
	 * @throws IOException
	 * @throws SelfServiceException
	 */
	abstract PagingTextII readOutputSubstanceLog(Integer usrid, Integer pageNum, Integer lines)
			throws IOException, SelfServiceException;

	/**
	 * 读取记录
	 * 
	 * @param usrid 用户ID
	 * @return
	 * @throws IOException
	 */
	abstract String[] readOutputSubstanceLog(Integer usrid) throws IOException, SelfServiceException;

	/**
	 * 不管批准与否都要备份
	 * 
	 * @param usrid            审批执行者
	 * @param replyOpinion     意见备注
	 * @param decide           0:disagree;1:agree
	 * @param appId            审单序号
	 * @param departmentNumber 部门编号
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer backupAdd(Integer usrid, String replyOpinion, Integer decide, Integer appId,
			Integer departmentNumber) throws SelfServiceException;

	/**
	 * 展示待处理的申请单们
	 * 
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract HashMap<Integer, Object> exhibition(Integer usrid) throws SelfServiceException;

	/**
	 * <b>分页</b>展示待处理的申请单们
	 * 
	 * @override
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract PaginationII<HashMap<Integer, Object>> exhibition(Integer usrid, Integer pageNum, Integer lines)
			throws SelfServiceException;
}
