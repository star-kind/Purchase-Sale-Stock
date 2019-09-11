package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import controller.kits.ControllerToolKit;

/**
 * 中转控制器,模块选择进入
 * 
 * @author gzh
 *
 */
@Controller
@RequestMapping("/cross")
public class TransferController extends ControllerToolKit {
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
	private String toSubstacneHandler() {
		return "Substacne";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "toRevisePassword")
	private String toRevisePassword() {
		return "RevisePassword";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "toReviseBaseProfile")
	private String toReviseBaseProfile() {
		return "ReviseBaseProfile";
	}

}