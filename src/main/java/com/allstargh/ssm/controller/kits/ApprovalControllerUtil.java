package com.allstargh.ssm.controller.kits;

/**
 * 饿汉式
 * 
 * <ul>
 * <li>减少性能开支
 * <li>降低系统性能损耗
 * <li>避免多重占用资源
 * <li>设置系统全局访问点,优化共享资源
 * </ul>
 * 
 * @author admin
 *
 */
public class ApprovalControllerUtil extends ControllerUtils {
	/**
	 * 设静态实例为私有,防止被引用,并初始化为null
	 */
	private static ApprovalControllerUtil instance;

	private static final ApprovalControllerUtil PLACEHOLDER = new ApprovalControllerUtil();

	/**
	 * 私有构造方法,防止被引用
	 */
	private ApprovalControllerUtil() {

	}

	private ApprovalControllerUtil(String arg) {
		instance = this;
	}

	/**
	 * 创建实例
	 * 
	 * @return
	 */
	public static ApprovalControllerUtil getInstance() {
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

	/**
	 * daily file name
	 */
	public static final String DAILY_FILE_NAME = "Auditor-record.txt";

	/**
	 * 
	 * @param uname
	 * @param affect
	 * @param deptNumber
	 * @param appId
	 * @param decide
	 */
	public void agreeOrAgainstHandlerRecord(String uname, Integer affect, Integer deptNumber, Integer appId,
			Integer decide) {
		if (!isVaildInstance()) {
			return;
		}

		System.err.println(uname + "," + affect + "," + deptNumber + "," + appId + "," + decide);

		/**
		 * 使用StirngBuilder比使用StringBuffer能获得10%~15%左右的性能提升,<br>
		 * 但却要冒多线程不安全的风险
		 */
		StringBuilder s = new StringBuilder(p_tag_prefix);

		String deptStr = null;
		String appTypeStr = null;
		switch (deptNumber) {
		case 2:
			deptStr = "采购部";
			appTypeStr = "采购申请单";
			break;

		case 4:
			deptStr = "仓管部";
			appTypeStr = "出库申请单";
			break;

		case 3:
			deptStr = "销售部";
			appTypeStr = "提货申请单";
			break;

		}

		String decideStr = null;
		if (decide == 0) {
			decideStr = "不";
		} else {
			decideStr = "是";
		}

		s.append("审核员");
		s.append(uname);
		s.append("于");
		s.append(now_time);
		s.append("处理了");
		s.append(affect);
		s.append("份");
		s.append("来自");
		s.append(deptStr);
		s.append("的");
		s.append(appTypeStr);
		s.append(",元次序号为:");
		s.append(appId);
		s.append(",审批决定:");
		s.append(decideStr);
		s.append(",本次审批记录备案成功.");
		s.append(LINE_SEPARATOR);

		writeRecordLog(affect, DAILY_FILE_NAME, s.toString());
	}

}
