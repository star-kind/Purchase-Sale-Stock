package com.allstargh.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

@Service
public class CommonReplenishServiceImpl implements ICommonReplenishService {
	@Autowired
	private AccountsMapper am;

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

}
