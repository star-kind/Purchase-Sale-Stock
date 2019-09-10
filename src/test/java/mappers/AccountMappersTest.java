package mappers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.AccountsMapper;
import pojo.Accounts;

public class AccountMappersTest {
	private ApplicationContext applicationContext;
	private AccountsMapper accountsMapper;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/spring-dao.xml");
	}

	@Test
	public void selectAllByNameTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Accounts accounts = accountsMapper.selectByUname("Lindewan");
		System.out.println(accounts.toString());
	}

	@Test
	public void selectAllFromAccountsTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		List<Accounts> allFromAccounts = accountsMapper.selectAllFromAccounts();

		for (Accounts accounts : allFromAccounts) {
			System.out.println(accounts.toString());
		}
	}

	@Test
	public void deleteUsrTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Integer row = accountsMapper.deleteOneUsrByUsrid(4);
		System.out.println("earse:" + row);
	}

	@Test
	public void updateUsrTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Integer row = accountsMapper.updateAccountProfileByUsrid("our900",
				"416484645563", 4, 89, new Date(), 20);
		System.out.println("row::" + row);
	}

	@Test
	public void selectUsrByUidTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Accounts accounts = accountsMapper.selectAccountByUsrid(20);
		System.out.println(accounts.toString());
	}

	@Test
	public void updateCancelByUidTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Integer[] ids = {20, 21, 22};
		Integer rows = accountsMapper.batchSetCancelByUsrid(ids);
		System.out.println(rows);
	}

	@Test
	public void updateActiveByUidTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");
		Integer[] ids = {17, 19, 22};
		Integer rows = accountsMapper.batchSetActiveByUsrid(ids);
		System.out.println(":::" + rows);
	}

	@Test
	public void seleByRDTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");

		List<Accounts> list = accountsMapper.selectByRegionDepartment(111, 200);
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}
	
	@Test
	public void seleByCompetenceTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");

		List<Accounts> list = accountsMapper.selectByCompetence(3);
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}
	
	@Test
	public void seleByActTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");

		List<Accounts> list = accountsMapper.selectByActiveStatus(0);
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}
	
	@Test
	public void seleLikeNameTest() {
		accountsMapper = (AccountsMapper) applicationContext
				.getBean("accountsMapper");

		List<Accounts> list = accountsMapper.selectLikeUsrname("r");
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}
	
}
