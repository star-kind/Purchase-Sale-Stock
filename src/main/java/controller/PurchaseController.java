package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import controller.kits.ControllerToolKit;
import controller.kits.PurchaseControllerUtil;
import json.ResponseResult;
import pojo.Purchase;
import service.IPurchaseService;

@Controller
@RequestMapping("/PurchaseController")
public class PurchaseController extends ControllerToolKit {
	@Autowired
	private IPurchaseService ips;

	// 工具类
	protected PurchaseControllerUtil instance = PurchaseControllerUtil.getInstance();

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
	public ResponseResult<List<Purchase>> exhibitionAllPurchaseHandler() {
		List<Purchase> list = ips.exhibitsAll();

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