package service.impl;

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

import mapper.AccountsMapper;
import pojo.Accounts;
import service.AccountsService;
import service.ex.CanceledAccountException;
import service.ex.CountPhoneOutRangeException;
import service.ex.DeleteAccountDefeatException;
import service.ex.KeywordErrException;
import service.ex.NoResultRecordException;
import service.ex.SelfServiceException;
import service.ex.SubmitDataUnCompletelyException;
import service.ex.UnameDuplicateConflictExcept;
import service.ex.UnameOrKeyIsNullException;
import service.ex.UsrnameErrException;
import service.util.AccountServiceUtil;

@Service
public class AccountsServiceImpl implements AccountsService {
	@Autowired
	private AccountsMapper accountsMapper;

	// 默认密码
	private static String DEFAULT_KEY = "666";

	@Override
	public Integer registerRole(Accounts accounts) throws SelfServiceException {
		AccountServiceUtil util = new AccountServiceUtil();

		System.out.println(accounts.toString());

		// 提取检查用户名是否唯一
		String usrname = accounts.getUsrname();
		Accounts accounts1 = accountsMapper.selectByUname(usrname);
		if (accounts1 != null) {
			throw new UnameDuplicateConflictExcept("sorry,此名已有人先用,请另换名字");
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
		if (i > 3) {
			throw new CountPhoneOutRangeException("sorry,1个电话至多只准绑定注册3个账户");
		}

		// 统计注册账号提交之数据个数是否为4
		Integer m = util.checkCommittedAccounts(accounts);
		if (m != 4) {
			throw new SubmitDataUnCompletelyException("sorry,您尚未填完信息");
		}

		// 生成盐值
		String salt = util.extractSalt();

		// 代入常量加盐+MD5混合,生成密文
		String generate = util.generate(DEFAULT_KEY, salt);

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
		AccountServiceUtil util = new AccountServiceUtil();

		// 抛异常:用户名或密码为空
		if (usrname == null || "".equals(usrname) || "springmvc".equals(usrname) || password == null || "".equals(password)
				|| "springmvc".equals(password)) {
			throw new UnameOrKeyIsNullException("用户名或密码未输入");
		}

		// 据用户名查数据,为空报异常
		Accounts accounts = accountsMapper.selectByUname(usrname);

		if (accounts == null) {
			throw new UsrnameErrException("用户名错误,无此用户名");
		}

		// 获取数据库中的密码原文和盐
		String salt = accounts.getSalt();
		String text = accounts.getPassword();

		// 登录密码与密码原文代入verify中,为假则报异常
		boolean verify = util.verify(password, text);
		if (verify == false) {
			throw new KeywordErrException("密码错误,请检查密码无误后再登录");
		}

		// 验证激活态是否为1 or 0
		if (accounts.getActiveStatus() == 0) {
			throw new CanceledAccountException("您的账号已被注销,请联络管理员重新激活");
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
			throw new DeleteAccountDefeatException("系统繁忙,请稍后重试");
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
		AccountServiceUtil util = new AccountServiceUtil();

		Accounts a1 = new Accounts();
		a1.setUsrname(usrname);
		a1.setPhone(phone);
		a1.setCompetence(competence);
		a1.setRegionDepartment(regionDepartment);

		// 前台提交之信息不全
		Integer m = util.checkCommittedAccounts(a1);
		if (m != 4) {
			throw new SubmitDataUnCompletelyException("sorry,您尚未填完信息");
		}

		// 用户名不得重复
		Accounts a = accountsMapper.selectByUname(usrname);
		if (a != null) {
			throw new UnameDuplicateConflictExcept("sorry,此名已有人先用,请另换名字");
		}

		// 绑定电话不得超限
		int i = accountsMapper.countUidByPhone(phone);
		if (i > 3) {
			throw new CountPhoneOutRangeException("sorry,1个电话至多只准绑定注册3个账户");
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
		AccountServiceUtil util = new AccountServiceUtil();
		Integer effects = 0;

		// 循环取出盐值,循环生成密文,循环执行update
		for (int i = 0; i < ids.length; i++) {
			String salt = accountsMapper.selectAccountByUsrid(ids[i]).getSalt();
			System.out.println("salt:" + salt);

			String keyContext = util.generate(DEFAULT_KEY, salt);
			System.out.println("keyContext:" + keyContext);

			effects += accountsMapper.updatePasswordByUsrid(keyContext, ids[i]);
		}

		return effects;
	}

	@Override
	public List<Accounts> gainByRegionDepartment(String regionDepartment) {
		AccountServiceUtil util = new AccountServiceUtil();
		Integer[] arr = util.switchBaseOnRegionDepartment(regionDepartment);

		List<Accounts> list = accountsMapper.selectByRegionDepartment(arr[0], arr[1]);
		return list;
	}

	@Override
	public List<Accounts> gainByCompetence(String position) {
		AccountServiceUtil util = new AccountServiceUtil();
		Integer competence = util.switchBySelectCompetence(position);

		return accountsMapper.selectByCompetence(competence);
	}

	@Override
	public List<Accounts> gainByActiveStatus(String status) {
		AccountServiceUtil util = new AccountServiceUtil();
		Integer activeStatus = util.statusStringTransToActiveStatus(status);
		return accountsMapper.selectByActiveStatus(activeStatus);
	}

	@Override
	public List<Accounts> findBaseOnLikeName(String name) throws NoResultRecordException {
		List<Accounts> list = accountsMapper.selectLikeUsrname(name);
		if (list == null) {
			throw new NoResultRecordException("未寻获有关结果");
		}
		return list;
	}

	@Override
	public List<String> readSubstanceFromLog() throws IOException {
		String s = null;
		File file = new File("/home/gzh/eclipse-workspace/stocker-manager/src/main/resources/Account-Log.txt");

		FileInputStream fis = new FileInputStream(file);

		BufferedInputStream bis = new BufferedInputStream(fis);

		// available可获得的,此处获得的是所读取到的字节数
		int i = bis.available();

		// 物质,基本内容,主旨,要点,实质
		try {
			// 创建一个字节数组
			byte[] substantce = new byte[i];

			// 把读到的内容载入字节数组
			bis.read(substantce);

			String string = new String(substantce);
			s = string;

			// 若果超限,先删除,在创建一个相同的;一个汉字=2byte,1kb=1024byte
			if (i > 30 * 1024) {
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

		AccountServiceUtil util = new AccountServiceUtil();

		// 检验旧密码与藏中一致
		boolean verify = util.verify(old, tablePwd);
		if (!verify) {
			throw new KeywordErrException("密码与旧不一,请重输");
		}

		// 将取盐
		String salt = accounts.getSalt();

		String text = util.generate(trueNew, salt);

		Integer affect = accountsMapper.updatePasswordByUsrid(text, uid);

		return affect;
	}

	@Override
	public Integer reviseBaseProfile(String usrname, String phone, Integer usrid) throws SelfServiceException {
		// 禁止提交之绑定之电话号码过3
		var i = accountsMapper.countUidByPhone(phone);
		if (i > 3) {
			throw new CountPhoneOutRangeException("sorry,1个电话至多只准绑定注册3个账户");
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
			model.addAttribute("info", "您非管理员,无权入此模块");
			return "Transfer";
		} else if (status == 0) {
			model.addAttribute("info00", "您已被注销,无权入此模块");
			return "Transfer";
		}

		return "AdminWorkable";
	}

}