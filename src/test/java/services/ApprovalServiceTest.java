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
import com.allstargh.ssm.pojo.TApproval;
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
	public void exhibitionTest1() {
		ias = (IApprovalService) applicationContext.getBean("approvalServiceImpl");

		try {
			HashMap<Integer, Object> map = ias.exhibition(60);

			for (Map.Entry<Integer, Object> element : map.entrySet()) {
				System.err.println(element.getKey() + "," + element.getValue());
			}

			// 分段,切割,分割Map

		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void revampTest() {
		ias = (IApprovalService) applicationContext.getBean("approvalServiceImpl");

		try {
			Integer effect = ias.revampByID(60, 0, "bully", 1);
			System.err.println(effect);

		} catch (SelfServiceException e) {
			System.err.println(e.getMessage());
		}

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

	@Test
	public void exhibitionAllTest() {
		ias = (IApprovalService) applicationContext.getBean("approvalServiceImpl");

		try {
			List<TApproval> list = ias.exhibitionAll(57);

			for (TApproval tApproval : list) {
				System.err.println(tApproval);
			}
		} catch (SelfServiceException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

}
