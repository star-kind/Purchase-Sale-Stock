package com.allstargh.ssm.controller.kits;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.allstargh.ssm.pojo.Accounts;

/**
 * 账号管理工具补充类
 * 
 * @author admin
 *
 */
public class AccountControllerUtil extends ControllerUtils {
	private static AccountControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	/**
	 * 懒汉式
	 */
	public static AccountControllerUtil getInstance() {
		if (instance == null) {
			// 决定是否需要锁定
			synchronized (LOCK) {
				if (instance == null) {
					instance = new AccountControllerUtil();
				}
			}
		}

		return instance;
	}

	/**
	 * 将两组"条件"字符串数组压入HashMap,再添入list中
	 * 
	 * @return
	 */
	public ArrayList<HashMap<Integer, String[]>> addScopeArray() {
		String[] competence = { "管理员", "审查员", "采购经理", "销售经理", "仓库主管", "普通雇员" };
		String[] activeStatus = { "已注销", "已激活" };

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
	 * [getRegion description:根据数字获取地区名称]
	 * 
	 * @param key [description]
	 * @return [description]
	 */
	public String getRegion(Integer key) {
		var area = "";

		switch (key) {
		case 0:
			area = "滨河";
			break;

		case 1:
			area = "上天院";
			break;

		case 2:
			area = "鸣皋";
			break;

		case 3:
			area = "焦王";
			break;

		case 4:
			area = "申坡";
			break;

		case 5:
			area = "遵王";
			break;

		case 6:
			area = "常海山";
			break;

		case 7:
			area = "老君堂";
			break;

		case 8:
			area = "鸦岭";
			break;

		case 9:
			area = "酒后";
			break;

		case 10:
			area = "平等";
			break;

		case 11:
			area = "夏堡";
			break;

		case 12:
			area = "富留店";
			break;
		}

		return area;
	}

	/**
	 * [getJobName description:根据数字获得岗位名称]
	 * 
	 * @param key [description]
	 * @return [description]
	 */
	public String getPosition(Integer key) {
		String position = "";
		switch (key) {
		case 0:
			position = "系统管理员";
			break;

		case 1:
			position = "审核员";
			break;

		case 2:
			position = "销售经理";
			break;

		case 3:
			position = "采购经理";
			break;

		case 4:
			position = "仓管员";
			break;

		case 5:
			position = "普通雇员";
			break;

		}

		return position;
	}

	/**
	 * 记录账户模块活动记录的TXT文件之完整路径
	 */
	public static final String ACCOUNT_FILE_URI = ENGINE_DAILY_PATH + "Account-Log.txt";

	/**
	 * 将注册记录写入TXT
	 * 
	 * @param acc
	 * @param session
	 * @param row
	 */
	public void inputRegRecordsToTxt(Accounts acc, Integer row, HttpSession session) {
		String string = "";
		string += p_tag_prefix;

		try {
			string += acc.getUsrname() + " 于 " + now_time;
			string += "注册成功,岗位为" + getPosition(acc.getCompetence());
			string += ",地区为";
			string += getRegion(acc.getRegionDepartment()) + ",执行者:";
			string += session.getAttribute("usrname").toString();
			string += LINE_SEPARATOR_SUFFIX;

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (row == 1) {
			textWriter(string, ACCOUNT_FILE_URI);
		}

	}

	/**
	 * 将所有登录者之名全部记下(无论是否进入)
	 * 
	 * @param usrname
	 */
	public void inputAllLoginRecords(String usrname) {
		String string = "";
		string += p_tag_prefix;

		string += usrname + "尝试登录本系统" + ",时间:" + now_time + LINE_SEPARATOR_SUFFIX;

		if (usrname != null) {
			textWriter(string, ACCOUNT_FILE_URI);
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
		String string = "";
		string += p_tag_prefix;

		string += "地区:" + getRegion(acc.getRegionDepartment());
		string += ",职务:" + getPosition(acc.getCompetence());
		string += ",用户 " + usrname + " 登录成功";
		string += ",时间:" + now_time + LINE_SEPARATOR_SUFFIX;

		if (session.getAttribute("usrname").toString() != null) {
			textWriter(string, ACCOUNT_FILE_URI);
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
		String string = "";
		string += p_tag_prefix;

		String usridStr = geneateUsridStr(usrids);

		string += usrids.length + "位用户:ID为[ " + usridStr + " ]提交注销请求,其中";
		string += affects + "位用户于" + now_time + "完成注销,";
		string += "执行人为: " + session.getAttribute("usrname").toString();
		string += LINE_SEPARATOR_SUFFIX;

		textWriter(string, ACCOUNT_FILE_URI);

	}

	/**
	 * 多选激活记录
	 * 
	 * @param affects
	 * @param session
	 * @param usrids
	 */
	public void multipleActiveRecords(Integer affects, HttpSession session, Integer[] usrids) {
		String string = "";
		string += p_tag_prefix;

		String usridStr = geneateUsridStr(usrids);

		string += usrids.length + "位用户:ID为[" + usridStr + "]提交激活请求,其中";
		string += affects + "位用户于" + now_time + "完成激活,";
		string += "执行人为: " + session.getAttribute("usrname").toString();
		string += LINE_SEPARATOR_SUFFIX;

		textWriter(string, ACCOUNT_FILE_URI);
	}

	/**
	 * 多选重置密码记录
	 * 
	 * @param affects
	 * @param session
	 * @param usrids
	 */
	public void multipleResetRecords(Integer affects, HttpSession session, Integer[] usrids) {
		String string = "";
		string += p_tag_prefix;

		String usridStr = geneateUsridStr(usrids);

		string += usrids.length + "位用户:ID为[" + usridStr + "]提交重置密码请求,其中";
		string += affects + "位用户于" + now_time + "完成密码重置,";
		string += "执行人为: " + session.getAttribute("usrname").toString();
		string += LINE_SEPARATOR_SUFFIX;

		textWriter(string, ACCOUNT_FILE_URI);
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
		String string = "";
		string += p_tag_prefix;

		string += "ID为" + usrid + "的账号于" + now_time + "修改了资料,其新用户名为";
		string += usrname + ",新电话为" + phone + ",新职务为" + competence;
		string += ",新地区为" + regionDepartment + ",执行人:";
		string += session.getAttribute("usrname").toString() + LINE_SEPARATOR_SUFFIX;

		if (affects == 1) {
			textWriter(string, ACCOUNT_FILE_URI);
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
		String string = "";
		string += p_tag_prefix;

		string += "ID为 " + usrid;
		string += "的账户于 " + now_time;
		string += "被删除,执行者为: " + session.getAttribute("usrname").toString();
		string += LINE_SEPARATOR_SUFFIX;

		if (code == 1) {
			textWriter(string, ACCOUNT_FILE_URI);
		}
	}

	/**
	 * 修改密码记录
	 * 
	 * @param uid
	 * @param row
	 */
	public void revisePasswordHandlerRecord(Integer uid, Integer row) {
		String string = "";
		string += p_tag_prefix;

		string += "ID为 " + uid + " 的账号于" + now_time;
		string += "修改了密码" + LINE_SEPARATOR_SUFFIX;

		if (row == 1) {
			textWriter(string, ACCOUNT_FILE_URI);
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
		String string = "";
		string += p_tag_prefix;

		string += "ID为 " + uid + " 的账户于";
		string += now_time + "修改了基本资料,新用户名为:" + uname;
		string += ",新电话为:" + phone + LINE_SEPARATOR_SUFFIX;

		if (affect == 1) {
			textWriter(string, ACCOUNT_FILE_URI);
		}

	}

	/**
	 * 返回1到多个ID的字符串
	 * 
	 * @param usrids
	 * @return
	 */
	public String geneateUsridStr(Integer[] usrids) {
		String useridStr = "";

		for (int i = 0; i < usrids.length; i++) {
			useridStr += Integer.valueOf(usrids[i]);
		}

		return useridStr;
	}

}
