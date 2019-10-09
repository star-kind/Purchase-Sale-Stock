package com.allstargh.ssm.controller.kits;

import java.io.File;
import java.io.IOException;

import com.allstargh.ssm.pojo.Purchase;

/**
 * 进购模块控制器工具类
 * 
 * @author gzh
 *
 */
public class PurchaseControllerUtil extends ControllerUtils {

	private static PurchaseControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	/**
	 * 进购模块日志记录文件名
	 */
	public static final String PURCHASE_FILE_NAME = "Purchase_Module_Log.txt";

	// 日志记录文件之路径
	public static String LOG_URI = null;

	/**
	 * 懒汉式
	 */
	public static PurchaseControllerUtil getInstance() {
		if (instance == null) {
			// 决定是否需要锁定
			synchronized (LOCK) {
				if (instance == null) {
					instance = new PurchaseControllerUtil();
				}
			}
		}

		return instance;
	}

	/**
	 * 在工程根目录下创建文件夹和里面的文件
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String createDirAndFile() throws IOException {
		File file = new File(ENGINE_DAILY_PATH);

		if (!file.exists()) {
			file.mkdir();
		}

		File f1 = new File(file, PURCHASE_FILE_NAME);
		f1.createNewFile();

		String path = f1.getAbsolutePath();

		return path;
	}

	/**
	 * 记录写入升级再封装(针对单行操作)
	 * 
	 * @param affect
	 */
	public void writeRecordPlus(Integer affect) {
		try {
			LOG_URI = createDirAndFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affect == 1) {
			textWriter(sentence, LOG_URI);
		}

	}

	/**
	 * 重载:记录写入升级再封装(针对单行操作)
	 * 
	 * @param affect
	 * @param record
	 */
	public void writeRecordPlus(Integer affect, String record) {
		try {
			LOG_URI = createDirAndFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affect == 1) {
			textWriter(record, LOG_URI);
		}

	}

	/**
	 * 记录写入文件:针对多行操作
	 * 
	 * @param affects
	 */
	public void writeRecordPlus(Integer[] affects) {
		try {
			LOG_URI = createDirAndFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affects != null) {
			textWriter(sentence, LOG_URI);
		}

	}

	/**
	 * overload:记录写入文件:针对多行操作
	 * 
	 * @param affects
	 * @param record
	 */
	public void writeRecordPlus(Integer[] affects, String record) {
		try {
			LOG_URI = createDirAndFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affects != null) {
			textWriter(record, LOG_URI);
		}

	}

	/**
	 * 采买申请单新增记录
	 * 
	 * @param usrname
	 * @param affect
	 */
	public void addNewPurchaseAppFormHandlerLog(String usrname, Integer affect) {
		String string = "";
		string += p_tag_prefix;

		string += "采购专员" + usrname + "于" + now_time + "提交了" + affect + "份采购申请单" + LINE_SEPARATOR;

		writeRecordPlus(affect, string);

	}

	/**
	 * 单份修改申购单之记录
	 * 
	 * @param affect
	 * @param usrname
	 * @param purchase
	 */
	public void editOnePurchaseByIdHandlerLog(Integer affect, String usrname, Purchase purchase) {
		String string = "";
		string += p_tag_prefix;

		// 采购经理xx于xx时间修改了x份单号id为xx的采购申请单
		string += "采购经理" + usrname + "于" + now_time + "修改了" + affect + "份单号id为" + purchase.getPurchaseId() + "的采购申请单"
				+ LINE_SEPARATOR;

		writeRecordPlus(affect, string);

	}

	/**
	 * 删除单份采购单
	 * 
	 * @param effect
	 * @param usrname
	 */
	public void deleteSinglePurchaseAppByIdLog(Integer effect, String usrname) {
		String string = "";
		string += p_tag_prefix;

		string += "采购经理" + usrname + "于" + now_time + "删除了" + effect + "份采购申请单" + LINE_SEPARATOR;

		writeRecordPlus(effect, string);
	}

	/**
	 * 删除多份采购单记录
	 * 
	 * @param usrname
	 * @param effects
	 */
	public void deleteMultiplesPurchaseAppByIdsHandlerLog(String usrname, Integer[] effects) {
		String string = "";
		string += p_tag_prefix;

		string += "采购经理";
		string += usrname;
		string += "于";
		string += now_time;
		string += "删除了";
		string += effects.length;
		string += "份采购单";
		string += LINE_SEPARATOR;

		writeRecordPlus(effects, string);
	}

}