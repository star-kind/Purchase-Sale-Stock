package com.allstargh.ssm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.allstargh.ssm.pojo.PagingText;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IPurchaseService;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.util.StockServiceUtil;

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
	 * 工具类单例对象:控制器层
	 */
	StockControllerUtil inst = StockControllerUtil.getInstance();

	/**
	 * 工具类单例对象:服务层
	 */
	StockServiceUtil serviceUtil = StockServiceUtil.getInstance();

	/**
	 * [------------------------------------------------------------------------]
	 */

	/**
	 * /stocker-manager/StockController/getStoreAuantityByIDHandler
	 * 
	 * @param session
	 * @param sid
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "getStoreAuantityByIDHandler", method = RequestMethod.GET)
	public ResponseResult<Integer> getStoreAuantityByIDHandler(HttpSession session, @RequestParam("sid") Integer sid)
			throws SelfServiceException, IOException {
		Integer uid = getUsridFromSession(session);

		Integer quantity = iss.getStoreAuantityByID(uid, sid);

		return new ResponseResult<Integer>(SUCCESS, quantity);

	}

	/**
	 * /stocker-manager/StockController/readDailyLogHandler
	 * 
	 * @param session
	 * @return
	 * @throws IOException
	 * @throws SelfServiceException
	 */
	@ResponseBody
	@RequestMapping(value = "readDailyLogHandler", method = RequestMethod.POST)
	public ResponseResult<String[]> readDailyLogHandler(HttpSession session) throws SelfServiceException, IOException {
		Integer uid = getUsridFromSession(session);

		String[] dailyLog = iss.readDailyLog(uid);

		return new ResponseResult<String[]>(SUCCESS, dailyLog);

	}

	/**
	 * /stocker-manager/StockController/readDailyLogHandlerPlus
	 * 
	 * @param session
	 * @param pageNum
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "readDailyLogHandlerPlus", method = RequestMethod.POST)
	public ResponseResult<PagingText> readDailyLogHandlerPlus(HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum)
			throws SelfServiceException, IOException {
		Integer uid = getUsridFromSession(session);

		PagingText text = iss.readDailyLog(uid, pageNum);

		return new ResponseResult<PagingText>(SUCCESS, text);

	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/foundByTypeAreaHandler?areaOrder=0
	 * 
	 * @param session
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "foundByTypeAreaHandler", method = RequestMethod.GET)
	public ResponseResult<List<TStock>> foundByTypeAreaHandler(HttpSession session,
			@RequestParam("areaOrder") Byte areaOrder) throws UnsupportedEncodingException {
		Integer usrid = getUsridFromSession(session);

		List<TStock> list = new ArrayList<TStock>();

		if ((areaOrder != null || !"".equals(areaOrder)) && areaOrder != 10) {
			list = iss.foundByTypeArea(usrid, areaOrder);

		} else if (areaOrder == 10) {
			list = iss.findAll(usrid);

		}

		return new ResponseResult<List<TStock>>(SUCCESS, list);
	}

	/**
	 * /stocker-manager/StockController/modifiedStoreGoodHandler
	 * 
	 * @param session
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "modifiedStoreGoodHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> modifiedStoreGoodHandler(HttpSession session, HttpServletRequest request)
			throws UnsupportedEncodingException {
		Integer usrid = getUsridFromSession(session);

		String dataStr = URLDecoder.decode(request.getParameter("tStock"), "UTF-8");
		System.err.println(dataStr);

		Integer affected = iss.modifiedStoreGood(usrid, dataStr);

		String usrname = getUsrnameFromSession(session);

		HashMap<String, String> map = serviceUtil.generateMapImprove(dataStr);

		inst.modifiedStoreGoodHandlerRecord(usrname, affected, map);

		return new ResponseResult<Integer>(SUCCESS, affected);
	}

	/**
	 * /stocker-manager/StockController/findTStockByPurchaseIdHandler
	 * 
	 * @param session
	 * @param purchaseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findTStockByPurchaseIdHandler", method = RequestMethod.GET)
	public ResponseResult<TStock> findTStockByPurchaseIdHandler(HttpSession session,
			@RequestParam("purchaseId") Integer purchaseId) {
		Integer usrid = getUsridFromSession(session);
		System.err.println("PID==" + purchaseId);

		TStock tStock = iss.findTStockByPurchaseId(purchaseId, usrid);

		return new ResponseResult<TStock>(SUCCESS, tStock);

	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/getAllStoreHandler
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllStoreHandler", method = RequestMethod.GET)
	public ResponseResult<List<TStock>> getAllStoreHandler(HttpSession session) {
		Integer usrid = getUsridFromSession(session);

		List<TStock> list = iss.findAll(usrid);

		return new ResponseResult<List<TStock>>(SUCCESS, list);

	}

	/**
	 * /stocker-manager/StockController/regToExternalHandler
	 * 
	 * @param session
	 * @param formData
	 * @param textArea
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "regToExternalHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> regToExternalHandler(HttpSession session, HttpServletRequest req)
			throws UnsupportedEncodingException {
		String operator = getUsrnameFromSession(session);
		System.err.println("stcoker:" + operator);

		String formData = URLDecoder.decode(req.getParameter("formData"), "UTF-8");
		String textArea = req.getParameter("textArea");
		System.err.println(textArea);
		System.err.println(formData);

		Integer effect = iss.regToExternal(formData, operator, textArea);

		return new ResponseResult<Integer>(SUCCESS, effect);
	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/24/gotoStockerPagesRejectReply
	 * 
	 * @param model
	 * @param purchaseId
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "{purchaseId}/gotoStockerPagesRejectReply", method = RequestMethod.GET)
	public String gotoStockerPagesRejectReply(ModelMap model, @PathVariable(value = "purchaseId") Integer purchaseId,
			HttpServletRequest request, HttpSession session) {
		System.err.println("Pid==" + purchaseId);

		Integer usrid = getUsridFromSession(session);
		System.err.println("uid===" + usrid);

		Purchase purchase = ips.findPurchaseById(purchaseId, usrid);
		Purchase purchase2 = inst.judgeByPath(purchase, request.getServletPath());
		System.err.println("purchase2:" + purchase2);

		model.addAttribute("p", purchase2);

		return "StockerPages/RejectReply";
	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/rejectHandler
	 * 
	 * @param session
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "rejectHandler", method = RequestMethod.POST)
	public ResponseResult<Purchase> rejectHandler(HttpSession session, HttpServletRequest req) {
		Integer purchaseId = Integer.valueOf(req.getParameter("purchaseId"));
		System.err.println("PID===" + purchaseId);

		System.err.println("req==" + req.getServletPath());

		Integer usrid = getUsridFromSession(session);
		System.err.println("uid===" + usrid);

		Purchase purchase = ips.findPurchaseById(purchaseId, usrid);

		Purchase purchase2 = inst.judgeByPath(purchase, req.getServletPath());

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

	/**
	 * http://localhost:8080/stocker-manager/StockController/SubQueue
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("SubQueue")
	public String wentToSubQueue(HttpServletRequest request, HttpSession session) {
		Integer id = getUsridFromSession(session);

		String uri = inst.getSuffixByServletPath(request.getServletPath());

		String string = "StockerPages/";
		string += iCommonReplenishService.checkEnterCompetence(id, 4, uri);

		return string;

	}

	/**
	 * http://localhost:8080/stocker-manager/StockController/DataTables
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("DataTables")
	public String toDataTables(HttpServletRequest request, HttpSession session) {
		Integer id = getUsridFromSession(session);

		String uri = inst.getSuffixByServletPath(request.getServletPath());

		String string = "StockerPages/";
		string += iCommonReplenishService.checkEnterCompetence(id, 4, uri);

		return string;

	}

	/**
	 * 通用访问跳转
	 * 
	 * http://localhost:8080/stocker-manager/StockController/{cipher}/commonInterviewHandler
	 * http://localhost:8080/stocker-manager/StockController/38-10-4-10-30-10-23-18-2-11/commonInterviewHandler
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("{cipher}/commonInterviewHandler")
	public String commonInterviewHandler(HttpSession session, @PathVariable(value = "cipher") String cipher) {
		Integer id = getUsridFromSession(session);

		System.err.println("cipher===" + cipher);
		String tail = inst.reduceByCharIndex(cipher);

		String str = "StockerPages/";
		str += iCommonReplenishService.checkEnterCompetence(id, 4, tail);
		System.err.println("return uri str: " + str);

		return str;

	}

}
