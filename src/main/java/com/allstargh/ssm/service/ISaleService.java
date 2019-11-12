package com.allstargh.ssm.service;

import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 销售记录业务
 * 
 * @author admin
 *
 */
public interface ISaleService {
	/**
	 * 送审
	 * 
	 * @param uid
	 * @param sid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer submitCensorship(Integer uid, Integer sid) throws SelfServiceException;

	/**
	 * 改动
	 * 
	 * @param uid
	 * @param tSale
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer revision(Integer uid, TSale tSale) throws SelfServiceException;

	/**
	 * 查找一笔记录单
	 * 
	 * @param uid
	 * @param id
	 * @return
	 * @throws SelfServiceException
	 */
	TSale searchSingle(Integer uid, Integer id) throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @param tSale
	 * @return
	 * @throws SelfServiceException
	 */
	Integer add(Integer uid, TSale tSale) throws SelfServiceException;

	/**
	 * 分页展示
	 * 
	 * @param pageth 当前页
	 * @param rows   每页显示条数
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	Pagination<TSale> pagingDisplay(Integer pageth, Integer rows, Integer uid) throws SelfServiceException;
}
