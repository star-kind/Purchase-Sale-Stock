package mappers;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.AssociativeMapper;
import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.JointStockVO;

public class AssociateMapperTest {
	private ApplicationContext applicationContext;
	private AssociativeMapper am;

	@Before
	public void initial() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void selectTest() {
		am = (AssociativeMapper) applicationContext.getBean("associativeMapper");

		List<AssociativeEntity> query = am.multiTableJointQuery(3, 1);

		for (AssociativeEntity associativeEntity : query) {
			System.err.println(associativeEntity.toString());
		}
	}

	@Test
	public void selectLimitTest() {
		am = (AssociativeMapper) applicationContext.getBean("associativeMapper");

		List<AssociativeEntity> query = am.multiTableJointQueryLimit(3, 1, 1, 4);

		for (AssociativeEntity associativeEntity : query) {
			System.err.println(associativeEntity.toString());
		}
	}
	
	@Test
	public void selectsTest() {
		am = (AssociativeMapper) applicationContext.getBean("associativeMapper");

		List<JointStockVO> jointStockVO = am.queryByStID(21);
		
		System.err.println(jointStockVO);
	}

}
