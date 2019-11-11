package com.allstargh.ssm.controller.kits;

/**
 * 销售部控制器辅助工具
 * 
 * @author admin
 *
 */
public class SaleControllerUtil extends ControllerUtils {
	/**
	 * 设静态实例为私有,防止被引用,并初始化为null
	 */
	private static SaleControllerUtil instance;

	private static final SaleControllerUtil PLACEHOLDER = new SaleControllerUtil();

	/**
	 * 私有构造方法,防止被引用
	 */
	private SaleControllerUtil() {
	}

	private SaleControllerUtil(String arg) {
		instance = this;
	}

	/**
	 * 创建实例
	 * 
	 * @return
	 */
	public static SaleControllerUtil getInstance() {
		if (instance == null) {
			return PLACEHOLDER;
		}

		return instance;
	}

	/**
	 * 实际逻辑操作的时候,可能占位符/默认值并不能执行,所以要在所有的对外方法中添加实例检查
	 * 
	 * @return
	 */
	public boolean isVaildInstance() {
		if (this != PLACEHOLDER) {
			System.err.println("占位符/默认值不能执行");
			return false;

		}

		System.err.println("占位符/默认值能够执行");
		return true;

	}

	/*----------------------------------------------------------------------*/

	/**
	 * daily file name
	 */
	public static final String LOG_FILE_NAME = "Saler-record.txt";

	/*----------------------------------------------------------------------*/

	/**
	 * 
	 * @param username
	 * @param affect
	 */
	public void addHandlerRecord(String username, Integer affect) {
		StringBuilder b = new StringBuilder(p_tag_prefix);

		b.append("销售人员");
		b.append(username);
		b.append("于");
		b.append(now_time);
		b.append("录入");
		b.append(affect);
		b.append("份销售记录书");
		b.append(LINE_SEPARATOR_SUFFIX);

		writeRecordLog(affect, LOG_FILE_NAME, b.toString());
	}

}
