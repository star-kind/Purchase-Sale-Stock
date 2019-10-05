package com.allstargh.ssm.service.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 采购模块业务工具类
 * 
 * @author admin
 *
 */
public class PurchaseServiceUtil {
	private static PurchaseServiceUtil psu;

	private static final Object LOCK = new Object();

	private PurchaseServiceUtil() {

	}

	/**
	 * 懒汉
	 * 
	 * @return
	 */
	public static PurchaseServiceUtil getInstance() {
		if (psu == null) {
			synchronized (LOCK) {// 决定是否需要锁住,并判断
				if (psu == null) {
					psu = new PurchaseServiceUtil();
				}
			}
		}
		return psu;

	}

	/**
	 * 清空文件内容
	 * 
	 * @param filePath
	 */
	public void cleanSubstance(String filePath) {
		File file = new File(filePath);
		FileWriter writer = null;

		try {
			if (file.exists() == false) {
				file.createNewFile();
			}

			writer = new FileWriter(file);
			writer.write("");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}