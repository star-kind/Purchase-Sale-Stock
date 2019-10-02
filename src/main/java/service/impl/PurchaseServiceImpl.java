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

	@Override
	public Purchase findPurchaseById(Integer purchaseId, Integer usrid) throws SelfServiceException {
		if (purchaseId == null || "".equals(purchaseId)) {
			String description = ServiceExceptionEnum.COMMIT_HAS_NULL.getDescription();
			throw new SelfServiceException(description);
		}

		if (usrid == null || "".equals(usrid)) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		Accounts a = am.selectAccountByUsrid(usrid);
		if (a.getCompetence() != 2) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(description);
		}

		Purchase purchase = pm.selectByPrimaryKey(purchaseId);
		return purchase;

	}

	@Override
	public Integer editOnePurchaseById(String operator, Purchase purchase) throws SelfServiceException {
		// 经办人不在线
		if (operator == null || "".equals(operator)) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		// 查询在线者资料
		Accounts accounts = am.selectByUname(operator);

		// 在线者不是采购专员
		if (accounts.getCompetence() != 2) {
			String description = ServiceExceptionEnum.COMPETENCE_DISLOCATION.getDescription();
			throw new SelfServiceException(description);
		}

		// 查询原单
		Purchase p = pm.selectByPrimaryKey(purchase.getPurchaseId());

		// 该申购单已获批,无法再改
		if (p.getIsAgree() == 1) {
			String description = ServiceExceptionEnum.OVER_DEADLINE.getDescription();
			throw new SelfServiceException(description);
		}

		purchase.setPurchaseTime(new Date());

		Integer row = pm.updatePurchaseByPurchaseId(purchase);

		return row;
	}

	@Override
	public Integer deleteSinglePurchaseAppById(Integer purchaseId) throws SelfServiceException {
		Integer affect = pm.deleteByPrimaryKey(purchaseId);

		if (affect != 1) {
			String description = ServiceExceptionEnum.SYSTEM_BUSY.getDescription();
			throw new SelfServiceException(description);
		}

		return affect;
	}

	@Override
	public Integer deleteMultiplesPurchaseAppByIds(Integer[] purchaseIds) throws SelfServiceException {
		Integer affects = pm.deleteMultipleRowsByIds(purchaseIds);

		if (affects != purchaseIds.length) {
			String description = ServiceExceptionEnum.SYSTEM_BUSY.getDescription();
			throw new SelfServiceException(description);
		}

		return affects;
	}

}