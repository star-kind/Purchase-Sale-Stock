package services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.PagingTextII;
import com.allstargh.ssm.service.IAccountsService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class AssociativeServicesTests {
	private ApplicationContext applicationContext;
	private IOutStockService ioss;

	@Before
	public void initialize() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void testLimit() {
		ioss = (IOutStockService) applicationContext.getBean("outStockServiceImpl");

		try {
			PaginationII<List<AssociativeEntity>> paginationII = ioss.exhibitionQueuePlus(54, 3, 1, 4, 4);

			System.err.println(paginationII);
		} catch (SelfServiceException s) {
			System.out.println(s.getMessage());
		}
	}

}
