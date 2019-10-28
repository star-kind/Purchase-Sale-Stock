package com.allstargh.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.allstargh.ssm.pojo.Purchase;
import com.allstargh.ssm.pojo.PurchaseExample;

/**
 * 采购进货mapper
 * 
 * @author gzh
 *
 */
public interface PurchaseMapper {
	/**
	 * 
	 * @param operator
	 * @param IsAgree
	 * @return
	 */
	abstract List<Purchase> selectByIsAgreeAndOperator(@Param("operator") String operator, @Param("isAgree") Integer IsAgree);

	/**
	 * 
	 * @param operator
	 * @param purchaseId
	 * @return
	 */
	abstract Purchase selectByPurchaseIdAndOperator(@Param("operator") String operator,
			@Param("purchaseId") Integer purchaseId);

	/**
	 * 
	 * @param operator
	 * @param classify
	 * @return
	 */
	abstract List<Purchase> selectByClassifyAndOperator(@Param("operator") String operator,
			@Param("classify") Integer classify);

	/**
	 * 
	 * @param operator
	 * @param hasTakeGoods
	 * @return
	 */
	abstract List<Purchase> selectByHasTakeGoodsAndOperator(@Param("operator") String operator,
			@Param("hasTakeGoods") Integer hasTakeGoods);

	/**
	 * 
	 * @param operator
	 * @param paymentMethod
	 * @return
	 */
	abstract List<Purchase> selectByPaymentMethodAndOperator(@Param("operator") String operator,
			@Param("paymentMethod") Integer paymentMethod);

	/**
	 * 
	 * @param operator
	 * @param isPay
	 * @return
	 */
	abstract List<Purchase> selectByIsPayAndOperator(@Param("operator") String operator, @Param("isPay") Integer isPay);

	/**
	 * vague模糊的,供应商
	 * 
	 * @param supplier
	 * @param operator
	 * @return
	 */
	abstract List<Purchase> selectByVagueSupplierAndOperator(@Param("supplier") String supplier,
			@Param("operator") String operator);

	/**
	 * vague模糊的,货物名称
	 * 
	 * @param commodity
	 * @param operator
	 * @return
	 */
	abstract List<Purchase> selectByVagueCommodityAndOperator(@Param("commodity") String commodity,
			@Param("operator") String operator);

	/**
	 * 据IDS多行更新 purchase.is_agree set ?
	 * 
	 * @param pids
	 * @param isAgree
	 * @return
	 */
	abstract Integer updateMultipleRowByPids(@Param("pids") Integer[] pids, @Param("isAgree") Integer isAgree);

	/**
	 * 查询 purchase.is_agree=? 的记录行们
	 * 
	 * @param isAgree
	 * @return
	 */
	abstract List<Purchase> selectByPurchasesIsAgree(Integer isAgree);

	/**
	 * 查询待入库队列
	 * 
	 * @param hasTakeGoods
	 * @param isAgree
	 * @return
	 */
	List<Purchase> selectEnterQueue(@Param("hasTakeGoods") Integer hasTakeGoods, @Param("isAgree") Integer isAgree);

	/**
	 * 根据是否取货和是否获批查询集合
	 * 
	 * @param hasTakeGoods
	 * @param isAgree
	 * @return
	 */
	List<Purchase> selectByHasTakeAndAgree(@Param("hasTakeGoods") Integer hasTakeGoods,
			@Param("isAgree") Integer isAgree);

	/**
	 * 多行采购单被删除,据ID们
	 * 
	 * @param purchaseIds
	 * @return
	 */
	Integer deleteMultipleRowsByIds(@Param("purchaseIds") Integer[] purchaseIds);

	/**
	 * 根据ID修改更新
	 * 
	 * @param purchase
	 * @return
	 */
	Integer updatePurchaseByPurchaseId(Purchase purchase);

	/**
	 * 根据单子实际负责人查询属于他经手的单子
	 * 
	 * @param operator
	 * @return
	 */
	List<Purchase> selectWholeByOperator(@Param("operator") String operator);

	/**
	 * 全体查询
	 * 
	 * @return
	 */
	List<Purchase> selectWhole();

	/**
	 * 全部查询
	 * 
	 * @return
	 */
	List<Purchase> selectAllPurchase();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int countByExample(PurchaseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int deleteByExample(PurchaseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int deleteByPrimaryKey(Integer purchaseId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int insert(Purchase record);

	/**
	 * 插入一行
	 * 
	 * @param record
	 * @return
	 */
	int insertIntoNewRow(Purchase record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int insertSelective(Purchase record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	List<Purchase> selectByExample(PurchaseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	Purchase selectByPrimaryKey(Integer purchaseId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Purchase record, @Param("example") PurchaseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int updateByExample(@Param("record") Purchase record, @Param("example") PurchaseExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int updateByPrimaryKeySelective(Purchase record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table purchase
	 *
	 * @mbggenerated Tue Sep 10 10:00:38 CST 2019
	 */
	int updateByPrimaryKey(Purchase record);
}