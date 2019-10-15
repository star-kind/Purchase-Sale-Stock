package com.allstargh.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allstargh.ssm.controller.kits.ControllerUtils;

/**
 * 中转控制器,模块选择进入
 * 
 * @author gzh
 *
 */
@Controller
@RequestMapping("/cross")
public class TransferController extends ControllerUtils {
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
	@RequestMapping(value = "toReviseBaseProfile")
	public String toReviseBaseProfile() {
		return "ReviseBaseProfile";
	}

	/**
	 * /stocker-manager/cross/gotoStockerPagesRejectReply
	 * 
	 * @return
	 */
	@RequestMapping(value = "gotoStockerPagesRejectReply")
	public String gotoStockerPagesRejectReply() {
		return "StockerPages/RejectReply";
	}

}