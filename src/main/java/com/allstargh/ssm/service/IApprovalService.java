/**
 * 
 */
package com.allstargh.ssm.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * @author admin
 *
 */
public interface IApprovalService {
	/**
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	List<TApproval> exhibitionAll(Integer uid) throws SelfServiceException;

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
	 * @param usrid
	 * @param replyOpinion
	 * @param decide           0:disagree<br>
	 *                         1:agree
	 * @param appId
	 * @param departmentNumber
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer backupAdd(Integer usrid, String replyOpinion, Integer decide, Integer appId,
			Integer departmentNumber) throws SelfServiceException;

	/**
	 * 
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract HashMap<Integer, Object> exhibition(Integer usrid) throws SelfServiceException;
}
