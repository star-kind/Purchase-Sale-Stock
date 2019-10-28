/**
 * 
 */
package com.allstargh.ssm.service;

import java.util.HashMap;
import java.util.LinkedList;

import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * @author admin
 *
 */
public interface IApprovalService {
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
