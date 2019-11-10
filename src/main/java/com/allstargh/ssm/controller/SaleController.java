package com.allstargh.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.SaleControllerUtil;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ISaleService;
import com.allstargh.ssm.service.IStcokSevice;

/**
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/SaleController")
public class SaleController extends ControllerUtils {
	@Autowired
	private ICommonReplenishService icrs;

	@Autowired
	private ISaleService iss;

	@Autowired
	private IStcokSevice iStcokSevice;

	/**
	 * 懒汉式
	 */
	SaleControllerUtil scu = SaleControllerUtil.getInstance();

	/**
	 * /stocker-manager/SaleController/pagingDisplayHandler?pageth=1
	 * 
	 * @param session
	 * @param pageth
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "pagingDisplayHandler", method = RequestMethod.GET)
	public ResponseResult<Pagination<TSale>> pagingDisplayHandler(HttpSession session,
			@RequestParam(value = "pageth", defaultValue = "0") Integer pageth) {
		System.err.println("pageth==" + pageth);

		Integer uid = getUsridFromSession(session);

		Pagination<TSale> pagination = iss.pagingDisplay(pageth, 3, uid);

		return new ResponseResult<Pagination<TSale>>(SUCCESS, pagination);

	}

	/**
	 * /stocker-manager/SaleController/addHandler
	 * 
	 * @param session
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> addHandler(HttpSession session, TSale data) {
		System.err.println("data:" + data.toString());

		Integer uid = getUsridFromSession(session);

		Integer effect = iss.add(uid, data);

		String username = getUsrnameFromSession(session);
		scu.addHandlerRecord(username, effect);

		return new ResponseResult<Integer>(SUCCESS, effect);
	}

	/**
	 * /stocker-manager/SaleController/foundByStockTypeAreaHandler
	 * 
	 * @param session
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "foundByStockTypeAreaHandler", method = RequestMethod.GET)
	public ResponseResult<List<TStock>> foundByStockTypeAreaHandler(HttpSession session,
			@RequestParam("type") Integer type) {
		Integer uid = getUsridFromSession(session);

		System.err.println("type:" + type);

		List<TStock> list = iStcokSevice.foundByStockTypeArea(uid, type);

		return new ResponseResult<List<TStock>>(SUCCESS, list);

	}

}
