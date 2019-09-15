package controller.kits;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import json.ResponseResult;
import pojo.Accounts;
import service.ex.CanceledAccountException;
import service.ex.CountPhoneOutRangeException;
import service.ex.DeleteAccountDefeatException;
import service.ex.KeywordErrException;
import service.ex.NoResultRecordException;
import service.ex.SelfServiceException;
import service.ex.ServiceExceptionEnum;
import service.ex.SubmitDataUnCompletelyException;
import service.ex.UnameDuplicateConflictExcept;
import service.ex.UnameOrKeyIsNullException;
import service.ex.UsrnameErrException;

/**
 * 控制器会用到的一些方法
 * 
 * @author gzh
 *
 */
@ControllerAdvice
public class ControllerToolKit {
	/**
	 * "成功"状态码(响应)
	 */
	public static final Integer SUCCESS = 200;

	/**
	 * 记录账户模块活动记录的TXT文件之完整路径
	 */
	public static final String FILE_URI = "/home/gzh/eclipse-workspace/Stocker-Manager/src/main/resources/Account-Log.txt";

	/**
	 * 系统换行符
	 */
	protected static final String LINE_SEPARATOR = System.getProperty("line.separator") + "</p>";

	/**
	 * 文件输出流
	 */
	protected static FileOutputStream fos = null;

	/**
	 * 二进制数组,充作缓冲对象
	 */
	protected static byte[] buff = null;

	/**
	 * 日期格式对象
	 */
	protected static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 当前时间字符串
	 */
	protected static String nowTime = sdf.format(new Date());

	/**
	 * 统一将异常封入json实体
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({SelfServiceException.class})
	public ResponseResult<Void> exceptioHandler(Throwable e) {
		ResponseResult<Void> rr = new ResponseResult<Void>();

		ServiceExceptionEnum instance = ServiceExceptionEnum.getInstance();

		rr.setMessage(e.getMessage());

		if (e instanceof DeleteAccountDefeatException) {
			rr.setState(600);
		} else if (e instanceof UsrnameErrException) {
			rr.setState(601);
		} else if (e instanceof KeywordErrException) {
			rr.setState(602);
		} else if (e instanceof CanceledAccountException) {
			rr.setState(603);
		} else if (e instanceof UnameOrKeyIsNullException) {
			rr.setState(604);
		} else if (e instanceof UnameDuplicateConflictExcept) {
			rr.setState(605);
		} else if (e instanceof CountPhoneOutRangeException) {
			rr.setState(606);
		} else if (e instanceof SubmitDataUnCompletelyException) {
			rr.setState(607);
		} else if (e instanceof NoResultRecordException) {
			rr.setState(608);
		}

		// 使用switch-case
		switch (e.getMessage()) {
			case "您已下线,请重新登录" :
				rr.setState(instance.OFFLINE_LOGIN.getCode());
				break;
		}

		return rr;
	}

	/**
	 * 将两组"条件"字符串数组压入HashMap,再添入list中
	 * 
	 * @return
	 */
	public ArrayList<HashMap<Integer, String[]>> addScopeArray() {
		String[] competence = {"管理员", "总经理", "采购经理", "销售经理", "仓库主管", "普通雇员"};
		String[] activeStatus = {"已注销", "已激活"};

		HashMap<Integer, String[]> hashMap = new HashMap<Integer, String[]>();

		hashMap.put(0, competence);
		hashMap.put(1, activeStatus);

		ArrayList<HashMap<Integer, String[]>> list = new ArrayList<HashMap<Integer, String[]>>();

		list.add(hashMap);

		return list;

	}

	/**
	 * 勘察收到的字符串应属于哪种搜寻情景
	 * 
	 * @param receiv
	 * @return
	 */
	public int prospect(String receiv) {
		int num = 2;// 缺省码,按地区部门查询

		ArrayList<HashMap<Integer, String[]>> list = addScopeArray();

		for (int i = 0; i < list.get(0).size(); i++) {
			for (String s : list.get(0).get(i)) {
				if (s.equals(receiv)) {
					num = i;
				}
			}
		}

		return num;
	}

	/**
	 * 将String写入文本中
	 * 
	 * @param string
	 */
	public void textWriter(String string) {
		try {
			fos = new FileOutputStream(FILE_URI, true);
			buff = string.getBytes();
			fos.write(buff);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 将String写入文本中
	 * 
	 * @param string
	 */
	public void textWriter(String string, String logPath) {
		try {
			fos = new FileOutputStream(logPath, true);
			buff = string.getBytes();
			fos.write(buff);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 将注册记录写入TXT
	 * 
	 * @param acc
	 * @param session
	 * @param row
	 */
	public void inputRegRecordsToTxt(Accounts acc, Integer row, HttpSession session) {
		String str = "";
		try {
			str = "<p>" + acc.getUsrname() + " 于 " + nowTime + "注册成功,权限代号为" + acc.getCompetence() + ",地区部门为"
					+ acc.getRegionDepartment() + ",执行者:" + session.getAttribute("usrname").toString() + LINE_SEPARATOR;
		} catch (Exception e) {
			str = "<p>" + acc.getUsrname() + " 于 " + nowTime + "注册成功,权限代号为" + acc.getCompetence() + ",地区部门为"
					+ acc.getRegionDepartment() + LINE_SEPARATOR;
		}

		if (row == 1) {
			textWriter(str);
		}

	}

	/**
	 * 将所有登录者之名全部记下(无论是否进入)
	 * 
	 * @param usrname
	 */
	public void inputAllLoginRecords(String usrname) {
		String str = "<p>" + usrname + "尝试登录本系统" + ",时间:" + nowTime + LINE_SEPARATOR;

		if (usrname != null) {
			textWriter(str);
		}

	}

	/**
	 * 将登录成功的记录写入TXT
	 * 
	 * @param acc
	 * @param usrname
	 * @param session
	 */
	public void inputSuccessLoginRecords(Accounts acc, String usrname, HttpSession session) {
		String str = "<p>地区部门:" + acc.getRegionDepartment() + ",权限:" + acc.getCompetence() + ",用户 " + usrname + " 登录成功"
				+ ",时间:" + nowTime + LINE_SEPARATOR;

		if (session.getAttribute("usrname").toString() != null) {
			textWriter(str);
		}

	}

	/**
	 * 多选注销记录
	 * 
	 * @param affects
	 * @param session
	 * @param usrids
	 */
	public void multipleCancelRecords(Integer affects, HttpSession session, Integer[] usrids) {
		String str = "";
		for (int i = 0; i < usrids.length; i++) {
			str += Integer.valueOf(usrids[i]) + ",";
		}
		String string = usrids.length + "位用户:ID为{ " + str + "}提交注销请求,其中" + affects + "位用户于" + nowTime + "完成注销," + "执行人为: "
				+ session.getAttribute("usrname").toString() + LINE_SEPARATOR;

		textWriter(string);

	}

	/**
	 * 多选激活记录
	 * 
	 * @param affects
	 * @param session
	 * @param usrids
	 */
	public void multipleActiveRecords(Integer affects, HttpSession session, Integer[] usrids) {
		String str = "";
		for (int i = 0; i < usrids.length; i++) {
			str += Integer.valueOf(usrids[i]) + ",";
		}
		String string = "<p>" + usrids.length + "位用户:ID为{ " + str + "}提交激活请求,其中" + affects + "位用户于" + nowTime + "完成激活,"
				+ "执行人为: " + session.getAttribute("usrname").toString() + LINE_SEPARATOR;

		textWriter(string);
	}

	/**
	 * 多选重置密码记录
	 * 
	 * @param affects
	 * @param session
	 * @param usrids
	 */
	public void multipleResetRecords(Integer affects, HttpSession session, Integer[] usrids) {
		String str = "";
		for (int i = 0; i < usrids.length; i++) {
			str += Integer.valueOf(usrids[i]) + ",";
		}
		String string = "<p>" + usrids.length + "位用户:ID为{ " + str + "}提交重置密码请求,其中" + affects + "位用户于" + nowTime + "完成密码重置,"
				+ "执行人为: " + session.getAttribute("usrname").toString() + LINE_SEPARATOR;

		textWriter(string);
	}

	/**
	 * 修改账号资料记录
	 * 
	 * @param usrid
	 * @param session
	 * @param affects
	 * @param usrname
	 * @param phone
	 * @param competence
	 * @param regionDepartment
	 */
	public void executModifiyRecords(Integer usrid, HttpSession session, Integer affects, String usrname, String phone,
			Integer competence, Integer regionDepartment) {
		String str = "<p>ID为" + usrid + "的账号于" + nowTime + "修改了资料,其新用户名为" + usrname + ",新电话为" + phone + ",新权限码为" + competence
				+ ",新地区部门为" + regionDepartment + ",执行人:" + session.getAttribute("usrname").toString() + LINE_SEPARATOR;

		if (affects == 1) {
			textWriter(str);
		}
	}

	/**
	 * 删除账户记录
	 * 
	 * @param usrid
	 * @param code
	 * @param session
	 */
	public void earseAnAccountRecords(Integer usrid, Integer code, HttpSession session) {
		String string = "<p>ID为 " + usrid + "的账户于 " + nowTime + "被删除,执行者为: " + session.getAttribute("usrname").toString()
				+ LINE_SEPARATOR;

		if (code == 1) {
			textWriter(string);
		}
	}

	/**
	 * 修改密码记录
	 * 
	 * @param uid
	 * @param row
	 */
	public void revisePasswordHandlerRecord(Integer uid, Integer row) {
		String record = "<p>ID为 " + uid + " 的账号于" + nowTime + "修改了密码" + LINE_SEPARATOR;
		if (row == 1) {
			textWriter(record);
		}
	}

	/**
	 * 修改基本资料记录
	 * 
	 * @param uid
	 * @param uname
	 * @param phone
	 * @param affect
	 */
	public void reviseBaseProfileHandlerRecord(Integer uid, String uname, String phone, Integer affect) {
		String record = "<p>ID为 " + uid + " 的账户于" + nowTime + "修改了基本资料,新用户名为:" + uname + ",新电话为:" + phone + LINE_SEPARATOR;

		if (affect == 1) {
			textWriter(record);
		}

	}
}