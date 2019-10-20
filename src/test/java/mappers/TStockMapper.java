package mappers;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.TStock;

public class TStockMapper {
	private ApplicationContext applicationContext;
	private TStockDAO dao;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}
	
	@Test
	public void selectWholeTest() {
		dao = (TStockDAO) applicationContext.getBean("TStockDAO");
		
		List<TStock> list = dao.selectAllRows();
		for (TStock tStock : list) {
			System.err.println(tStock);
		}
		
	}
}
