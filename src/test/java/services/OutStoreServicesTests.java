package services;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class OutStoreServicesTests {
	private ApplicationContext applicationContext;
	private IOutStockService ioss;

	@Before
	public void initialize() throws Exception {
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

	@Test
	public void testDisplay() {
		ioss = (IOutStockService) applicationContext.getBean("outStockServiceImpl");

		try {
			PaginationII<List<TStock>> queue = ioss.exhibitionQueue(54, 3, 1, 3, 3);

			System.err.println(queue.toString());
		} catch (SelfServiceException s) {
			System.out.println(s.getMessage());
		}
	}

}
