package com.allstargh.ssm.service;

import org.springframework.ui.ModelMap;

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
	 * <b>overload</b>
	 * 
	 * @param usrid
	 * @param competence
	 * @param pageUrl
	 * @return
	 */
	abstract String checkEnterCompetence(Integer usrid, Integer competence, String pageUrl);
}
