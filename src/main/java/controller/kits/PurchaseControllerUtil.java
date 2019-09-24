package controller.kits;

import java.io.File;
import java.io.IOException;

/**
 * 进购模块控制器工具类
 * 
 * @author gzh
 *
 */
public class PurchaseControllerUtil extends ControllerToolKit {
	/**
	 * 懒汉式
	 */
	private static PurchaseControllerUtil instance;

	// 锁
	private static final Object LOCK = new Object();

	// 文件夹路径
	private static final String DIR_URI = "/home/admin/workspace/eclipse/eclipse-workspace/StockerManager/Logs/";

	// 日志记录文件名
	private static final String FILE_NAME = "Purchase_Module_Log.txt";

	// 日志记录文件之路径
	public static String LOG_URI = null;

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
		File file = new File(DIR_URI);

		if (!file.exists()) {
			file.mkdir();
		}

		File file00 = new File(file, FILE_NAME);
		file00.createNewFile();

		String path = file00.getAbsolutePath();

		return path;
	}

	/**
	 * 采买申请单新增记录
	 * 
	 * @param usrname
	 * @param affect
	 */
	public void addNewPurchaseAppFormHandlerLog(String usrname, Integer affect) {
		String str = "<p>采购专员" + usrname + "于" + now_time + "提交了" + affect + "份采购申请单" + LINE_SEPARATOR;

		try {
			LOG_URI = createDirAndFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affect == 1) {
			textWriter(str, LOG_URI);
		}
	}

}