package com.allstargh.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.AssociativeMapper;
import com.allstargh.ssm.mapper.PurchaseMapper;
import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.JointStockVO;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TOutExample;
import com.allstargh.ssm.pojo.TOutExample.Criteria;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

/**
 * 
 * @author admin
 *
 */
@Service
public class OutStockServiceImpl implements IOutStockService {
	@Autowired
	private TOutDAO tod;

	@Autowired
	private TSaleDAO tsd;

	@Autowired
	private TStockDAO tStockDAO;

	@Autowired
	private PurchaseMapper pm;

	@Autowired
	private ICommonReplenishService icrs;

	@Autowired
	private AssociativeMapper associativeMapper;

	@Override
	public TOut getToutProfileById(Integer uid, Integer oid) throws SelfServiceException {
		Integer[] competence = { 1, 4 };

		Accounts account = icrs.checkForAccount(uid, competence);

		TOut out = tod.selectByPrimaryKey(oid);

		return out;
	}

	@Override
	public Integer updateIsAgreeByApprover(Integer uid, Integer decide, Integer id) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 1);

		Boolean choice = null;

		TOutExample example = new TOutExample();
		Criteria criteria = example.createCriteria();

		TOut out = new TOut();

		if (decide == 0) {
			choice = false;
		} else {
			choice = true;
		}

		out.setApproverIsAgree(choice);

		criteria.andIdEqualTo(id);

		int effects = tod.updateByExampleSelective(out, example);
		System.err.println(effects);

		return effects;
	}

	@Override
	public PaginationII<List<TStock>> exhibitionQueue(Integer uid, Integer deptNum, Integer operate, Integer pageth,
			Integer lines) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 4);

		PaginationII<List<TStock>> pagination = new PaginationII<List<TStock>>();

		List<TStock> list = tStockDAO.selectNotInApprovalFromStock(deptNum, operate);

		List<TStock> data = tStockDAO.selectNotInApprovalFromStockLimit(deptNum, operate, pageth * lines, lines);

		// 总页数
		Integer totalPages = list.size() / lines;

		/*
		 * 判断是否有上一页和下一页
		 */
		if (pageth == 0 && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(false);

		} else if (pageth > 0 && pageth < totalPages) {// 总页数至少3页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(true);

		} else if (pageth == totalPages && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(true);

		} else if (totalPages == 0) {// 总页数仅仅一页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(false);

		}

		pagination.setData(data);
		pagination.setTotalPages(totalPages);
		pagination.setRows(lines);
		pagination.setCurrentPageth(pageth);

		return pagination;
	}

	@Override
	public PaginationII<List<AssociativeEntity>> exhibitionQueuePlus(Integer uid, Integer deptNum, Integer operate,
			Integer pageth, Integer lines) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 4);

		PaginationII<List<AssociativeEntity>> pagination = new PaginationII<List<AssociativeEntity>>();

		List<AssociativeEntity> list = associativeMapper.multiTableJointQuery(deptNum, operate);

		List<AssociativeEntity> data = associativeMapper.multiTableJointQueryLimit(deptNum, operate, pageth * lines,
				lines);

		System.err.println("size: ");
		System.err.println(list.size());

		// 总页数
		Integer totalPages = list.size() / lines;

		/*
		 * 判断是否有上一页和下一页
		 */
		if (pageth == 0 && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(false);

		} else if ((pageth + 1) == totalPages && totalPages > 0) {// 总页数至少2页
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(true);

		} else if (totalPages == 0 || data == null) {// 总页数仅仅一页或冇数据
			pagination.setHasNextPage(false);
			pagination.setHasPreviousPage(false);

		} else if (pageth > 0 && pageth < totalPages) {// 总页数至少3页
			pagination.setHasNextPage(true);
			pagination.setHasPreviousPage(true);

		}

		pagination.setData(data);
		pagination.setTotalPages(totalPages);
		pagination.setRows(lines);
		pagination.setCurrentPageth(pageth);

		return pagination;
	}

	@Override
	public List<JointStockVO> gainJointData(Integer uid, Integer sid) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 4);

		List<JointStockVO> vo = associativeMapper.queryByStID(sid);

		return vo;
	}

	@Override
	public Integer addOut(Integer uid, JointStockVO vo) throws SelfServiceException {
		Accounts account = icrs.checkForAccount(uid, 4);

		TOut out = new TOut();

		Purchase purchase = pm.selectByPrimaryKey(vo.getPurchaseId());

		if (purchase == null) {
			String description = ServiceExceptionEnum.STORE_HAD_INVALID.getDescription();
			throw new SelfServiceException(description);
		}

		out.setApplicant(vo.getUid());
		out.setApproverIsAgree(true);
		out.setClassify(purchase.getClassify());
		out.setDestination(account.getRegionDepartment());
		out.setHasApprovalHandle(true);
		out.setHasStockHandle(true);
		out.setOutTime(new Date());
		out.setQuantity(vo.getStoreQuantity());
		out.setRemarks(vo.getRemark());
		out.setSaleOrder(vo.getSalePrimaryKey());
		out.setStockerIsAgree(vo.getStockerIsAgree());
		out.setStoreArea(vo.getStockTypeArea());
		out.setStoreCommodity(vo.getStoreCommodity());
		out.setStoreOrder(vo.getId());
		out.setSaleOperator(uid);

		int affect = tod.insert(out);

		/*
		 * 出库成功(即仓管员同意出库)之后,该货物不应该存在于货仓中了,需要从仓库中删除 TODO
		 */

		return affect;
	}

}
