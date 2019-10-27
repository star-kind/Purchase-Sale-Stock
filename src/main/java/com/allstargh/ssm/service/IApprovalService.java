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
	 * @param tApproval
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer backupAdd(TApproval tApproval, Integer usrid) throws SelfServiceException;

	/**
	 * 
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract HashMap<Integer, Object> exhibition(Integer usrid) throws SelfServiceException;
}
