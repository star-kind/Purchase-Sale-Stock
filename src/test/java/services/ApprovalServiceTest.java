package services;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class ApprovalServiceTest {
	private ApplicationContext applicationContext;
	private IOutStockService ioss;
	private IApprovalService iass;

	@Before
	public void initialize() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void selectTest() {
		ioss = (IOutStockService) applicationContext.getBean("outStockServiceImpl");

		try {
			PaginationII<List<AssociativeEntity>> paginationII = ioss.exhibitionQueuePlus(54, 3, 1, 1, 4);

			System.err.println(paginationII);
		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void selectLimitTest() {
		iass = (IApprovalService) applicationContext.getBean("approvalServiceImpl");

		try {
			PaginationII<List<TApproval>> pagination = iass.exhibitionAllOnPagination(60, 12, 4);

			System.err.println(pagination.toString());
		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

}
