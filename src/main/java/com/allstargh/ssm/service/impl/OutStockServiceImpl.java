package com.allstargh.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstargh.ssm.mapper.TOutDAO;
import com.allstargh.ssm.mapper.TSaleDAO;
import com.allstargh.ssm.mapper.TStockDAO;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.pojo.PaginationII;
import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TOutExample;
import com.allstargh.ssm.pojo.TOutExample.Criteria;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ICommonReplenishService;
import com.allstargh.ssm.service.IOutStockService;
import com.allstargh.ssm.service.ex.SelfServiceException;

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
	private ICommonReplenishService icrs;

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

		List<TStock> data = tStockDAO.selectNotInApprovalFromStockLimit(deptNum, operate, pageth * lines, lines);

		// 总页数
		int totalPages = data.size() / lines;

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

}
