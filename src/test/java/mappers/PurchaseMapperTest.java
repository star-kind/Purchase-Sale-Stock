package mappers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.PurchaseMapper;
import pojo.Purchase;

public class PurchaseMapperTest {
	private ApplicationContext applicationContext;
	private PurchaseMapper pm;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
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

		p.setCommodity("the-real");
		p.setIsAgree(0);
		p.setAmountMoney(123.36f);
		p.setIsEnterStore(0);
		p.setIsPay(1);
		p.setQuantity(10);
		p.setPaymentMethod(0);
		p.setPurchaseTime(new Date());
		p.setSupplier("flims");
		p.setOperator("admin");

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