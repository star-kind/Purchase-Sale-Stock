package mappers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.pojo.TStockExample;
import com.allstargh.ssm.pojo.TStockExample.Criteria;

public class TStockMapperTest {
	private ApplicationContext applicationContext;
	private TStockDAO dao;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void selectByAreaTest() {
		dao = (TStockDAO) applicationContext.getBean("TStockDAO");

		TStockExample example = new TStockExample();
		Criteria criteria = example.createCriteria();

		example.setDistinct(false);
		example.setOrderByClause("lastest_modified_time asc");

		byte b = 1;
		criteria.andStockTypeAreaEqualTo(b);
		
		List<TStock> list = dao.selectByExample(example);
		
		for (TStock tStock : list) {
			System.err.println(tStock);
		}

	}

	@Test
	public void selectAreaTest() {
		dao = (TStockDAO) applicationContext.getBean("TStockDAO");

		List<TStock> list = dao.selectByPurchaseStockTypeArea((byte) 0);
		for (TStock tStock : list) {
			System.err.println(tStock);
		}

	}

	@Test
	public void selectWholeTest() {
		dao = (TStockDAO) applicationContext.getBean("TStockDAO");

		List<TStock> list = dao.selectAllRows();
		for (TStock tStock : list) {
			System.err.println(tStock);
		}

	}

	@Test
	public void updateOneTest() {
		dao = (TStockDAO) applicationContext.getBean("TStockDAO");

		TStock t = new TStock();

		t.setStoreCommodity("无雨淋漓");
		t.setStoreQuantity(91);
		t.setUnitPrice((long) 23.33);
		t.setStockTypeArea((byte) 6);
		t.setRemark("最终,为了世界的呼唤或去除了大量皮杰克,我起了一枪秒了");
		t.setLastestModifier("ana");
		t.setLastestModifiedTime(new Date());
		t.setPurchaseId(11);

		Integer effect = dao.updateStoreGoodByPurchase(t);
		System.err.println("effect-" + effect);

	}

}
