package services;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.Pagination;
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
	public void test01() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {

		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void test02() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {

		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Test
	public void test03() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {

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

			ts.setCommodity("红包");
			ts.setCustomer("北门口弟弟");
			
			short sh=0;
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
