package services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.ex.SelfServiceException;

public class ApprovalServiceTest {
	private ApplicationContext applicationContext;
	private IApprovalService ias;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void exhibitionTest() {
		ias = (IApprovalService) applicationContext.getBean("approvalServiceImpl");

		try {

			HashMap<Integer, Object> hashMap = ias.exhibition(57);

			for (Map.Entry<Integer, Object> entry : hashMap.entrySet()) {
				System.err.println(entry.getKey() + ", " + entry.getValue());
			}

			List<Purchase> p = (List<Purchase>) hashMap.get(2);
			for (Purchase purchase : p) {
				System.out.println(purchase.toString());
			}

		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

}
