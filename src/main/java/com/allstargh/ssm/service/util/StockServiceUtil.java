package com.allstargh.ssm.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

public class StockServiceUtil {
	private static StockServiceUtil ssu;

	private HashMap<String, String> map = new HashMap<String, String>();
	private HashMap<String, String> m1 = new HashMap<String, String>();

	private static final Object LOCK = new Object();

	private StockServiceUtil() {

	}

	/**
	 * 懒汉
	 * 
	 * @return
	 */
	public static StockServiceUtil getInstance() {
		if (ssu == null) {
			synchronized (LOCK) {// 同步锁,保持单线程
				if (ssu == null) {
					ssu = new StockServiceUtil();
				}
			}
		}
		return ssu;

	}

	/**
	 * 主要检验是否已注销和职务权限
	 * 
	 * @param ac
	 */
	public void checkStockerState(Accounts ac) {
		if (ac.getActiveStatus() == 0) {
			String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
			System.err.println(description);
			throw new SelfServiceException(description);

		} else if (ac.getCompetence() != 4) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			System.err.println(description);
			throw new SelfServiceException(description);

		} else {
			System.err.println("通过仓管员常规检验");
		}

	}

	/**
	 * 整理
	 * 
	 * @param m1
	 * @param stockOperator
	 * @param remark
	 * @return
	 * @throws SelfServiceException
	 */
	public TStock arrangement(HashMap<String, String> m1, String stockOperator, String remark)
			throws SelfServiceException {
		TStock t = new TStock();

		t.setPurchaseId(Integer.valueOf(m1.get("purchaseId")));

		t.setStockTypeArea((byte) 9);

		t.setStoreQuantity(Integer.valueOf(m1.get("quantity")));

		Float amountMoney = Float.parseFloat(m1.get("amountMoney"));
		int q = Integer.valueOf(m1.get("quantity")).intValue();
		float price = amountMoney / (float) q;

		t.setUnitPrice((long) price);

		t.setStoreCommodity(m1.get("commodity"));

		t.setEnterStockTime(new Date());

		t.setAgreeEnterStock(false);

		t.setRemark(remark);

		try {
			t.setStockOperator(stockOperator);
		} catch (SelfServiceException e) {
			e.printStackTrace();
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		System.out.println(t.toString());
		return t;

	}

	/**
	 * <b>overload</b>
	 * 
	 * @param m1
	 * @return
	 */
	public TStock arrangement(HashMap<String, String> m1) {
		TStock t = new TStock();

		t.setId(Long.parseLong(m1.get("id")));

		t.setPurchaseId(Integer.valueOf(m1.get("purchaseId")));

		t.setStockTypeArea(Byte.valueOf(m1.get("stockTypeArea")));

		t.setStoreQuantity(Integer.valueOf(m1.get("storeQuantity")));

		long unitPrice = Float.valueOf(m1.get("unitPrice")).longValue();
		t.setUnitPrice(unitPrice);

		t.setStoreCommodity(m1.get("storeCommodity"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(m1.get("enterStockTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		t.setEnterStockTime(date);

		t.setAgreeEnterStock(Boolean.valueOf(m1.get("agreeEnterStock")));

		t.setRemark(m1.get("remark"));

		System.out.println(t.toString());
		return t;

	}

	/**
	 * purchaseId=43&commodity=陶峰久和豆沙包&supplier=久和陶峰食物事务所&quantity=65 <br>
	 * &amountMoney=120.33&operator=user333&purchaseTime=Tue Oct 15 13:10:54 CST
	 * 2019&classify=1
	 * 
	 * @param string
	 * @return
	 */
	public HashMap<String, String> generateMap(String string) {
		String[] sp = string.split("&");

		m1 = splitStringPutsHashMap(sp[0]);
		m1 = splitStringPutsHashMap(sp[1]);
		m1 = splitStringPutsHashMap(sp[2]);
		m1 = splitStringPutsHashMap(sp[3]);
		m1 = splitStringPutsHashMap(sp[4]);
		m1 = splitStringPutsHashMap(sp[5]);
		m1 = splitStringPutsHashMap(sp[6]);
		m1 = splitStringPutsHashMap(sp[7]);

		System.out.println(m1);
		return m1;

	}

	/**
	 * generateMap之改善
	 * 
	 * @param string
	 * @return
	 */
	public HashMap<String, String> generateMapImprove(String string) {
		String[] sp = string.split("&");

		int n = 0;
		while (n < sp.length) {
			m1 = splitStringPutsHashMap(sp[n]);
			n++;
		}

		for (Map.Entry<String, String> entry : m1.entrySet()) {
			System.out.print(" " + entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("\n");
		return m1;

	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public HashMap<String, String> splitStringPutsHashMap(String str) {
		String[] strs = str.split("=");

		if (strs.length < 2) {
			map.put(strs[0], "有问题;");
			return map;
		}

		map.put(strs[0], strs[1]);
		return map;
	}

//	public static void main(String[] args) {
//		StockServiceUtil util = new StockServiceUtil();
//		String string = "id=19&purchaseId=26&enterStockTime=2011-10-11 12:25:01&storeCommodity=月影蛋糕油&storeQuantity=60&unitPrice=10.01&stockTypeArea=0&remark=必火,暗藏就上起来安保九亭之外&agreeEnterStock=true";
//		HashMap<String, String> map2 = util.generateMapImprove(string);
//		for (Map.Entry<String, String> entry : map2.entrySet()) {
//			System.out.print(" " + entry.getKey() + "=" + entry.getValue());
//		}
//		TStock stock = util.arrangement(map2);
//		System.out.println();
//		System.out.println(stock.toString());
//	}

}
