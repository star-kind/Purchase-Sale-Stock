package com.allstargh.ssm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
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
	private IStcokSevice iss;

	@Autowired
	private ICommonReplenishService iCommonReplenishService;

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
	 * @param stock
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "regEntryHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> regEntryHandler(HttpSession session, Purchase purchase, TStock stock) {
		String operator = session.getAttribute("usrname").toString();
		System.err.println("stcoker-" + operator);
		System.err.println(purchase);
		System.err.println(stock);

		Integer affect = iss.regEntry(purchase, stock, operator);
		System.err.println("affect=" + affect);

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
		Integer usrid = Integer.parseInt(session.getAttribute("usrid").toString());
		System.err.println("UsrID=" + usrid);

		String path = iCommonReplenishService.checkEnterCompetence(usrid, 4, model, "StockerPages/StockerWorkable");

		return path;

	}
}
