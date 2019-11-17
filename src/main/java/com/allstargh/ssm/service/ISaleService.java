package com.allstargh.ssm.service;

import java.io.IOException;

import com.allstargh.ssm.pojo.Pagination;
import com.allstargh.ssm.pojo.PagingTextII;
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
	 * 查阅记录日志
	 * 
	 * @param uid
	 * @param pageIndex 第几页
	 * @param lines     每页行数
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	abstract PagingTextII viewLog(Integer uid, Integer pageIndex, Integer lines)
			throws SelfServiceException, IOException;

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
	 * 多权限查找一笔记录单
	 * 
	 * @param uid
	 * @param id
	 * @return
	 * @throws SelfServiceException
	 */
	TSale multiSearchSingle(Integer uid, Integer id) throws SelfServiceException;

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
