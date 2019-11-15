package com.allstargh.ssm.controller.kits;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.service.IOutStockService;

@RequestMapping("/OutWareHouseController")
@Controller
public class OutWareHouseController extends ControllerUtils {
	@Autowired
	private IOutStockService ioss;

	/**
	 * http://localhost:8080/stocker-manager/OutWareHouseController/getToutProfileByIdHandler?sid=1
	 * 
	 * @param session
	 * @param sid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getToutProfileByIdHandler", method = RequestMethod.GET)
	public ResponseResult<TOut> getToutProfileByIdHandler(HttpSession session, @RequestParam("sid") Integer sid) {
		System.err.println(this.getClass().getName() + ",sid===");
		System.err.println(sid);

		Integer uid = getUsridFromSession(session);

		TOut tOut = ioss.getToutProfileById(uid, sid);

		return new ResponseResult<TOut>(SUCCESS, tOut);
	}

}
