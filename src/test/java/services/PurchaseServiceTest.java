package services;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Purchase;
import service.IPurchaseService;
import service.ex.SelfServiceException;

public class PurchaseServiceTest {
	private ApplicationContext applicationContext;
	private IPurchaseService ips;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[]{"spring/spring-dao.xml", "spring/spring-service.xml"});
	}

	@Test
	public void addOneTest() {
		ips = (IPurchaseService) applicationContext.getBean("purchaseServiceImpl");

		Purchase p = new Purchase();

		p.setCommodity("stayin'alive");
		p.setAmountMoney(300.36f);
		p.setPaymentMethod(1);
		p.setSupplier("jeus");
		p.setQuantity(10);

		try {
			Integer effect = ips.addOnePurchaseApplicationForm(p, "admin33");
			System.out.println("effect-" + effect);
		} catch (SelfServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void exhibitionAllTest() {
		ips = (IPurchaseService) applicationContext.getBean("purchaseServiceImpl");

		List<Purchase> list = ips.exhibitsAll();

		for (Purchase purchase : list) {
			System.out.println(purchase.toString());
		}
	}

}