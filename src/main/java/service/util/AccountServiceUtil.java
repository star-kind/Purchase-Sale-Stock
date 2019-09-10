package service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

import pojo.Accounts;

/**
 * account接口所用之单元方法
 * 
 * @author gzh
 *
 */
public class AccountServiceUtil {
	/**
	 * 提取盐
	 *
	 * @return
	 */
	public String extractSalt() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder(16);
		builder.append(random.nextInt(99999999));
		int length = builder.length();
		if (length < 16) {
			for (int i = 0; i < 16 - length; i++) {
				int n = random.nextInt(9);
				builder.append(n + "");
			}
		}

		String salt = builder.toString();
		return salt;
	}

	/**
	 * 获取十六进制字符串形式的MD5摘要(digest)
	 *
	 * @param src
	 * @return
	 */
	private String md5Hex(String src) {
		MessageDigest md5 = null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] bs = md5.digest(src.getBytes());

		byte[] encode = new Hex().encode(bs);
		String digest = new String(encode);

		return digest;

	}

	/**
	 * MD5+盐,输入密码,生成并返回密文
	 *
	 * @param pwd
	 * @return
	 */
	public String generate(String pwd, String salt) {
		// 撒盐,并在MD5hex方法内均匀搅拌
		String hex = md5Hex(salt + pwd);
		System.out.println("hex:" + hex);

		char[] cs = new char[48];
		// 再加密
		for (int i = 0; i < 48; i += 3) {
			cs[i] = hex.charAt(i / 3 * 2);
			cs[i + 1] = salt.charAt(i / 3);
			cs[i + 2] = hex.charAt(i / 3 * 2 + 1);
		}
		String txt = new String(cs);
		return txt;
	}

	/**
	 * 校验加盐后是否和原文一致,逆向解密
	 *
	 * @param password
	 *            提交之密码
	 * @param text
	 *            原文
	 * @return
	 */
	public boolean verify(String password, String text) {
		char[] digestStr = new char[32];
		char[] saltStr = new char[16];

		for (int i = 0; i < 48; i += 3) {
			digestStr[i / 3 * 2] = text.charAt(i);
			digestStr[i / 3 * 2 + 1] = text.charAt(i + 2);

			saltStr[i / 3] = text.charAt(i + 1);
		}

		String salt = new String(saltStr);

		return md5Hex(salt + password).equals(new String(digestStr));
	}

	/**
	 * 检查提交之参数个数是否为4 四参数:名电职部
	 * 
	 * @param a
	 * @return
	 */
	public Integer checkCommittedAccounts(Accounts a) {
		LinkedList<String> list = new LinkedList<String>();

		if (a.getUsrname() == null || ("".equals(a.getUsrname()))) {
			System.out.println("the nerve on him");
		} else {
			list.add(a.getUsrname());
		}

		if (a.getPhone() == null || ("".equals(a.getPhone()))) {
			System.out.println("the nerve on him");
		} else {
			list.add(a.getPhone());
		}

		if (a.getCompetence() == null || ("".equals(a.getCompetence()))) {
			System.out.println("the nerve on him");
		} else {
			list.add(Integer.toString(a.getCompetence()));
		}

		if (a.getRegionDepartment() == null
				|| ("".equals(a.getRegionDepartment()))) {
			System.out.println("the nerve on him");
		} else {
			list.add(Integer.toString(a.getRegionDepartment()));
		}

		return list.size();
	}

	/**
	 * 根据传入的地区部门名返还一个Integer数组
	 * 
	 * @param regionDepartment
	 * @return
	 */
	public Integer[] switchBaseOnRegionDepartment(String regionDepartment) {
		Integer[] arr = new Integer[2];

		switch (regionDepartment) {
			case "常川" :
				arr[0] = 0;
				arr[1] = 15;
				break;

			case "滨河" :
				arr[0] = 16;
				arr[1] = 21;
				break;

			case "上天院" :
				arr[0] = 22;
				arr[1] = 29;
				break;

			case "鸣皋" :
				arr[0] = 30;
				arr[1] = 39;
				break;

			case "焦王" :
				arr[0] = 40;
				arr[1] = 49;
				break;

			case "申坡" :
				arr[0] = 50;
				arr[1] = 59;
				break;

			case "遵王" :
				arr[0] = 60;
				arr[1] = 69;
				break;

			case "常海山" :
				arr[0] = 70;
				arr[1] = 79;
				break;

			case "海神" :
				arr[0] = 80;
				arr[1] = 89;
				break;

			case "老君堂" :
				arr[0] = 90;
				arr[1] = 99;
				break;

			case "鸦岭" :
				arr[0] = 100;
				arr[1] = 129;
				break;

			case "酒后" :
				arr[0] = 130;
				arr[1] = 149;
				break;

			case "平等" :
				arr[0] = 150;
				arr[1] = 169;
				break;

			case "卷奥" :
				arr[0] = 170;
				arr[1] = 199;
				break;

			default :
				arr[0] = 200;
				arr[1] = 999;
				break;
		}

		return arr;
	}

	/**
	 * 据传入的职务权限字符串返回不同权限码
	 * 
	 * @param selectCompetence
	 *            权限码
	 * @return
	 */
	public Integer switchBySelectCompetence(String selectCompetence) {
		Integer competence = 5;

		switch (selectCompetence) {
			case "管理员" :
				competence = 0;
				break;

			case "总经理" :
				competence = 1;
				break;

			case "采购经理" :
				competence = 2;
				break;

			case "销售经理" :
				competence = 3;
				break;

			case "仓库主管" :
				competence = 4;
				break;

			case "普通雇员" :
				competence = 5;
				break;

		}

		return competence;
	}

	/**
	 * 据传入的账户状态字符串返回不同状态码
	 * 
	 * @param selectCompetence
	 *            状态码
	 * @return
	 */
	public Integer statusStringTransToActiveStatus(String status) {
		Integer activeStatus = 1;

		if ("已注销".equals(status)) {
			activeStatus = 0;
			return activeStatus;
		}

		return activeStatus;
	}
}
