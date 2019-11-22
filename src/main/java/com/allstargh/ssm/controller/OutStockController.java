package com.allstargh.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.controller.kits.OutStockControllerUtil;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.JointStockVO;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;

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

	@Autowired
	private IStcokSevice iss;

	OutStockControllerUtil inst = OutStockControllerUtil.getInstance();

	@Override
	protected void parameterMark(Object... args) {
		super.parameterMark(args);
	}

	/**
	 * 分页读取文本控制器 <br>
	 * /stocker-manager/OutStockController/readTextOnLimitHandler?pageth=2
	 * 
	 * @param session
	 * @param pageth
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "readTextOnLimitHandler", method = RequestMethod.GET)
	public ResponseResult<PagingTextII> readTextOnLimitHandler(HttpSession session,
			@RequestParam(value = "pageth", defaultValue = "0") Integer pageth)
			throws SelfServiceException, IOException {
		parameterMark(pageth);

		Integer uid = getUsridFromSession(session);

		PagingTextII textII = ioss.readTextOnLimit(uid, pageth, 13);

		return new ResponseResult<PagingTextII>(SUCCESS, textII);
	}

	/**
	 * 删除亦是出仓<br>
	 * /stocker-manager/OutStockController/deleteOutHandler
	 * 
	 * @param session
	 * @param array
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteOutHandler", method = RequestMethod.POST)
	protected ResponseResult<Integer> deleteOutHandler(HttpSession session, @RequestParam("array") Long[] array) {
		parameterMark(array);

		Integer uid = getUsridFromSession(session);

		Integer affects = iss.deleteByMultiID(uid, array);

		// 写入自设日志
		String uname = getUsrnameFromSession(session);
		inst.deleteOutHandlerRecords(array, uname, affects);

		return new ResponseResult<Integer>(SUCCESS, affects);
	}

	/**
	 * /stocker-manager/OutStockController/addOutHandler
	 * 
	 * @param session
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addOutHandler", method = RequestMethod.POST)
	protected ResponseResult<Integer> addOutHandler(HttpSession session, JointStockVO bean) {
		System.err.println(this.getClass().getName() + ",vo===");
		System.err.println(bean);

		Integer uid = getUsridFromSession(session);

		Integer effect = ioss.addOut(uid, bean);

		// 写入自设日志
		String uname = getUsrnameFromSession(session);
		inst.addOutHandlerRecord(uname, effect, bean.getStockerIsAgree(), bean.getRemark());

		return new ResponseResult<Integer>(SUCCESS, effect);
	}

	/**
	 * http://localhost:8080/stocker-manager/OutStockController/gainDataBySidHandler?sid=20
	 * 
	 * @param session
	 * @param pageth
	 * @param deptNo
	 * @param operate
	 * @param lines
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "gainDataBySidHandler", method = RequestMethod.GET)
	public ResponseResult<List<JointStockVO>> gainDataBySidHandler(HttpSession session,
			@RequestParam(value = "sid") Integer sid) {
		System.err.println(this.getClass().getName() + ",sid===");
		System.err.println(sid);

		Integer uid = getUsridFromSession(session);

		List<JointStockVO> data = ioss.gainJointData(uid, sid);

		return new ResponseResult<List<JointStockVO>>(SUCCESS, data);
	}

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

	/**
	 * http://localhost:8080/stocker-manager/OutStockController/exhibitionQueueHandler01?pageth=1
	 * 
	 * @param session
	 * @param pageth
	 * @param deptNo
	 * @param operate
	 * @param lines
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionQueueHandler01", method = RequestMethod.GET)
	public ResponseResult<PaginationII<List<AssociativeEntity>>> exhibitionQueueHandler01(HttpSession session,
			@RequestParam(value = "pageth", defaultValue = "0") Integer pageth,
			@RequestParam(value = "deptNo", defaultValue = "3") Integer deptNo,
			@RequestParam(value = "operate", defaultValue = "1") Integer operate,
			@RequestParam(value = "lines", defaultValue = "4") Integer lines) {
		System.err.println(this.getClass().getName() + ",pageth===");
		System.err.println(pageth);

		Integer uid = getUsridFromSession(session);

		PaginationII<List<AssociativeEntity>> queue = ioss.exhibitionQueuePlus(uid, deptNo, operate, pageth, lines);

		return new ResponseResult<PaginationII<List<AssociativeEntity>>>(SUCCESS, queue);
	}

}
