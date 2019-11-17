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
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.pojo.TApprovalExample;
import com.allstargh.ssm.pojo.TApprovalExample.Criteria;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.service.IApprovalService;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.IPurchaseService;
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
	private PurchaseMapper pm;

	@Autowired
	private IPurchaseService ips;

	@Autowired
	private IOutStockService ioss;

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

		short param = 0;

		// 检查账号
		boolean b = ics.checkForAccount(account, 1);

		// 采购申请,设Key=2;from purchase获取所有is_agree=0
		List<Purchase> list = pm.selectByPurchasesIsAgree(0);

		// 出库申请,Key=4;has_approval_handle=false
		List<TOut> list1 = tod.selectByHasApprovalHandle(false);

		// 提货申请,Key=3;销售提货申请:has_submitted_approval=0
		List<TSale> list2 = tsd.selectByHasSubmittedApproval(param);

		map.put(2, list);
		map.put(4, list1);
		map.put(3, list2);

		return map;
	}

	@Override
	public PaginationII<HashMap<Integer, Object>> exhibition(Integer usrid, Integer pageNum, Integer lines)
			throws SelfServiceException {
		Accounts account = acmp.selectAccountByUsrid(usrid);

		// 检查账号
		boolean b = ics.checkForAccount(account, 1);

		HashMap<Integer, Object> map = new HashMap<Integer, Object>();

		PaginationII<HashMap<Integer, Object>> pagination = new PaginationII<HashMap<Integer, Object>>(map);

		short param = 0;

		// 采购申请,设Key=0;from purchase获取is_agree=0
		List<Purchase> list = pm.selectByIsAgreeAndLimit(0, pageNum * lines, lines);

		// 出库申请,Key=1,has_approval_handle=false
		List<TOut> list1 = tod.selectByHasApprovalHandleAndLimit(false, pageNum * lines, lines);

		// 提货申请,Key=2,销售提货申请:has_submitted_approval=0
		List<TSale> list2 = tsd.selectByHasSubmittedApprovalAndLimit(param, pageNum * lines, lines);

		// 算出总页数
		Integer totalPages = getTotalPagesByList(lines);

		map.put(0, list);
		map.put(1, list1);
		map.put(2, list2);

		/*
		 * 判断是否有上一页和下一页
		 */
		if (pageNum == 0 && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(false);

		} else if (pageNum > 0 && pageNum < totalPages) {// 总页数至少3页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(true);

		} else if (pageNum == totalPages && totalPages > 0) {// 总页数字少2页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(true);

		} else if (totalPages == 0) {// 总页数仅仅一页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(false);

		}

		pagination.setCurrentPageth(pageNum);
		pagination.setRows(lines);
		pagination.setTotalPages(totalPages);
		pagination.setData(map);

		return pagination;
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

	/**
	 * 根据List获取总页数
	 * 
	 * @param lines
	 * @return
	 */
	public Integer getTotalPagesByList(Integer lines) {
		short param = 0;

		// 采购申请;获取所有is_agree=0 from purchase
		List<Purchase> list = pm.selectByPurchasesIsAgree(0);

		// 出库申请;has_approval_handle=false
		List<TOut> list1 = tod.selectByHasApprovalHandle(false);

		// 提货申请;销售提货申请:has_submitted_approval=0
		List<TSale> list2 = tsd.selectByHasSubmittedApproval(param);

		// 算出前台页面表格总页数,每张表显示lines行,三张表就是3*lines
		Integer totalPages = (list.size() + list1.size() + list2.size()) / (lines * 3);

		return totalPages;
	}

	@Override
	public Integer agreeOrAgainst(Integer uid, Integer decide, Integer order, String remark, Integer deptNumber)
			throws SelfServiceException {
		Accounts account = ics.checkForAccount(uid, 1);

		Integer affects = null;

		Integer records = null;

		switch (deptNumber) {
		case 2:
			affects = ips.decidedPurchaseIsAgree(uid, order, decide);
			records = backupAdd(uid, remark, decide, order, deptNumber);
			break;

		case 3:
			records = backupAdd(uid, remark, decide, order, deptNumber);
			break;

		case 4:
			affects = ioss.updateIsAgreeByApprover(uid, decide, order);
			records = backupAdd(uid, remark, decide, order, deptNumber);

			// TODO 批准之后,剩余需求数量要相应改变

			break;
		}

		return records;
	}

}
