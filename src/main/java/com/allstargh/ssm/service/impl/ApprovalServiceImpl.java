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
import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.pojo.TApprovalExample;
import com.allstargh.ssm.pojo.TApprovalExample.Criteria;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.util.PurchaseServiceUtil;

@Service
public class ApprovalServiceImpl implements IApprovalService {
	@Autowired
	private TApprovalDAO tad;

	@Autowired
	private TSaleDAO tsd;

	@Autowired
	private TOutDAO tod;

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
		
		short param=0;

		// 检查账号
		boolean b = ics.checkForAccount(account, 1);

		// 采购申请,设Key=2;获取所有is_agree=0 from purchase
		List<Purchase> list = pmp.selectByPurchasesIsAgree(0);

		// 出库申请,Key=4,has_approval_handle=false
		List<TOut> list1 = tod.selectByHasApprovalHandle(false);

		// 提货申请,Key=3,销售提货申请:has_submitted_approval=0
		List<TSale> list2 = tsd.selectByHasSubmittedApproval(param);

		map.put(2, list);
		map.put(4, list1);
		map.put(3, list2);

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
