package service;

import java.util.List;

import org.springframework.ui.ModelMap;

import pojo.Purchase;
import service.ex.SelfServiceException;

/**
 * 采购进货业务接口
 * 
 * @author gzh
 *
 */
public interface IPurchaseService {
	/**
	 * 根据采购经理暂时其历史办理单子
	 * 
	 * @param operator
	 * @return
	 * @throws SelfServiceException
	 */
	List<Purchase> exhibitsPurchaseByOperator(String operator) throws SelfServiceException;

	/**
	 * 检查是否为激活状态下的采购专员
	 * 
	 * @param usrid
	 * @return
	 */
	String checkOperatorCompetence(Integer usrid, ModelMap model);

	/**
	 * 采购经理增加一份进货采购申请单
	 * 
	 * @param purchase
	 * @param usrname  采购经理之名
	 * @return
	 * @throws SelfServiceException
	 */
	Integer addOnePurchaseApplicationForm(Purchase purchase, String usrname) throws SelfServiceException;

	/**
	 * 以列表形式展示全部的进货采购申请单
	 * 
	 * @return
	 */
	List<Purchase> exhibitsAll();

}