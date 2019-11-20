package com.allstargh.ssm.controller.kits;

/**
 * <em>懒汉式</em>
 * <h2>双重检查</h2>
 * <ul>
 * <li>1、不允许2、3进行重排序,加入了volatile关键字.</li>
 * <li>2、允许一个线程进行重排序，但不允许另外线程看到他的重排序。</li>
 * </ul>
 * <ol>
 * <b>划重点：</b>
 * <li>1、在多线程的时候，cpu有共享内存。</li>
 * <li>2、加入了volatile关键字之后，所有线程都能看到共享内存的最新状态，保证内存可见性。</li>
 * </ol>
 * <p>
 * 怎么保持内存一致性？ 用volatile修饰的共享变量，在进行写操作的时候，会多出来很多汇编代码，起到两个作用。
 * </p>
 * 
 * <p>
 * 1、是将当前处理器缓存行的数据写回到系统内存，写回内存的操作，会使在其他cpu里缓存了该内存的数据无效，
 * 其他cpu缓存的数据无效了，就会从共享内存同步数据。 如此便可保证了内存的可见性。
 * </p>
 * <p>
 * 主要使用的是缓存一致性协议
 * </p>
 * 优点： 既兼顾了性能，又兼顾了线程安全。
 * 
 * @author admin
 *
 */
public class OutStockControllerUtil extends ControllerUtils {
	private volatile static OutStockControllerUtil singleLeton = null;

	private OutStockControllerUtil() {
	}

	public synchronized static OutStockControllerUtil getInstance() {
		if (singleLeton == null) {
			synchronized (OutStockControllerUtil.class) {
				if (singleLeton == null) {
					singleLeton = new OutStockControllerUtil();
				}
			}
		}

		return singleLeton;
	}

	/**
	 * 出仓记录日志
	 */
	protected static String logging_record_out_warehouse = "logging_record_out_warehouse.txt";

	/**
	 * 
	 * @param uname
	 * @param affect
	 * @param outChoice
	 * @param opinion
	 */
	public void addOutHandlerRecord(String uname, Integer affect, boolean outChoice, String opinion) {
		StringBuilder b = new StringBuilder(p_tag_prefix);

		String choice = "";
		String remark = "";

		if (outChoice == false) {
			choice = "不同意";

			remark = ",不同意出库的意见备注是:";
			remark += opinion;
		} else {
			choice = "同意";
		}

		b.append("仓管员");
		b.append(uname);
		b.append("于");
		b.append(now_time);
		b.append("将");
		b.append(affect);
		b.append("份");
		b.append("提货申请单做了登记出库记录,是否同意出库:");
		b.append(choice);
		b.append(remark);
		b.append(".");
		b.append(LINE_SEPARATOR_SUFFIX);

		writeRecordLog(affect, logging_record_out_warehouse, b.toString());
	}

}
