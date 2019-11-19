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
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IOutStockService;

/**
 * 出库
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/OutStockController")
public class OutStockController extends ControllerUtils {
	@Autowired
	private IOutStockService ioss;

	/**
	 * http://localhost:8080/stocker-manager/OutStockController/exhibitionQueueHandler?pageth=1
	 * 
	 * @param session
	 * @param pageth
	 * @param deptNo
	 * @param operate
	 * @param lines
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionQueueHandler", method = RequestMethod.GET)
	public ResponseResult<PaginationII<List<TStock>>> exhibitionQueueHandler(HttpSession session,
			@RequestParam(value = "pageth", defaultValue = "0") Integer pageth,
			@RequestParam(value = "deptNo", defaultValue = "3") Integer deptNo,
			@RequestParam(value = "operate", defaultValue = "1") Integer operate,
			@RequestParam(value = "lines", defaultValue = "4") Integer lines) {
		System.err.println(this.getClass().getName() + ",pageth===");
		System.err.println(pageth);

		Integer uid = getUsridFromSession(session);

		PaginationII<List<TStock>> queue = ioss.exhibitionQueue(uid, deptNo, operate, pageth, lines);

		return new ResponseResult<PaginationII<List<TStock>>>(SUCCESS, queue);
	}

}
