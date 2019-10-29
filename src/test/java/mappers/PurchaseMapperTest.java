package mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.pojo.Purchase;

public class PurchaseMapperTest {
	private ApplicationContext applicationContext;
	private PurchaseMapper pm;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void countTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Map<Integer, Integer> hashMap = pm.countPurchaseIdGroupByClassify();

		for (Map.Entry<Integer, Integer> element : hashMap.entrySet()) {
			System.err.println(element.getKey() + ", " + element.getValue());
		}
	}

	@Test
	public void selectTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> list = pm.selectByClassifyAndIsAgree(0, 1);

		for (Purchase purchase : list) {
			System.err.println(purchase.toString());
		}
	}

	@Test
	public void selectConditionTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

//		List<Purchase> list = pm.selectByClassifyAndOperator("p666", 1);
//		List<Purchase> list = pm.selectByHasTakeGoodsAndOperator("p666", 1);
//		List<Purchase> list = pm.selectByPaymentMethodAndOperator("p666", 1);
//		List<Purchase> list = pm.selectByIsPayAndOperator("p666", 1);
//		List<Purchase> list = pm.selectByVagueCommodityAndOperator("之", "p666");
//		List<Purchase> list = pm.selectByVagueSupplierAndOperator("公司", "p666");
//		List<Purchase> list = pm.selectByIsAgreeAndOperator("user333", 1);
		Purchase purchase = pm.selectByPurchaseIdAndOperator("user333", 23);

		List<Purchase> list = new ArrayList<Purchase>();
		list.add(purchase);

		for (Purchase purchase1 : list) {
			System.err.println(purchase1.toString());
		}

	}

	@Test
	public void updatedDatasTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Integer[] pids = new Integer[10];

		pids[0] = 53;
//		pids[1] = 0;
//		pids[2] = 48;
//		pids[3] = 49;

		Integer affecteds = pm.updateMultipleRowByPids(pids, 1);

		System.err.println("affecteds--" + affecteds);
	}

	@Test
	public void findDatasTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> list = pm.selectByPurchasesIsAgree(0);

		for (Purchase purchase : list) {
			System.err.println(purchase.toString());
		}

	}

	@Test
	public void eneterQueueTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> queue = pm.selectEnterQueue(1, 1);

		for (Purchase purchase : queue) {
			System.err.println(purchase.toString());
		}
	}

	@Test
	public void selectDoubleExampleTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> list = pm.selectByHasTakeAndAgree(1, 1);

		for (Purchase purchase : list) {
			System.err.println(purchase.toString());
		}
	}

	@Test
	public void multiplesDeleteTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Integer[] ids = { 1, 2, 3 };

		Integer effcts = pm.deleteMultipleRowsByIds(ids);
		System.err.println("effects-" + effcts);
	}

	@Test
	public void deleteOneTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		int row = pm.deleteByPrimaryKey(10);
		System.err.println("delete-" + row);
	}

	@Test
	public void updateTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Purchase p = new Purchase();
		p.setCommodity("弯矩值长");
		p.setSupplier("english");
		p.setQuantity(101);
		p.setAmountMoney(222.66f);
		p.setPaymentMethod(1);
		p.sethasTakeGoods(1);
		p.setPurchaseTime(new Date());
		p.setPurchaseId(8);

		Integer effect = pm.updatePurchaseByPurchaseId(p);
		System.out.println("effect-" + effect);
	}

	@Test
	public void selectByIdTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Purchase purchase = pm.selectByPrimaryKey(12);

		System.err.println(purchase.toString());
	}

	@Test
	public void selectByOperatorTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> list = pm.selectWholeByOperator("user333");

		for (Purchase purchase : list) {
			System.err.println(purchase.toString());
		}
	}

	@Test
	public void insertIntoTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		Purchase p = new Purchase();

		p.setCommodity("兰之力");
		p.setIsAgree(0);
		p.setAmountMoney(1230.36f);
		p.sethasTakeGoods(1);
		p.setIsPay(1);
		p.setQuantity(10);
		p.setPaymentMethod(0);
		p.setPurchaseTime(new Date());
		p.setSupplier("Google");
		p.setOperator("p666");
		p.setClassify(5);

		int row = pm.insertIntoNewRow(p);
		System.out.println("row-" + row);
	}

	@Test
	public void selectAllTest() {
		pm = (PurchaseMapper) applicationContext.getBean("purchaseMapper");

		List<Purchase> list = pm.selectAllPurchase();

		for (Purchase purchase : list) {
			System.out.println(purchase.toString());
		}
	}

}