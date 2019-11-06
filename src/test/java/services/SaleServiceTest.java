package services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public void test04() {
		iss = (ISaleService) applicationContext.getBean("saleServiceImpl");

		try {

		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
