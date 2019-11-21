package com.allstargh.ssm.controller.kits;

public class TransferControllerUtil extends ControllerUtils {
	private static TransferControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	/**
	 * 各个部门出入记录
	 */
	public static final String RECORD_FILE_NAME = "Entry_and_Exit_Records.txt";

	/**
	 * 懒汉式
	 */
	public static TransferControllerUtil getInstance() {
		if (instance == null) {
			// 决定是否需要锁定
			synchronized (LOCK) {
				if (instance == null) {
					instance = new TransferControllerUtil();
				}
			}
		}

		return instance;
	}

	/**
	 * 
	 * @param username
	 * @param competence
	 */
	public void generalAccessRecords(String username, Integer competence) {
		String dept = "";

		switch (competence) {
		case 0:
			dept = "信息技术部";
			break;

		case 1:
			dept = "审核部";
			break;

		case 2:
			dept = "采购部";
			break;

		case 3:
			dept = "销售部";
			break;

		case 4:
			dept = "仓储部";
			break;

		}

		StringBuilder b = new StringBuilder(p_tag_prefix);

		b.append("用户");
		b.append(username);
		b.append("于");
		b.append(now_time);
		b.append("进入");
		b.append(dept);
		b.append(LINE_SEPARATOR_SUFFIX);

		writeRecordLog(RECORD_FILE_NAME, b.toString());
	}

	@Override
	protected void parameterMark(Object... args) {
		super.parameterMark(args);
	}

}
