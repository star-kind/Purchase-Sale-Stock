package services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class OutStoreServicesTests {
	private ApplicationContext applicationContext;
	private IOutStockService ioss;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void testSelectByKey() {
		ioss = (IOutStockService) applicationContext.getBean("outStockServiceImpl");

		try {
			TOut tOut = ioss.getToutProfileById(60, 1);

			System.err.println(tOut.toString());
		} catch (SelfServiceException s) {
			System.out.println(s.getMessage());
		}
	}

}
