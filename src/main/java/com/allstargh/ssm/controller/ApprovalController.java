package com.allstargh.ssm.controller;

import java.util.HashMap;

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
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.IPurchaseService;

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
