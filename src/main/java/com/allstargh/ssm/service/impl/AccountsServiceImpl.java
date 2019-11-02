package com.allstargh.ssm.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.allstargh.ssm.controller.kits.AccountControllerUtil;
import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.IAccountsService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;
import com.allstargh.ssm.service.util.AccountServiceUtil;

@Service
public class AccountsServiceImpl implements IAccountsService {
	@Autowired
	private AccountsMapper accountsMapper;

	// 默认密码
	private static String DEFAULT_KEY = "666";

	public ServiceExceptionEnum instance = ServiceExceptionEnum.getInstance();

	protected AccountServiceUtil asu = AccountServiceUtil.getInstance();

	@Override
	public Integer registerRole(Accounts accounts) throws SelfServiceException {
		System.out.println(accounts.toString());

		// 提取检查用户名是否唯一
		String usrname = accounts.getUsrname();
		Accounts accounts1 = accountsMapper.selectByUname(usrname);
		if (accounts1 != null) {
			String description = ServiceExceptionEnum.UNAME_DUPLICATE_CONFLICT.getDescription();
			throw new SelfServiceException(description);
		}

		// 时间设默值
		Date date = new Date();
		accounts.setRegTime(date);
		accounts.setModifiedTime(date);
		// 激活状态默值1
		accounts.setActiveStatus(1);

		// 查询此电话所绑定之账户数量,并以此判断是否可注册
		String phone = accounts.getPhone();
		int i = accountsMapper.countUidByPhone(phone);
		if (i > 1) {
			String description = ServiceExceptionEnum.COUNT_PHONE_OUT_RANGE.getDescription();
			throw new SelfServiceException(description);
		}

		// 统计注册账号提交之数据个数是否为4
		Integer m = asu.checkCommittedAccounts(accounts);
		if (m != 4) {
			String description = ServiceExceptionEnum.SUBMIT_DATA_UNCOMPLETELY.getDescription();
			throw new SelfServiceException(description);
		}

		// 生成盐值
		String salt = asu.extractSalt();

		// 代入常量加盐+MD5混合,生成密文
		String generate = asu.generate(DEFAULT_KEY, salt);

		// 密盐设值
		accounts.setSalt(salt);
		accounts.setPassword(generate);

		// 若提交之权限＞5，则为5
		if (accounts.getCompetence() > 5) {
			accounts.setCompetence(5);
		}

		// 执行映射
		Integer row = accountsMapper.insertIntoAccounts(accounts);

		return row;
	}

	@Override
	public Accounts login(String usrname, String password, HttpSession session) throws SelfServiceException {
		// 抛异常:用户名或密码为空
		if (usrname == null || "".equals(usrname) || "springmvc".equals(usrname) || password == null
				|| "".equals(password) || "springmvc".equals(password)) {
			String description = ServiceExceptionEnum.UNAME_OR_KWD_NOT_INPUT.getDescription();
			throw new SelfServiceException(description);
		}

		// 据用户名查数据,为空报异常
		Accounts accounts = accountsMapper.selectByUname(usrname);

		if (accounts == null) {
			String description = ServiceExceptionEnum.USRNAME_ERR.getDescription();
			throw new SelfServiceException(description);
		}

		// 获取数据库中的密码原文
		String text = accounts.getPassword();

		// 登录密码与密码原文代入verify中,为假则报异常
		boolean verify = asu.verify(password, text);
		if (verify == false) {
			String description = ServiceExceptionEnum.KEYWORD_ERR.getDescription();
			throw new SelfServiceException(description);
		}

		// 验证激活态是否为1 or 0
		if (accounts.getActiveStatus() == 0) {
			String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
			throw new SelfServiceException(description);
		}

		// 保存至session
		session.setAttribute("usrname", accounts.getUsrname());
		session.setAttribute("usrid", accounts.getUsrid());

		System.out.println("登录成功");
		return accounts;

	}

	@Override
	public String browsersAllAccounts(ModelMap model) {
		List<Accounts> accounts = accountsMapper.selectAllFromAccounts();
		model.addAttribute("list", accounts);
		return "AdminWorkable";
	}

	@Override
	public Integer earseAnAccount(Integer usrid) throws SelfServiceException {
		Integer row = accountsMapper.deleteOneUsrByUsrid(usrid);
		if (row != 1) {
			String description = ServiceExceptionEnum.SYSTEM_BUSY.getDescription();
			throw new SelfServiceException(description);
		}
		return row;
	}

	@Override
	public Accounts gainAccount(Integer usrid) throws SelfServiceException {
		return accountsMapper.selectAccountByUsrid(usrid);
	}

	@Override
	public Integer alterAccountProfile(String usrname, String phone, Integer competence, Integer regionDepartment,
			Integer usrid) throws SelfServiceException {
		Accounts a1 = new Accounts();
		a1.setUsrname(usrname);
		a1.setPhone(phone);
		a1.setCompetence(competence);
		a1.setRegionDepartment(regionDepartment);

		// 前台提交之信息不全
		Integer m = asu.checkCommittedAccounts(a1);
		if (m != 4) {
			String description = ServiceExceptionEnum.SUBMIT_DATA_UNCOMPLETELY.getDescription();
			throw new SelfServiceException(description);
		}

		// 用户名不得重复
		Accounts a = accountsMapper.selectByUname(usrname);
		if (a != null) {
			String description = ServiceExceptionEnum.UNAME_DUPLICATE_CONFLICT.getDescription();
			throw new SelfServiceException(description);
		}

		// 绑定电话不得超限
		int i = accountsMapper.countUidByPhone(phone);
		if (i > 3) {
			String description = ServiceExceptionEnum.COUNT_PHONE_OUT_RANGE.getDescription();
			throw new SelfServiceException(description);
		}

		// 执行update
		Integer r = accountsMapper.updateAccountProfileByUsrid(usrname, phone, competence, regionDepartment, new Date(),
				usrid);

		return r;
	}

	@Override
	public String showingProfileToEditing(HttpServletRequest request, ModelMap modelMap) {
		Integer usrid = Integer.parseInt(request.getParameter("aid"));
		System.out.println("userid:" + usrid);
		String path = request.getContextPath();
		System.out.println("path:" + path);

		Accounts account = gainAccount(usrid);
		if (account == null) {
			System.err.println("that was incredible");
		}

		modelMap.addAttribute("accounts", account);
		return "ShowEditingProfile";
	}

	@Override
	public Integer multipleCancel(Integer[] ids) {
		return accountsMapper.batchSetCancelByUsrid(ids);
	}

	@Override
	public Integer multipleActive(Integer[] ids) {
		return accountsMapper.batchSetActiveByUsrid(ids);
	}

	@Override
	public Integer multipleResetPwd(Integer[] ids) {
		Integer effects = 0;

		// 循环取出盐值,循环生成密文,循环执行update
		for (int i = 0; i < ids.length; i++) {
			String salt = accountsMapper.selectAccountByUsrid(ids[i]).getSalt();
			System.out.println("salt:" + salt);

			String keyContext = asu.generate(DEFAULT_KEY, salt);
			System.out.println("keyContext:" + keyContext);

			effects += accountsMapper.updatePasswordByUsrid(keyContext, ids[i]);
		}

		return effects;
	}

	@Override
	public List<Accounts> gainByRegionDepartment(String regionDepartment) {
		Integer dept = asu.getNumRegionDepartment(regionDepartment);

		List<Accounts> list = accountsMapper.selectByRegionDepartmentBySingleNum(dept);
		return list;
	}

	@Override
	public List<Accounts> gainByCompetence(String position) {
		Integer competence = asu.switchBySelectCompetence(position);

		return accountsMapper.selectByCompetence(competence);
	}

	@Override
	public List<Accounts> gainByActiveStatus(String status) {
		Integer activeStatus = asu.statusStringTransToActiveStatus(status);
		return accountsMapper.selectByActiveStatus(activeStatus);
	}

	@Override
	public List<Accounts> findBaseOnLikeName(String name) throws SelfServiceException {
		List<Accounts> list = accountsMapper.selectLikeUsrname(name);
		if (list == null) {
			String description = ServiceExceptionEnum.NO_RESULT_RECORD.getDescription();
			throw new SelfServiceException(description);
		}
		return list;
	}

	@Override
	public List<String> readSubstanceFromLog(Integer usrid) throws IOException, SelfServiceException {
		Accounts accounts = accountsMapper.selectAccountByUsrid(usrid);

		if (usrid == null) {
			String desc = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(desc);

		} else if (accounts.getCompetence() != 0) {
			String desc = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(desc);

		}

		String s = null;

		File file = new File(AccountControllerUtil.ACCOUNT_FILE_URI);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		// available可获得的,此处获得的是所读取到的字节数
		int i = bis.available();
		try {// 物质,基本内容,主旨,要点,实质
				// 创建一个字节数组
			byte[] substantce = new byte[i];

			// 把读到的内容载入字节数组
			bis.read(substantce);

			String string = new String(substantce);
			s = string;

			// 若果超限,先删除,在创建一个相同的;一个汉字=2byte,1kb=1024byte
			if (i > 5 * 1024) {
				file.delete();
				file.createNewFile();
			}

		} finally {
			bis.close();
		}

		LinkedList<String> list = new LinkedList<String>();

		list.add(s);

		return list;
	}

	@Override
	public Integer revisePassword(String old, String trueNew, Integer uid) throws SelfServiceException {
		// 检出藏中密码
		Accounts accounts = accountsMapper.selectAccountByUsrid(uid);
		String tablePwd = accounts.getPassword();

		// 检验旧密码与藏中一致
		boolean verify = asu.verify(old, tablePwd);
		if (!verify) {
			String description = ServiceExceptionEnum.KEYWORD_ERR.getDescription();
			throw new SelfServiceException(description);
		}

		// 将取盐
		String salt = accounts.getSalt();

		String text = asu.generate(trueNew, salt);

		Integer affect = accountsMapper.updatePasswordByUsrid(text, uid);

		return affect;
	}

	@Override
	public Integer reviseBaseProfile(String usrname, String phone, Integer usrid) throws SelfServiceException {
		Accounts account = accountsMapper.selectByUname(usrname);
		if (account != null) {
			String description = ServiceExceptionEnum.UNAME_DUPLICATE_CONFLICT.getDescription();
			throw new SelfServiceException(description);
		}

		// 禁止提交之绑定之电话号码过3
		var i = accountsMapper.countUidByPhone(phone);
		if (i > 3) {
			String description = ServiceExceptionEnum.COUNT_PHONE_OUT_RANGE.getDescription();
			throw new SelfServiceException(description);
		}

		Integer effect = accountsMapper.updatePartialProfileById(usrname, phone, usrid);

		return effect;
	}

	@Override
	public Accounts exhibitionBaseProfile(Integer uid) throws SelfServiceException {
		Accounts acc = null;
		if (uid != null) {
			acc = accountsMapper.selectAccountByUsrid(uid);
		}

		return acc;
	}

	@Override
	public String checkAdminCompetence(Integer uid, ModelMap model) {
		Accounts acc = accountsMapper.selectAccountByUsrid(uid);
		Integer competence = acc.getCompetence();
		Integer status = acc.getActiveStatus();

		if (competence != 0) {
			model.addAttribute("info", "您没有相应权限,不是该部门人员,无权入此模块");
			return "Transfer";
		}

		if (status == 0) {
			model.addAttribute("information", "您的账号已被注销,请联系系统管理员处理");
			return "Transfer";
		}

		return "AdminWorkable";
	}

}