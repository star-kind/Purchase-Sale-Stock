package com.allstargh.ssm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.StockControllerUtil;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IPurchaseService;
import com.allstargh.ssm.service.IStcokSevice;

/**
 * 仓储控制器
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/StockController")
public class StockController extends ControllerUtils {
	@Autowired
	private IPurchaseService ips;

	@Autowired
	private IStcokSevice iss;

	@Autowired
	private ICommonReplenishService iCommonReplenishService;

	/**
	 * 工具类单例对象
	 */
	StockControllerUtil inst = StockControllerUtil.getInstance();

	/**
	 * http://localhost:8080/stocker-manager/StockController/24/gotoStockerPagesRejectReply
	 * 
	 * @param model
	 * @param purchaseId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "{purchaseId}/gotoStockerPagesRejectReply", method = RequestMethod.GET)
	public String gotoStockerPagesRejectReply(ModelMap model, @PathVariable(value = "purchaseId") Integer purchaseId,
			HttpSession session) {
		System.err.println("Pid==" + purchaseId);

		Integer usrid = getUsridFromSession(session);
		System.err.println("uid===" + usrid);

		Purchase purchase = ips.findPurchaseById(purchaseId, usrid);
		Purchase purchase2 = inst.judgeByPath(purchase, 1);

		model.addAttribute("p", purchase2);

		return "StockerPages/RejectReply";
	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/rejectHandler?purchaseId=28&j=1
	 * 
	 * @param session
	 * @param pid
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "rejectHandler", method = RequestMethod.GET)
	public ResponseResult<Purchase> rejectHandler(HttpSession session, @RequestParam("purchaseId") Integer pid,
			@RequestParam("j") Integer j) {
		System.err.println("PID===" + pid);
		System.err.println("J===" + j);

		Integer usrid = getUsridFromSession(session);
		System.err.println("uid===" + usrid);

		Purchase purchase = ips.findPurchaseById(pid, usrid);

		Purchase purchase2 = inst.judgeByPath(purchase, j);

		return new ResponseResult<Purchase>(SUCCESS, purchase2);

	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/getStockerNameHandler
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getStockerNameHandler", method = RequestMethod.GET)
	public ResponseResult<HashMap<Integer, String>> getStockerNameHandler(HttpSession session) {
		String uname = "";
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		try {
			uname = session.getAttribute("usrname").toString();

			if (uname != null || !"".equals(uname)) {
				map.put(0, uname);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(0, "");
		}

		return new ResponseResult<HashMap<Integer, String>>(SUCCESS, map);
	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/regEntryHandler
	 * 
	 * @param session
	 * @param purchase
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "regEntryHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> regEntryHandler(HttpSession session, Purchase purchase) {
		String operator = getUsrnameFromSession(session);

		System.err.println("stcoker-" + operator);
		System.err.println(purchase);

		Integer affect = iss.regEntry(purchase, operator);
		System.err.println("affect=" + affect);

		inst.regEntryHandlerRecord(operator, affect, purchase);

		return new ResponseResult<Integer>(SUCCESS, affect);

	}

	/**
	 * /stocker-manager/StockController/checkEnterCompetenceHandler
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("checkEnterCompetenceHandler")
	public String checkEnterCompetenceHandler(HttpSession session, ModelMap model) {
		Integer usrid = getUsridFromSession(session);
		System.err.println("UsrID=" + usrid);

		String path = iCommonReplenishService.checkEnterCompetence(usrid, 4, model, "StockerPages/StockerWorkable");

		inst.checkEnterCompetenceHandlerRecord(path, session);

		return path;

	}
}
