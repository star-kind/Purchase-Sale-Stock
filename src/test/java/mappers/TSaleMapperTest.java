package mappers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TSaleExample;
import com.allstargh.ssm.pojo.TSaleExample.Criteria;

public class TSaleMapperTest {
	private ApplicationContext applicationContext;
	private TSaleDAO tSaleDAO;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void selectAllTest() {
		tSaleDAO = (TSaleDAO) applicationContext.getBean("TSaleDAO");

		TSaleExample e = new TSaleExample();
		e.setDistinct(false);
		e.setOrderByClause("amount_money,id asc");

		Criteria c = e.createCriteria();
		c.andIdIsNotNull();

		List<TSale> list = tSaleDAO.selectByExample(e);

		for (TSale tSale : list) {
			System.err.println(tSale.toString());
		}

	}

	@Test
	public void limitTest() {
		tSaleDAO = (TSaleDAO) applicationContext.getBean("TSaleDAO");

		int rows = 3;
		List<TSale> list = tSaleDAO.selectLimitByPageRows(1 * rows, rows);

		for (TSale tSale : list) {
			System.err.println(tSale.toString());
		}

	}

	@Test
	public void insertOneTest() {
		tSaleDAO = (TSaleDAO) applicationContext.getBean("TSaleDAO");

		TSale ts = new TSale();

		ts.setAmountMoney(111.11F);

		Double double1 = Double.valueOf(20.14);
		BigDecimal decimal = new BigDecimal(double1);
		ts.setAmountPaid(decimal);

		ts.setCommodity("london boat");
		ts.setCustomer("paris");

		Short s = 1;
		ts.setIsEnoughStock(s);

		ts.setIsPay(3);
		ts.setPaymentMethod(0);
		ts.setQuantity(12);
		ts.setRegionDepartment(6);
		ts.setSaleOperator(58);
		ts.setSaleTime(new Date());

		int effect = tSaleDAO.insert(ts);

		System.err.println(effect);

	}
	
}
