package com.allstargh.ssm.controller.kits;

import javax.servlet.http.HttpSession;

import com.allstargh.ssm.pojo.Purchase;

public class StockControllerUtil extends ControllerUtils {
	private static StockControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	/**
	 * daily file name
	 */
	public static final String DAILY_FILE_NAME = "Daily_of_Stocker.txt";

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
	 * 
	 * @param purchase
	 * @param j
	 * @return
	 */
	public Purchase judgeByPath(Purchase purchase, Integer j) {
		if (j != 1) {
			purchase = null;
		}

		return purchase;
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

}
