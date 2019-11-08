package com.allstargh.ssm.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.controller.kits.ApprovalControllerUtil;
import com.allstargh.ssm.controller.kits.ControllerUtils;
import com.allstargh.ssm.mapper.AccountsMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TApprovalDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.pojo.TApprovalExample;
import com.allstargh.ssm.pojo.TApprovalExample.Criteria;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.util.PurchaseServiceUtil;

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

	/**
	 * 
	 */
	PurchaseServiceUtil psu = PurchaseServiceUtil.getInstance();

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

	@Override
	public String[] readOutputSubstanceLog(Integer usrid) throws IOException, SelfServiceException {
		Accounts account = ics.checkForAccount(usrid, 1);

		String path = ControllerUtils.ENGINE_DAILY_PATH;

		StringBuffer buffer = new StringBuffer(path);

		String pathCompelete = buffer.append(ApprovalControllerUtil.DAILY_FILE_NAME).toString();

		Path path1 = Paths.get(pathCompelete);

		String string = new String();
		try {
			byte[] bytes = Files.readAllBytes(path1);
			string = new String(bytes);

		} catch (Exception e) {
			e.printStackTrace();

		}

		String[] split = string.split("\\n|\\r");

		if (split.length > 10 * 1024) {
			System.err.println(this.getClass().getName() + ",文件超限");
			psu.cleanSubstance(pathCompelete);
		}

		return split;
	}

	@Override
	public List<TApproval> exhibitionAll(Integer uid) throws SelfServiceException {
		Accounts account = ics.checkForAccount(uid, 1);

		TApprovalExample example = new TApprovalExample();

		example.setOrderByClause("original_order asc");
		example.setDistinct(false);

		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();

		List<TApproval> list = tad.selectByExample(example);

		return list;
	}

	@Override
	public Integer revampByID(Integer uid, Integer approveOperates, String replyOpinion, Integer tid)
			throws SelfServiceException {
		TApprovalExample example = new TApprovalExample();
		Criteria criteria = example.createCriteria();

		TApproval tApproval = new TApproval();

		Accounts account = ics.checkForAccount(uid, 1);

		tApproval.setReplyOpinion(replyOpinion);

		if (approveOperates == 0) {
			tApproval.setApproveOperates(false);
		} else if (approveOperates == 1) {
			tApproval.setApproveOperates(true);
		}

		tApproval.setApprovalsTime(new Date());
		tApproval.setAuditor(uid);

		criteria.andIdEqualTo(tid);

		int selective = tad.updateByExampleSelective(tApproval, example);

		return selective;
	}

	@Override
	public TApproval obtainTApprovalByID(Integer uid, Integer approvalID) throws SelfServiceException {
		Accounts account = ics.checkForAccount(uid, 1);

		TApproval tApproval = tad.selectByPrimaryKey(approvalID);

		return tApproval;
	}

}
