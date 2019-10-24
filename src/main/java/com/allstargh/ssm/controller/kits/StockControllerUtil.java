package com.allstargh.ssm.controller.kits;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;

public class StockControllerUtil extends ControllerUtils {
	private static StockControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	/**
	 * daily file name
	 */
	public static final String DAILY_FILE_NAME = "Daily_of_Stocker.txt";

	/**
	 * letters char
	 */
	public static char[] chars = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
			'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
			'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };

	/**
	 * 懒汉式
	 */
	public static StockControllerUtil getInstance() {
		if (instance == null) {
			// 决定是否需要锁定
			synchronized (LOCK) {
				if (instance == null) {
					instance = new StockControllerUtil();
				}
			}
		}

		return instance;
	}

	/**
	 * 将build字符串还原为原输入之字符串
	 * 
	 * @param build
	 * @return
	 */
	public String reduceByCharIndex(String build) {
		System.out.println("\n");

		StringBuilder b2 = new StringBuilder();

		String[] split = build.split("-");

		for (int i = 0; i < split.length; i++) {
			Integer place = Integer.valueOf(split[i]);
			b2.append(chars[place]);
		}

		String input = b2.toString();
		System.out.println("复原结果: " + input);

		return input;
	}

	/**
	 * 据ServletPath进行判断
	 * 
	 * @param purchase
	 * @param path
	 * @return
	 */
	public Purchase judgeByPath(Purchase purchase, String path) {
		StringBuilder builder = new StringBuilder(path);

		int last = builder.lastIndexOf("/");
		System.out.println("last-" + last);

		String controllerName = builder.substring(last + 1, path.length());
		System.out.println(controllerName);

		if (!"gotoStockerPagesRejectReply".equals(controllerName)) {
			purchase = null;
		}

		return purchase;
	}

	/**
	 * 获取当前控制器映射路径据ServletPath
	 * 
	 * @param servletPath
	 * @return
	 */
	public String getSuffixByServletPath(String servletPath) {
		System.err.println("servletPath--" + servletPath);

		if (servletPath != null) {
			StringBuilder builder = new StringBuilder(servletPath);

			int last = builder.lastIndexOf("/");
			System.err.println("last-" + last);

			String suffix = builder.substring(last + 1, servletPath.length());
			System.err.println("suffix--" + suffix);
			return suffix;
		}

		return "";
	}

	/**
	 * 
	 * @param operator
	 * @param affect
	 * @param purchase
	 */
	public void regEntryHandlerRecord(String operator, Integer affect, Purchase purchase) {
		/**
		 * 使用 StirngBuilder 相比使用 StringBuffer 能获得 10%~15% 左右的性能提升， <br>
		 * 但却要冒多线程不安全的风险
		 */
		StringBuilder sentence = new StringBuilder(p_tag_prefix);

		sentence.append("仓管员");
		sentence.append(operator);
		sentence.append("于");
		sentence.append(now_time);
		sentence.append("将");
		sentence.append(affect);
		sentence.append("批货物登记入库,货物批次号为:");
		sentence.append(purchase.getPurchaseId());
		sentence.append(".");
		sentence.append(LINE_SEPARATOR);

		writeRecordLog(affect, DAILY_FILE_NAME, sentence.toString());
	}

	public void checkEnterCompetenceHandlerRecord(String path, HttpSession session) {
		String uname = getUsrnameFromSession(session);

		/**
		 * 使用 StirngBuilder 相比使用 StringBuffer 能获得 10%~15% 左右的性能提升， <br>
		 * 但却要冒多线程不安全的风险
		 */
		StringBuilder sentence = new StringBuilder(p_tag_prefix);

		sentence.append("仓管员");
		sentence.append(uname);
		sentence.append("于");
		sentence.append(now_time);
		sentence.append("进入仓库模块.");
		sentence.append(LINE_SEPARATOR);

		if (path != null || !("".equals(path))) {
			writeRecordLog(DAILY_FILE_NAME, sentence.toString());
		}
	}

	/**
	 * 
	 * @param operator
	 * @param formData
	 */
	public void regToExternalHandlerRecord(String operator, Purchase formData) {
		/**
		 * 使用StirngBuilder比使用StringBuffer能获得10%~15%左右的性能提升,<br>
		 * 但却要冒多线程不安全的风险
		 */
		StringBuilder s = new StringBuilder(p_tag_prefix);

		s.append("仓管员");
		s.append(operator);
		s.append("于当地时间");
		s.append(now_time);
		s.append("将次序号为");
		s.append(formData.getPurchaseId());
		s.append("的货品移往外部临时区域.");
		s.append(LINE_SEPARATOR);

		writeRecordLog(DAILY_FILE_NAME, s.toString());
	}

	/**
	 * 
	 * @param usrname
	 * @param affected
	 * @param map
	 */
	public void modifiedStoreGoodHandlerRecord(String usrname, Integer affected, HashMap<String, String> map) {
		/**
		 * 使用StirngBuilder比使用StringBuffer能获得10%~15%左右的性能提升,<br>
		 * 但却要冒多线程不安全的风险
		 */
		StringBuilder s = new StringBuilder(p_tag_prefix);

		s.append("仓管员");
		s.append(usrname);
		s.append("于当地时间");
		s.append(now_time);
		s.append("对申购次序号为");
		s.append(map.get("purchaseId"));
		s.append("的货品资料进行了改动.");
		s.append(LINE_SEPARATOR);

		writeRecordLog(affected, DAILY_FILE_NAME, s.toString());
	}

}
