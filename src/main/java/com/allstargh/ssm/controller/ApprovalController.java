package com.allstargh.ssm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.service.IApprovalService;

@Controller
@RequestMapping("/ApprovalController")
public class ApprovalController extends ControllerUtils {
	@Autowired
	private IApprovalService ias;

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

}
