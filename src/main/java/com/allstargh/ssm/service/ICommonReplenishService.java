package com.allstargh.ssm.service;

import org.springframework.ui.ModelMap;

import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 通用补充业务
 * 
 * @author admin
 *
 */
public interface ICommonReplenishService {
	/**
	 * 检查进入模块的资格
	 * 
	 * @param usrid
	 * @param competence
	 * @param model
	 * @param moduleName
	 * @return
	 */
	abstract String checkEnterCompetence(Integer usrid, Integer competence, ModelMap model, String moduleName);

	/**
	 * <b>Overload,检查进入模块的资格</b>
	 * 
	 * @param usrid
	 * @param competence
	 * @param pageUrl
	 * @return
	 */
	abstract String checkEnterCompetence(Integer usrid, Integer competence, String pageUrl);

	/**
	 * 对账号的校验
	 * 
	 * @param account
	 * @param competence
	 * @return boolean
	 * @throws SelfServiceException
	 */
	abstract boolean checkForAccount(Accounts account, Integer competence) throws SelfServiceException;

	/**
	 * <b>Overload,校验账号权限</b>
	 * 
	 * @param accountId
	 * @param competence
	 * @return
	 * @throws SelfServiceException
	 */
	abstract Accounts checkForAccount(Integer accountId, Integer competence) throws SelfServiceException;

	/**
	 * <h3>Overload,校验账号权限</h3>
	 * 
	 * @param accountId
	 * @param competences 权限码数组
	 * @return Accounts
	 * @throws SelfServiceException
	 */
	abstract Accounts checkForAccount(Integer accountId, Integer[] competences) throws SelfServiceException;

}
