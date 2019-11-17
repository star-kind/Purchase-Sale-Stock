package mappers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TOutExample;
import com.allstargh.ssm.pojo.TOutExample.Criteria;

public class TOutMapperTest {
	private ApplicationContext applicationContext;
	private TOutDAO tom;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void updateTest() {
		tom = (TOutDAO) applicationContext.getBean("TOutDAO");

		TOutExample example = new TOutExample();
		Criteria criteria = example.createCriteria();

		TOut out = new TOut();

		out.setApproverIsAgree(true);

		criteria.andIdEqualTo(1);

		int effects = tom.updateByExampleSelective(out, example);
		System.err.println(effects);
	}

	@Test
	public void selectByIdTest() {
		tom = (TOutDAO) applicationContext.getBean("TOutDAO");

		TOut tOut = tom.selectByPrimaryKey(1);
		System.err.println(tOut.toString());
	}

	@Test
	public void selectLimitTest() {
		tom = (TOutDAO) applicationContext.getBean("TOutDAO");

		List<TOut> list = tom.selectByHasApprovalHandleAndLimit(false, 1, 3);

		for (TOut tOut : list) {
			System.err.println(tOut.toString());
		}
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
		t.setDestination(0);
		t.setOutTime(new Date());
		t.setQuantity(33);
		t.setRemarks("red pie");
		t.setSaleOperator(58);
		t.setSaleOrder(12);// unique
		t.setStockerIsAgree(false);

		byte b = 9;
		t.setStoreArea(b);

		t.setStoreCommodity("dollar box");
		t.setStoreOrder(11L);// unique
		t.setHasApprovalHandle(false);
		t.setHasStockHandle(false);

		int effect = tom.insert(t);

		System.err.println(effect);
	}

}
