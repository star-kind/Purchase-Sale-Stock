package mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allstargh.ssm.mapper.TApprovalDAO;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.pojo.TApprovalExample;
import com.allstargh.ssm.pojo.TApprovalExample.Criteria;

public class TApprovalDAOTest {
	private ApplicationContext applicationContext;
	private TApprovalDAO dao;

	@Before
	public void before() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	}

	@Test
	public void selectAllTest() {
		dao = (TApprovalDAO) applicationContext.getBean("TApprovalDAO");

		TApprovalExample example = new TApprovalExample();

		example.setOrderByClause("original_order desc");
		example.setDistinct(false);
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();

		List<TApproval> list = dao.selectByExample(example);
		for (TApproval tApproval : list) {
			System.err.println(tApproval);
		}

	}

	@Test
	public void updateTest() {
		dao = (TApprovalDAO) applicationContext.getBean("TApprovalDAO");

		TApprovalExample example = new TApprovalExample();

		TApproval approval = new TApproval();

		approval.setApprovalsTime(new Date());
		approval.setAuditor(60);
		
		approval.setApproveOperates(false);
		approval.setReplyOpinion("nothing at all");

		Criteria criteria = example.createCriteria();

		criteria.andIdEqualTo(2);

		int selective = dao.updateByExampleSelective(approval, example);
		System.err.println("result-" + selective);

		/*
		 * Preparing: update t_approval SET approvals_time = ?, reply_opinion = ?,
		 * auditor = ?, approve_operates = ? WHERE ( id = ? )
		 */
	}

}
