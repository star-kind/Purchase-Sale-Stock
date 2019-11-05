package com.allstargh.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ApprovalControllerUtil;
import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.IPurchaseService;
import com.allstargh.ssm.service.ex.SelfServiceException;

@Controller
@RequestMapping("/ApprovalController")
public class ApprovalController extends ControllerUtils {
	@Autowired
	private IApprovalService ias;

	@Autowired
	private IPurchaseService ips;

	/**
	 * single instance
	 */
	ApprovalControllerUtil instance = ApprovalControllerUtil.getInstance();

	/**
	 * <--------------------------------------------------------------------------------->
	 */

	/**
	 * /stocker-manager/ApprovalController/revampByIDHandler
	 * 
	 * @param session
	 * @param tid
	 * @param approveOperates
	 * @param replyOpinion
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "revampByIDHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> revampByIDHandler(HttpSession session, @RequestParam("tid") Integer tid,
			@RequestParam("approveOperates") Integer approveOperates,
			@RequestParam("replyOpinion") String replyOpinion) {
		Integer uid = getUsridFromSession(session);

		System.err.println(uid + "," + approveOperates + "," + replyOpinion + "," + tid);

		Integer affect = ias.revampByID(uid, approveOperates, replyOpinion, tid);
		
		String username = getUsrnameFromSession(session);
		instance.revampByIDHandlerRecord(approveOperates, username, affect, tid);
		
		return new ResponseResult<Integer>(SUCCESS, affect);

	}

	/**
	 * /stocker-manager/ApprovalController/obtainTApprovalByIDHandler
	 * 
	 * @param session
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "obtainTApprovalByIDHandler", method = RequestMethod.GET)
	public ResponseResult<TApproval> obtainTApprovalByIDHandler(HttpSession session, @RequestParam("tid") Integer tid) {
		Integer uid = getUsridFromSession(session);

		TApproval tApproval = ias.obtainTApprovalByID(uid, tid);
		return new ResponseResult<TApproval>(SUCCESS, tApproval);

	}

	/**
	 * http://localhost:8080/stocker-manager/ApprovalController/exhibitionAllHandler
	 * 
	 * @param session
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionAllHandler", method = RequestMethod.GET)
	public ResponseResult<List<TApproval>> exhibitionAllHandler(HttpSession session) {
		Integer uid = getUsridFromSession(session);

		List<TApproval> list = ias.exhibitionAll(uid);
		return new ResponseResult<List<TApproval>>(SUCCESS, list);

	}

	/**
	 * http://localhost:8080/stocker-manager/ApprovalController/readOutputSubstanceLogHandler
	 * 
	 * @param session
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "readOutputSubstanceLogHandler", method = RequestMethod.POST)
	public ResponseResult<String[]> readOutputSubstanceLogHandler(HttpSession session)
			throws SelfServiceException, IOException {
		Integer uid = getUsridFromSession(session);

		String[] strings = ias.readOutputSubstanceLog(uid);

		return new ResponseResult<String[]>(SUCCESS, strings);

	}

	/**
	 * http://localhost:8080/stocker-manager/ApprovalController/exhibitionHandler
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionHandler", method = RequestMethod.GET)
	public ResponseResult<HashMap<Integer, Object>> exhibitionHandler(HttpSession session) {
		Integer uid = getUsridFromSession(session);

		HashMap<Integer, Object> hashMap = ias.exhibition(uid);

		return new ResponseResult<HashMap<Integer, Object>>(SUCCESS, hashMap);
	}

	/**
	 * @param session
	 * @param id           申请单ID
	 * @param replyOpinion 批复意见
	 * @param decide       决定意向
	 * @param deptNumber   部门编号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "agreeOrAgainstHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> agreeOrAgainstHandler(HttpSession session, @RequestParam("id") Integer id,
			@RequestParam("replyOpinion") String replyOpinion, @RequestParam("decide") Integer decide,
			@RequestParam("deptNumber") Integer deptNumber) {
		System.err.println(
				"id:" + id + ",decide:" + decide + ",replyOpinion:" + replyOpinion + ",deptNumber:" + deptNumber);

		Integer uid = getUsridFromSession(session);

		Integer affects = null;

		if (deptNumber == 2) {
			affects = ips.decidedPurchaseIsAgree(uid, id, decide);
		}

		// 添入审批记录表
		if (affects == 1) {
			Integer effect = ias.backupAdd(uid, replyOpinion, decide, id, deptNumber);

			String uname = getUsrnameFromSession(session);

			instance.agreeOrAgainstHandlerRecord(uname, effect, deptNumber, id, decide);

			return new ResponseResult<Integer>(SUCCESS, effect);
		}

		return null;

	}

}
