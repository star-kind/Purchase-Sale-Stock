package services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Accounts;
import service.IAccountsService;
import service.ex.SelfServiceException;

public class AccountsServicesTests {
	private ApplicationContext applicationContext;
	private IAccountsService accountsService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-dao.xml", "spring/spring-service.xml" });
	}

	@Test
	public void testReg() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");
		Accounts accounts = new Accounts();
		accounts.setUsrname("");
		accounts.setPhone("1889940007");
		accounts.setRegionDepartment(96);
		accounts.setCompetence(3);

		try {
			Integer i = accountsService.registerRole(accounts);
			System.out.println("i  :" + i);
		} catch (SelfServiceException s) {
			System.out.println(s.getMessage());
		}
	}

	@Test
	public void testDeleteAccount() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");
		try {
			Integer integer = accountsService.earseAnAccount(5);
			System.out.println("row:" + integer);
		} catch (SelfServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testLoginAccount() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		HttpSession session = null;
		try {
			Accounts login = accountsService.login("mana", "666", session);
			System.out.println("ok," + login.hashCode());
		} catch (SelfServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAlterAccount() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		try {
			Integer affect = accountsService.alterAccountProfile("", "56788-sp", 5, 100, 20);
			System.out.println("affect: " + affect);
		} catch (SelfServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testResetKeywordAccount() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");
		Integer[] ids = { 7, 11, 12 };
		Integer affects = accountsService.multipleResetPwd(ids);
		System.out.println("\\+" + affects);
	}

	@Test
	public void testSearchByRD() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		List<Accounts> list = accountsService.gainByRegionDepartment("鸦岭");
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}

	@Test
	public void testSearchByCompetence() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		List<Accounts> list = accountsService.gainByCompetence("仓库主管");
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
	}

	@Test
	public void testReadSubstance() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		try {
			List<String> list = accountsService.readSubstanceFromLog();
			System.out.println(list.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdateLockWord() {
		accountsService = (IAccountsService) applicationContext.getBean("accountsServiceImpl");

		try {
			Integer effect = accountsService.revisePassword("3333", "3210", 33);
			System.out.println("effect:" + effect);
		} catch (SelfServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
