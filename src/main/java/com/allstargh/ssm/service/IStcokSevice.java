package com.allstargh.ssm.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.allstargh.ssm.pojo.PagingText;
import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 仓储
 * 
 * @author admin
 *
 */
public interface IStcokSevice {
	/**
	 * 
	 * @param uid
	 * @param sid
	 * @return
	 * @throws SelfServiceException
	 */
	Integer getStoreQuantityByID(Integer uid, Integer sid) throws SelfServiceException;

	/**
	 * 按存储类型区域查询
	 * 
	 * @param uid
	 * @param type
	 * @return
	 * @throws SelfServiceException
	 */
	List<TStock> foundByStockTypeArea(Integer uid, Integer type) throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	abstract String[] readDailyLog(Integer uid) throws SelfServiceException, IOException;

	/**
	 * 分页察看文本日志记录
	 * 
	 * <b><i>overload<i><b>
	 * 
	 * @param uid
	 * @param pageNum
	 * @return
	 * @throws SelfServiceException
	 * @throws IOException
	 */
	abstract PagingText readDailyLog(Integer uid, Integer pageNum)
			throws SelfServiceException, IOException;

	/**
	 * 
	 * @param usrid
	 * @param areaOrder 储藏区序号
	 * @return
	 * @throws SelfServiceException
	 */
	abstract List<TStock> foundByTypeArea(Integer usrid, Byte areaOrder) throws SelfServiceException;

	/**
	 * 更改仓储货物资料
	 * 
	 * @param usrid
	 * @param tStock
	 * @return
	 * @throws SelfServiceException
	 */
	Integer modifiedStoreGood(Integer usrid, String tStock) throws SelfServiceException;

	/**
	 * 
	 * @param purchaseId
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract TStock findTStockByPurchaseId(Integer purchaseId, Integer usrid) throws SelfServiceException;

	/**
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	abstract List<TStock> findAll(Integer uid) throws SelfServiceException;

	/**
	 * 登记入库
	 * 
	 * @param purchase
	 * @param stockOperator
	 * @return
	 * @throws SelfServiceException
	 */
	Integer regEntry(Purchase purchase, String stockOperator) throws SelfServiceException;

	/**
	 * 接口中的方法亦可重载
	 * 
	 * @param purchase
	 * @param stockOperator
	 * @param remark
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Integer regToExternal(String purchase, String stockOperator, String remark) throws SelfServiceException;
}
