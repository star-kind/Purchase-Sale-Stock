package com.allstargh.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.PurchaseControllerUtil;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.service.IPurchaseService;
import com.allstargh.ssm.service.ex.SelfServiceException;

@Controller
@RequestMapping("/PurchaseController")
public class PurchaseController extends ControllerUtils {
	@Autowired
	private IPurchaseService ips;

	// 工具类
	PurchaseControllerUtil instance = PurchaseControllerUtil.getInstance();

	@Override
	protected void parameterMark(Object... args) {
		super.parameterMark(args);
	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/readSubstanceLogPagingHandler?index=1
	 * 
	 * @param session
	 * @param index
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "readSubstanceLogPagingHandler", method = RequestMethod.GET)
	public ResponseResult<PagingTextII> readSubstanceLogPagingHandler(HttpSession session,
			@RequestParam(value = "index", defaultValue = "0") Integer index) throws SelfServiceException, IOException {
		parameterMark(index);

		Integer uid = getUsridFromSession(session);

		PagingTextII textII = ips.readSubstanceLogPaging(uid, index, 14);

		return new ResponseResult<PagingTextII>(SUCCESS, textII);
	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/exhibitedClassifyNumsHandler
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitedClassifyNumsHandler", method = RequestMethod.GET)
	public ResponseResult<Map<Integer, Integer>> exhibitedClassifyNumsHandler(HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Map<Integer, Integer> map = ips.getNumsByClassify(uid);

		return new ResponseResult<Map<Integer, Integer>>(SUCCESS, map);

	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/exhibitsListByClassifyAndIsAgreeHandler?classify=0
	 * 
	 * @param session
	 * @param classify
	 * @param isAgree
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitsListByClassifyAndIsAgreeHandler", method = RequestMethod.POST)
	public ResponseResult<List<Purchase>> exhibitsListByClassifyAndIsAgreeHandler(HttpSession session,
			@RequestParam("classify") Integer classify,
			@RequestParam(value = "isAgree", defaultValue = "1") Integer isAgree) {
		System.err.println("classify: " + classify + ",is agree: " + isAgree);

		Integer uid = getUsridFromSession(session);

		List<Purchase> arrayList = new ArrayList<Purchase>();

		if (classify == -1) {
			arrayList = ips.getPrepareEnterQueue(1, uid, 1);
		} else {
			arrayList = ips.exhibitsListByClassifyAndIsAgree(uid, classify, isAgree);
		}

		return new ResponseResult<List<Purchase>>(SUCCESS, arrayList);
	}

	/**
	 * 
	 * 
	 * @param session
	 * @param condition
	 * @param parameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "submitToBackstageHandler", method = RequestMethod.POST)
	public ResponseResult<List<Purchase>> submitToBackstageHandler(HttpSession session,
			@RequestParam("condition") String condition, @RequestParam("parameter") String parameter) {
		System.err.println("condition:" + condition + ",parameter:" + parameter);

		String usrname = getUsrnameFromSession(session);

		List<Purchase> list = ips.searchPurchasesByCondition(condition, parameter, usrname);

		return new ResponseResult<List<Purchase>>(SUCCESS, list);
	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/getPurchaseListByTakedAndAgreedHandler
	 * 
	 * @param session
	 * @param agree
	 * @param hasTaked
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getPurchaseListByTakedAndAgreedHandler", method = RequestMethod.GET)
	public ResponseResult<List<Purchase>> getPurchaseListByTakedAndAgreedHandler(HttpSession session,
			@RequestParam(value = "agree", defaultValue = "1") Integer agree,
			@RequestParam(value = "hasTaked", defaultValue = "1") Integer hasTaked) {
		Integer usrid = (Integer) session.getAttribute("usrid");

		List<Purchase> list = ips.getPrepareEnterQueue(hasTaked, usrid, agree);

		return new ResponseResult<List<Purchase>>(SUCCESS, list);

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "jumpToPurchaseTranceLogHandler")
	public String jumpToPurchaseTranceLogHandler() {
		System.err.println("jumpToPurchaseTranceLogHandler");

		return "PurchaseDir/PurchaseTranceLog";

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "jumpToPurchaseWorkableHandler")
	public String jumpToPurchaseWorkableHandler() {
		System.err.println("jumpToPurchaseWorkableHandler");

		return "PurchaseDir/PurchaseWorkable";

	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/readOutputSubstanceLogHandler
	 * 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "readOutputSubstanceLogHandler", method = RequestMethod.GET)
	public ResponseResult<String[]> readOutputSubstanceLogHandler(HttpSession session) throws IOException {
		Integer usrid = (Integer) session.getAttribute("usrid");

		String[] records = ips.readOutputSubstanceLog(usrid);

		return new ResponseResult<String[]>(SUCCESS, records);

	}

	/**
	 * /stocker-manager/PurchaseController/deleteMultiplesPurchaseAppByIdsHandler
	 * 
	 * @param session
	 * @param purchaseIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMultiplesPurchaseAppByIdsHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> deleteMultiplesPurchaseAppByIdsHandler(HttpSession session,
			@RequestParam("purchaseIds") Integer[] purchaseIds) {

		for (int i = 0; i < purchaseIds.length; i++) {
			System.out.print(purchaseIds[i] + ",");
		}

		Integer rows = ips.deleteMultiplesPurchaseAppByIds(purchaseIds);

		String usrname = session.getAttribute("usrname").toString();

		instance.deleteMultiplesPurchaseAppByIdsHandlerLog(usrname, purchaseIds);

		return new ResponseResult<Integer>(SUCCESS, rows);

	}

	/**
	 * /stocker-manager/PurchaseController/deleteSinglePurchaseAppByIdHandler
	 * 
	 * @param purchaseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteSinglePurchaseAppByIdHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> deleteSinglePurchaseAppByIdHandler(HttpSession session,
			@RequestParam("purchaseId") Integer purchaseId) {
		System.out.println("delete argument-" + purchaseId);

		Integer effect = ips.deleteSinglePurchaseAppById(purchaseId);

		String usrname = session.getAttribute("usrname").toString();

		instance.deleteSinglePurchaseAppByIdLog(effect, usrname);

		return new ResponseResult<Integer>(SUCCESS, effect);

	}

	/**
	 * 
	 * @param purchase
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "editOnePurchaseByIdHandler", method = RequestMethod.POST)
	public ResponseResult<Void> editOnePurchaseByIdHandler(Purchase purchase, HttpSession session) {
		System.err.println(purchase);

		String usrname = session.getAttribute("usrname").toString();
		System.out.println("usrname:" + usrname);

		Integer affect = ips.editOnePurchaseById(usrname, purchase);
		System.out.println("affect:" + affect);

		instance.editOnePurchaseByIdHandlerLog(affect, usrname, purchase);

		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/findPurchaseByIdHandler?purchaseId=2
	 * 
	 * @param purchaseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findPurchaseByIdHandler", method = RequestMethod.POST)
	public ResponseResult<Purchase> findPurchaseByIdHandler(@RequestParam("purchaseId") Integer purchaseId,
			HttpSession session) {

		Integer usrid = null;

		try {
			usrid = Integer.valueOf(session.getAttribute("usrid").toString());
		} catch (Exception e) {
			purchaseId = null;
		}

		System.err.println("purchaseId:" + purchaseId + ",usrid:" + usrid);

		Purchase purchase = ips.findPurchaseById(purchaseId, usrid);

		return new ResponseResult<Purchase>(SUCCESS, purchase);
	}

	/**
	 * 提交1份新的采购申请单
	 * 
	 * @param purchase
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addNewPurchaseAppFormHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> addNewPurchaseAppFormHandler(Purchase purchase, HttpSession session) {
		String usrname = session.getAttribute("usrname").toString();
		System.out.println("controller:usrname- " + usrname);
		System.out.println("controller:purchase- " + purchase);

		Integer affect = ips.addOnePurchaseApplicationForm(purchase, usrname);

		// 将提交审请单记录写入文本中
		instance.addNewPurchaseAppFormHandlerLog(usrname, affect);

		return new ResponseResult<Integer>(SUCCESS, affect);

	}

	/**
	 * http://localhost:8080/stocker-manager/PurchaseController/exhibitionAllPurchaseHandler
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionAllPurchaseHandler", method = RequestMethod.GET)
	public ResponseResult<List<Purchase>> exhibitionAllPurchaseHandler(HttpSession session) {

		List<Purchase> list = ips.exhibitsAll();
		if (getUsrnameFromSession(session) == null || ("".equals(getUsrnameFromSession(session)))) {
			list = null;
		}
		return new ResponseResult<List<Purchase>>(SUCCESS, list);

	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionPurchaseByOperatorHandler", method = RequestMethod.GET)
	public ResponseResult<List<Purchase>> exhibitionPurchaseByOperatorHandler(HttpSession session) {
		String operator = session.getAttribute("usrname").toString();
		System.out.println("operator--" + operator);

		List<Purchase> list = ips.exhibitsPurchaseByOperator(operator);
		return new ResponseResult<List<Purchase>>(SUCCESS, list);

	}

	/**
	 * 跳转至采购部模块
	 * 
	 * @param session
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("jumpToPurchaseDeptHandler")
	public String jumpToPurchaseDeptHandler(HttpSession session, ModelMap modelMap) {
		Integer uid = Integer.parseInt(session.getAttribute("usrid").toString());
		System.out.println("userid: " + uid);

		String url = ips.checkOperatorCompetence(uid, modelMap);

		return url;
	}

}