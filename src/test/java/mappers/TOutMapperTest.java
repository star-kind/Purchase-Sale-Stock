package mappers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.pojo.TOut;

public class TOutMapperTest {
	private ApplicationContext applicationContext;
	private TOutDAO tom;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}
	
	@Test
	public void selectTest() {
		tom = (TOutDAO) applicationContext.getBean("TOutDAO");
		
		List<TOut> list = tom.selectByHasApprovalHandle(false);
		
		for (TOut tOut : list) {
			System.err.println(tOut.toString());
		}
	}
	
	@Test
	public void insertOneTest() {
		tom = (TOutDAO) applicationContext.getBean("TOutDAO");
		
		TOut t = new TOut();
		
		t.setApplicant(61);
		t.setApproverIsAgree(false);
		t.setClassify(2);
		t.setDestination(11);
		t.setOutTime(new Date());
		t.setQuantity(33);
		t.setRemarks("gosh");
		t.setSaleOperator(58);
		t.setSaleOrder(5);
		t.setStockerIsAgree(false);
		
		byte b=9;
		t.setStoreArea(b);
		
		t.setStoreCommodity("moon");
		t.setStoreOrder(4L);
		t.setHasApprovalHandle(false);
		t.setHasStockHandle(false);
		
		int effect = tom.insert(t);
		
		System.err.println(effect);
	}
	
}
