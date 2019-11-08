package com.allstargh.ssm.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.allstargh.ssm.controller.kits.StockControllerUtil;
import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;
import com.allstargh.ssm.service.util.PurchaseServiceUtil;

@Service
public class CommonReplenishServiceImpl implements ICommonReplenishService {
	@Autowired
	private AccountsMapper am;

	/**
	 * PurchaseServiceUtil
	 */
	PurchaseServiceUtil psu = PurchaseServiceUtil.getInstance();

	@Override
	public String checkEnterCompetence(Integer usrid, Integer competence, ModelMap model, String moduleName) {
		Accounts acc = am.selectAccountByUsrid(usrid);

		Integer code = acc.getCompetence();
		System.err.println("code==" + code);

		Integer status = acc.getActiveStatus();

		if (code != competence) {
			model.addAttribute("info", "您没有相应权限,不是该部门人员,无权入此模块");
			return "Transfer";
		}

		if (status == 0) {
			model.addAttribute("information", "您的账号已被注销,请联系系统管理员处理");
			return "Transfer";
		}

		return moduleName;
	}

	@Override
	public String checkEnterCompetence(Integer usrid, Integer competence, String pageUrl) {
		Accounts acc = am.selectAccountByUsrid(usrid);

		Integer code = acc.getCompetence();
		System.err.println("competence code==" + code);

		Integer status = acc.getActiveStatus();

		if (code != competence) {
			return "#";
		}

		if (status == 0) {
			return "#";
		}

		return pageUrl;

	}

	@Override
	public boolean checkForAccount(Accounts account, Integer competence) throws SelfServiceException {
		if (account == null) {
			String description = ServiceExceptionEnum.USRNAME_ERR.getDescription();
			throw new SelfServiceException(description);

		} else if (account.getActiveStatus() == 0) {
			String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
			throw new SelfServiceException(description);

		} else if (account.getCompetence() != competence) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(description);

		}

		return true;
	}

	@Override
	public Accounts checkForAccount(Integer accountId, Integer competence) throws SelfServiceException {
		Accounts account = am.selectAccountByUsrid(accountId);

		if (account == null) {
			String description = ServiceExceptionEnum.USRNAME_ERR.getDescription();
			throw new SelfServiceException(description);

		} else if (account.getActiveStatus() == 0) {
			String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
			throw new SelfServiceException(description);

		} else if (account.getCompetence() != competence) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(description);

		}

		return account;
	}

	@Override
	public Accounts checkForAccount(Integer accountId, Integer[] competences) throws SelfServiceException {
		Accounts account = am.selectAccountByUsrid(accountId);

		if (account == null) {
			String description = ServiceExceptionEnum.USRNAME_ERR.getDescription();
			throw new SelfServiceException(description);

		} else if (account.getActiveStatus() == 0) {
			String description = ServiceExceptionEnum.CANCELED_ACCOUNT.getDescription();
			throw new SelfServiceException(description);

		}

		int n = 0;
		for (int i = 0; i < competences.length; i++) {
			if (account.getCompetence() == competences[i]) {
				n += 1;
			}
		}

		System.err.println("n:" + n);

		if (n == 0) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(description);
		}

		return account;
	}

	@Override
	public void checkTextOutOfCapacity(String path, int capacity) throws IOException {
		Path path1 = Paths.get(path);

		String string = new String();
		try {
			byte[] bytes = Files.readAllBytes(path1);
			string = new String(bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] split = string.split("\n|\r");

		// 如已超限则排空
		if (split.length > capacity) {
			System.err.println(this.getClass().getSimpleName() + ",超限");
			psu.cleanSubstance(path);
		}

	}

}
