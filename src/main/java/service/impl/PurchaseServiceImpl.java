package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import mapper.AccountsMapper;
import mapper.PurchaseMapper;
import pojo.Accounts;
import pojo.Purchase;
import service.IPurchaseService;
import service.ex.SelfServiceException;
import service.ex.ServiceExceptionEnum;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
	@Autowired
	private PurchaseMapper pm;

	@Autowired
	private AccountsMapper am;

	ServiceExceptionEnum instance = ServiceExceptionEnum.getInstance();

	@Override
	public Integer addOnePurchaseApplicationForm(Purchase purchase, String usrname) throws SelfServiceException {
		// 经办人ID是否为空
		if (usrname == null || "".equals(usrname.trim())) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		// 默认未获批:0
		purchase.setIsAgree(0);

		// 默认时间,now
		purchase.setPurchaseTime(new Date());

		// 经手人:usrname
		purchase.setOperator(usrname);

		// 默认未支付:0
		purchase.setIsPay(0);

		// execute
		int affect = pm.insertIntoNewRow(purchase);

		return affect;
	}

	@Override
	public List<Purchase> exhibitsAll() {
		return pm.selectWhole();
	}

	@Override
	public String checkOperatorCompetence(Integer usrid, ModelMap model) {
		Accounts acc = am.selectAccountByUsrid(usrid);
		Integer competence = acc.getCompetence();
		Integer status = acc.getActiveStatus();

		if (competence != 2) {
			model.addAttribute("info", "您非采购执事,无权入此模块");
			return "Transfer";
		}

		if (status == 0) {
			model.addAttribute("info00", "您已被注销,无权入此模块");
			return "Transfer";
		}

		// 返回"上一级目录/页面名"
		return "PurchaseDir/PurchaseWorkable";
	}

	@Override
	public List<Purchase> exhibitsPurchaseByOperator(String operator) throws SelfServiceException {
		if (operator == null || "".equals(operator)) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		List<Purchase> list = pm.selectWholeByOperator(operator);

		return list;
	}

}