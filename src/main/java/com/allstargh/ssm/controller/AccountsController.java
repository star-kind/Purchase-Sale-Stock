package com.allstargh.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.controller.kits.AccountControllerUtil;
import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.service.IAccountsService;
import com.allstargh.ssm.service.ICommonReplenishService;

/**
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/account")
public class AccountsController extends ControllerUtils {
	@Autowired
	private IAccountsService iAccountsService;

	@Autowired
	private ICommonReplenishService icrs;

	/**
	 * 
	 */
	protected AccountControllerUtil instance = AccountControllerUtil.getInstance();

	/**
	 * /stocker-manager/account/findAccountByUseridHandler
	 * 
	 * @param session
	 * @param userid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAccountByUseridHandler", method = RequestMethod.GET)
	public ResponseResult<Accounts> findAccountByUseridHandler(HttpSession session,
			@RequestParam("userid") Integer userid) {
		System.err.println(this.getClass().getName() + ",userid===");
		System.err.println(userid);

		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.findAccountByUserid(uid, userid);

		return new ResponseResult<Accounts>(SUCCESS, account);
	}

	/**
	 * /stocker-manager/account/obtainIDAndNamesHandler
	 * 
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "obtainIDAndNamesHandler", method = RequestMethod.GET)
	public String obtainIDAndNamesHandler(HttpSession s, ModelMap model) {
		Integer uid = getUsridFromSession(s);

		HashMap<Integer, String> map = iAccountsService.obtainIDAndNames(uid);

		model.addAttribute("map", map);

		return "ApprovalModule/AllProcessed";
	}

	/**
	 * 
	 * @param accounts
	 * @return
	 */
	@RequestMapping(value = "/reg", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseResult<Void> regHandler(Accounts accounts, HttpSession session) {
		Integer row = iAccountsService.registerRole(accounts);

		instance.inputRegRecordsToTxt(accounts, row, session);

		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * get test:
	 * http://localhost:8080/stocker-manager/account/login?usrname=abc&password=77777
	 * 
	 * @param usrname
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseResult<Void> loginHandler(@RequestParam(value = "usrname", required = false) String usrname,
			@RequestParam(value = "password", required = false) String password, HttpSession session) {
		System.out.println("username=" + usrname + ",password=" + password);

		instance.inputAllLoginRecords(usrname);

		Accounts account = iAccountsService.login(usrname, password, session);

		instance.inputSuccessLoginRecords(account, usrname, session);

		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * 跳转至AdminWorkable模块
	 * 
	 * @param session
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/toAdminWorkable")
	public String toAdminWorkable(HttpSession session, ModelMap modelMap) {
		Integer uid = Integer.parseInt(session.getAttribute("usrid").toString());
		System.out.println("uid: " + uid);

		String url = iAccountsService.checkAdminCompetence(uid, modelMap);

		return url;
	}

	/**
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "showAllAccount", method = { RequestMethod.GET })
	public String showAllAccountHandler(ModelMap modelMap) {
		String r = iAccountsService.browsersAllAccounts(modelMap);
		return r;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "earse", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseResult<Void> earseHandler(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		Integer usrid = Integer.valueOf(request.getParameter("usrid"));
		Integer code = iAccountsService.earseAnAccount(usrid);

		instance.earseAnAccountRecords(usrid, code, session);

		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * 转发等待修改的原旧数据
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "emerge", method = { RequestMethod.GET })
	public String showModifiyHandler(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();

		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		return iAccountsService.showingProfileToEditing(request, modelMap);
	}

	/**
	 * 执行修改简介
	 * 
	 * @param session
	 * 
	 * @param a
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "execute_revamp", method = { RequestMethod.POST })
	public ResponseResult<Void> executModifiyHandler(@RequestParam("usrname") String usrname,
			@RequestParam("phone") String phone, @RequestParam("competence") Integer competence,
			@RequestParam("regionDepartment") Integer regionDepartment, @RequestParam("usrid") Integer usrid,
			HttpSession session) {
		System.out.println(usrname + "," + phone + "," + competence + "," + regionDepartment + "," + usrid);
		Integer affects = iAccountsService.alterAccountProfile(usrname, phone, competence, regionDepartment, usrid);

		instance.executModifiyRecords(usrid, session, affects, usrname, phone, competence, regionDepartment);
		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * 多账户注销
	 * 
	 * @param usrid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "multiple_cancel", method = { RequestMethod.POST })
	public ResponseResult<Integer> multipleCancelHandler(@RequestParam("usrids") Integer[] usrids,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		Integer affects = iAccountsService.multipleCancel(usrids);

		instance.multipleCancelRecords(affects, session, usrids);

		return new ResponseResult<Integer>(SUCCESS, affects);
	}

	/**
	 * 多账户激活
	 * 
	 * @param session
	 * 
	 * @param usrid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "multiple_active", method = { RequestMethod.POST })
	public ResponseResult<Integer> multipleActiveHandler(@RequestParam("usrids") Integer[] usrids,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		Integer affects = iAccountsService.multipleActive(usrids);

		instance.multipleActiveRecords(affects, session, usrids);

		return new ResponseResult<Integer>(SUCCESS, affects);
	}

	/**
	 * 多账户重置密码
	 * 
	 * @param session
	 * 
	 * @param usrid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "multiple_reset_pwd", method = { RequestMethod.POST })
	public ResponseResult<Integer> multipleResetPwdHandler(@RequestParam("usrids") Integer[] usrids,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		Integer affects = iAccountsService.multipleResetPwd(usrids);

		instance.multipleResetRecords(affects, session, usrids);

		return new ResponseResult<Integer>(SUCCESS, affects);
	}

	/**
	 * http://localhost:8080/stocker-manager/account/search_by_threeType_scene?str=长川
	 * 
	 * @param str     地区部门/职位/是否注销激活
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "search_by_threeType_scene", method = { RequestMethod.POST })
	public ResponseResult<List<Accounts>> searchByFourTypeSceneHandler(@RequestParam("str") String str,
			HttpSession session) {
		List<Accounts> list = null;

		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		System.err.println(this.getClass().getName() + ",str==");
		System.err.println(str);

		int p = instance.prospect(str);
		if (p == 0) {
			list = iAccountsService.gainByCompetence(str);
		} else if (p == 1) {
			list = iAccountsService.gainByActiveStatus(str);
		} else {
			list = iAccountsService.gainByRegionDepartment(str);
		}

		return new ResponseResult<List<Accounts>>(SUCCESS, list);
	}

	/**
	 * http://localhost:8080/stocker-manager/account/search_by_confuse_name?uname=ck
	 * 
	 * @param uname   残缺的只言
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "search_by_confuse_name", method = { RequestMethod.POST })
	public ResponseResult<List<Accounts>> searchByConfuseNameHandler(@RequestParam("uname") String uname,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		System.err.println("Uname:" + uname);

		List<Accounts> list = iAccountsService.findBaseOnLikeName(uname);
		return new ResponseResult<List<Accounts>>(SUCCESS, list);
	}

	/**
	 * http://localhost:8080/stocker-manager/account/single/30/reset_pwd
	 * 
	 * 单个账号重置密码
	 * 
	 * @param usrid
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "single/{usrid}/reset_pwd", method = RequestMethod.GET)
	public ResponseResult<Void> singleRestorePwdHandler(@PathVariable("usrid") Integer usrid, HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		System.out.println(this.getClass().getName() + "reset-usrid:");
		System.err.println(usrid);

		Integer[] ids = new Integer[1];
		ids[0] = usrid;

		Integer effects = iAccountsService.multipleResetPwd(ids);

		instance.multipleResetRecords(effects, session, ids);
		return new ResponseResult<Void>(SUCCESS);
	}

	/**
	 * 注销单个账号
	 * 
	 * @param usrid
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "single/{usrid}/cancel", method = RequestMethod.GET)
	public ResponseResult<Integer> singleCancelAccountHandler(@PathVariable("usrid") Integer usrid,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		System.out.println("cancel-usrid:" + usrid);

		Integer[] ids = new Integer[1];
		ids[0] = usrid;

		Integer effects = iAccountsService.multipleCancel(ids);

		instance.multipleCancelRecords(effects, session, ids);
		return new ResponseResult<Integer>(SUCCESS, effects);
	}

	/**
	 * 激活单个账号
	 * 
	 * @param usrid
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "single/{usrid}/active", method = RequestMethod.GET)
	public ResponseResult<Integer> singleActiveAccountHandler(@PathVariable("usrid") Integer usrid,
			HttpSession session) {
		Integer uid = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid);

		boolean b = icrs.checkForAccount(account, 0);

		Integer[] ids = new Integer[1];
		ids[0] = usrid;

		Integer effects = iAccountsService.multipleActive(ids);

		instance.multipleActiveRecords(effects, session, ids);
		return new ResponseResult<Integer>(SUCCESS, effects);
	}

	/**
	 * http://localhost:8080/stocker-manager/account/read_substacne
	 * 
	 * 读取系统日志内容
	 * 
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "read_substacne", method = RequestMethod.GET)
	public ResponseResult<PagingTextII> readAccountRecordHandler(HttpSession session,
			@RequestParam(value = "index", defaultValue = "0") Integer index) throws IOException {
		Integer uid01 = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid01);

		boolean b = icrs.checkForAccount(account, 0);

		Integer uid = Integer.parseInt(session.getAttribute("usrid").toString());

		System.err.println(this.getClass().getName() + ",index===");
		System.err.println(index);

		PagingTextII text = iAccountsService.readSubstanceLog(uid, index, 12);

		return new ResponseResult<PagingTextII>(SUCCESS, text);
	}

	/**
	 * http://localhost:8080/stocker-manager/account/revisePasswordHandler?oldPassword=6644&newPassword=7788
	 * 
	 * @param session
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "revisePasswordHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> revisePasswordHandler(HttpSession session,
			@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
		Integer uid01 = getUsridFromSession(session);

		Accounts account = iAccountsService.gainAccount(uid01);

		// boolean b = icrs.checkForAccount(account, 0);

		Integer uid = Integer.parseInt(session.getAttribute("usrid").toString());

		Integer effects = iAccountsService.revisePassword(oldPassword, newPassword, uid);

		instance.revisePasswordHandlerRecord(uid, effects);

		return new ResponseResult<Integer>(SUCCESS, effects);
	}

	/**
	 * 展示用户资料
	 * 
	 * /stocker-manager/account/exhibitionBaseProfileHandler
	 * 
	 * @param s
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "exhibitionBaseProfileHandler", method = RequestMethod.GET)
	public ResponseResult<Accounts> exhibitionBaseProfileHandler(HttpSession s) {
		Integer uid01 = getUsridFromSession(s);

		Accounts account = iAccountsService.gainAccount(uid01);

		// boolean b = icrs.checkForAccount(account, 0);

		Integer uid = Integer.parseInt(s.getAttribute("usrid").toString());

		Accounts profile = iAccountsService.exhibitionBaseProfile(uid);

		return new ResponseResult<Accounts>(SUCCESS, profile);
	}

	/**
	 * 修改用户基本资料
	 * 
	 * @param s
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "reviseBaseProfileHandler", method = RequestMethod.POST)
	public ResponseResult<Integer> reviseBaseProfileHandler(HttpSession s, @RequestParam("usrname") String usrname,
			@RequestParam("phone") String phone) {
		Integer uid01 = getUsridFromSession(s);

		Accounts account = iAccountsService.gainAccount(uid01);

		// boolean b = icrs.checkForAccount(account, 0);

		Integer uid = Integer.parseInt(s.getAttribute("usrid").toString());

		parameterMark(usrname, phone);

		Integer affects = iAccountsService.reviseBaseProfile(usrname, phone, uid);

		return new ResponseResult<Integer>(SUCCESS, affects);
	}

	@Override
	protected void parameterMark(Object... args) {
		super.parameterMark(args);
	}

}
