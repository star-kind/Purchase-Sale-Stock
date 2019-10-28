package com.allstargh.ssm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TApprovalDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ex.SelfServiceException;

@Service
public class ApprovalServiceImpl implements IApprovalService {
	@Autowired
	private TApprovalDAO tad;

	@Autowired
	private AccountsMapper acmp;

	@Autowired
	private ICommonReplenishService ics;

	@Autowired
	private PurchaseMapper pmp;

	@Override
	public Integer backupAdd(Integer usrid, String replyOpinion, Integer decide, Integer appId,
			Integer departmentNumber) throws SelfServiceException {
		TApproval approval = new TApproval();

		Accounts account = acmp.selectAccountByUsrid(usrid);

		// 检查账号
		boolean b = ics.checkForAccount(account, 1);

		approval.setApprovalsTime(new Date());

		if (decide == 0) {
			approval.setApproveOperates(false);
		} else if (decide == 1) {
			approval.setApproveOperates(true);
		}

		approval.setAuditor(account.getUsrid());

		approval.setDepartmentNumber((byte) departmentNumber.intValue());

		approval.setOriginalOrder(appId);

		approval.setReplyOpinion(replyOpinion);

		Integer effcts = tad.insert(approval);

		return effcts;
	}

	@Override
	public HashMap<Integer, Object> exhibition(Integer usrid) throws SelfServiceException {
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();

		Accounts account = acmp.selectAccountByUsrid(usrid);

		// 检查账号
		boolean b = ics.checkForAccount(account, 1);

		// 采购部,设Key=2;获取所有is_agree=0 from purchase
		List<Purchase> list = pmp.selectByPurchasesIsAgree(0);
		map.put(2, list);

		// 仓管部,出库申请,Key=4

		// 销售部,提货申请,Key=3

		return map;
	}

}
