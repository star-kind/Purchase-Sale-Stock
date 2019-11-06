package services;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IAccountsService;
import com.allstargh.ssm.service.IPurchaseService;
import com.allstargh.ssm.service.IStcokSevice;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class TStockServiceTest {
	private ApplicationContext applicationContext;
	private IStcokSevice iss;
	private IPurchaseService ips;
	private IAccountsService ias;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void selectTest1() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");

		try {
			Integer q = iss.getStoreAuantityByID(61, 21);

			System.err.println(q);
		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void selectByAreaTest1() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");

		try {
			List<TStock> list = iss.foundByStockTypeArea(62, 1);

			for (TStock tStock : list) {
				System.err.println(tStock.toString());
			}
		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void selectByAreaTest() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");

		try {
			List<TStock> list = iss.foundByTypeArea(54, (byte) 0);

			for (TStock tStock : list) {
				System.err.println(tStock.toString());
			}
		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void modifyTest() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");

		TStock t = new TStock();

		t.setStoreCommodity("答复二滕");
		t.setStoreQuantity(91);
		t.setUnitPrice((long) 23.33);
		t.setStockTypeArea((byte) 6);
		t.setRemark("起初,为了世界的呼唤或召唤了大量蛮王皮杰克,我起了一枪秒了");
		t.setLastestModifier("stock");
		t.setLastestModifiedTime(new Date());
		t.setPurchaseId(11);

		try {
			// Integer affect = iss.modifiedStoreGood(54, t);
			System.err.println("affect--" + t.toString());

		} catch (SelfServiceException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void selectTest01() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");

		try {
			TStock stock = iss.findTStockByPurchaseId(19, 54);
			System.err.println(stock.toString());

		} catch (SelfServiceException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void insertOneTest() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");
		ips = (IPurchaseService) applicationContext.getBean("purchaseServiceImpl");

		Purchase p = ips.findPurchaseById(6, 52);
		System.err.println(p);

		TStock stock = new TStock();
		stock.setRemark("666*666");

		try {
			Integer row = iss.regEntry(p, "yier123");
			System.err.println("row-" + row);
		} catch (SelfServiceException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void selectWholeTest() {
		iss = (IStcokSevice) applicationContext.getBean("stockServiceImpl");
		ias = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		List<TStock> list = iss.findAll(57);

		try {
			for (TStock tStock : list) {
				System.err.println(tStock);
			}
		} catch (SelfServiceException e) {
			e.printStackTrace();
		}

	}

}