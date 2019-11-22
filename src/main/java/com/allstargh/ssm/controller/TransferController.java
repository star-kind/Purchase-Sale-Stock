package com.allstargh.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.TransferControllerUtil;
import com.allstargh.ssm.service.ICommonReplenishService;

/**
 * 中转控制器,模块选择进入
 * 
 * @author gzh
 *
 */
@Controller
@RequestMapping("/cross")
public class TransferController extends ControllerUtils {
	@Autowired
	private ICommonReplenishService ics;

	/**
	 * 工具类
	 */
	TransferControllerUtil instance = TransferControllerUtil.getInstance();

	/**
	 * 例如:/stocker-manager/cross/generalAccess?moduleName=ApprovalModule/ApprovalWorkable&competence=1
	 * 
	 * @param session
	 * @param moduleName
	 * @param competence
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "generalAccess", method = RequestMethod.GET)
	public String generalAccess(HttpSession session, String moduleName, Integer competence, ModelMap model) {
		Integer uid = getUsridFromSession(session);

		System.err.println("competence:" + competence + "," + "moduleName:" + moduleName);
		String target = ics.checkEnterCompetence(uid, competence, model, moduleName);

		String username = getUsrnameFromSession(session);

		instance.generalAccessRecords(username, competence);

		return target;

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "toTransfer")
	public String toTransferHandler() {
		return "Transfer";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "toSubstacne")
	public String toSubstacneHandler() {
		return "Substacne";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "toRevisePassword")
	public String toRevisePassword() {
		return "RevisePassword";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("toReviseBaseProfile")
	public String toReviseBaseProfile() {
		return "ReviseBaseProfile";
	}

}