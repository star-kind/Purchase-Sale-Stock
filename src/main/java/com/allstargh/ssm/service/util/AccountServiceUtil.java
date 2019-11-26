package com.allstargh.ssm.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

import com.allstargh.ssm.pojo.Accounts;

/**
 * account接口所用之单元方法
 * 
 * @author gzh
 *
 */
public class AccountServiceUtil {
	private static AccountServiceUtil asu;

	private static final Object LOCK = new Object();

	private AccountServiceUtil() {

	}

	/**
	 * 懒汉
	 * 
	 * @return
	 */
	public static AccountServiceUtil getInstance() {

		if (asu == null) {
			synchronized (LOCK) {// 决定是否需要锁住,并判断
				if (asu == null) {
					asu = new AccountServiceUtil();
				}
			}
		}

		return asu;

	}

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
	 * @param password 提交之密码
	 * @param text     原文
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

		if (a.getRegionDepartment() == null || ("".equals(a.getRegionDepartment()))) {
			System.out.println("the nerve on him");
		} else {
			list.add(Integer.toString(a.getRegionDepartment()));
		}

		return list.size();
	}

	/**
	 * 根据传入的地区部门名返还一个地区代号
	 * 
	 * @param regionDepartment
	 * @return
	 */
	public Integer getNumRegionDepartment(String regionDepartment) {
		Integer number = null;

		switch (regionDepartment) {

		case "滨河":
			number = 0;
			break;

		case "上天院":
			number = 1;
			break;

		case "鸣皋":
			number = 2;
			break;

		case "焦王":
			number = 3;
			break;

		case "申坡":
			number = 4;
			break;

		case "遵王":
			number = 5;
			break;

		case "常海山":
			number = 6;
			break;

		case "老君堂":
			number = 7;
			break;

		case "鸦岭":
			number = 8;
			break;

		case "酒后":
			number = 9;
			break;

		case "平等":
			number = 10;
			break;

		case "夏堡":
			number = 11;
			break;

		case "富留店":
			number = 12;
			break;
		}

		return number;
	}

	/**
	 * 据传入的职务权限字符串返回不同权限码
	 * 
	 * @param selectCompetence 权限码
	 * @return
	 */
	public Integer switchBySelectCompetence(String selectCompetence) {
		Integer competence = 5;

		switch (selectCompetence) {
		case "管理员":
			competence = 0;
			break;

		case "审查员":
			competence = 1;
			break;

		case "采购经理":
			competence = 2;
			break;

		case "销售经理":
			competence = 3;
			break;

		case "仓库主管":
			competence = 4;
			break;

		case "普通雇员":
			competence = 5;
			break;

		}

		return competence;
	}

	/**
	 * 据传入的账户状态字符串返回不同状态码
	 * 
	 * @param selectCompetence 状态码
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
