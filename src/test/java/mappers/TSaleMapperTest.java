package mappers;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.pojo.TSale;

public class TSaleMapperTest {
	private ApplicationContext applicationContext;
	private TSaleDAO tSaleDAO;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
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
