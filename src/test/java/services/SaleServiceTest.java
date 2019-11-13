package services;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.service.ISaleService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class SaleServiceTest {
	private ApplicationContext applicationContext;
	private ISaleService iss;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void testSelectPart() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {
			Pagination<TSale> pagination = iss.pagingDisplay(2, 4, 61);

			System.err.println(pagination.toString());
		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void testReadlog() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {
			PagingTextII log = iss.viewLog(61, 2, 5);

			System.err.println(log);
		} catch (SelfServiceException | IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void testCensorship() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {
			Integer affect = iss.submitCensorship(61, 2);

			System.err.println(affect);
		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void testUpdate() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {
			TSale t = new TSale();

			MathContext context = new MathContext(2);

			BigDecimal p = new BigDecimal(30.11, context);

			long order = 17;

			t.setId((int) order);
			t.setWarehouseGoodsOrder(order);
			t.setCommodity("packing");
			t.setCustomer("my floor");
			t.setAmountMoney(1160.02F);
			t.setAmountPaid(p);
			t.setPaymentMethod(2);
			t.setQuantity(105);
			t.setRegionDepartment(5);

			Integer effect = iss.revision(61, t);
			System.err.println(effect);
		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void insertOneTest() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {
			TSale ts = new TSale();

			ts.setAmountMoney(254.21F);

			BigDecimal paid = BigDecimal.valueOf(11.55);
			ts.setAmountPaid(paid);

			ts.setCommodity("17");
			ts.setCustomer("北门差率");

			short sh = 0;
			ts.setHasSubmittedApproval(sh);

			ts.setIsEnoughStock(sh);
			ts.setIsPay(2);
			ts.setPaymentMethod(0);
			ts.setQuantity(302);
			ts.setRegionDepartment(7);
			ts.setSaleOperator(61);
			ts.setSaleTime(new Date());
			ts.setSurplusDemand(302);

			Integer affect = iss.add(61, ts);
			System.err.println(affect);
		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

}
