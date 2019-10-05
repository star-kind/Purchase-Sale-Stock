package com.allstargh.ssm.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.ex.SelfServiceException;

/**
 * 账户之业务接口
 */
public interface IAccountsService {
	/**
	 * 据ID检出资料
	 * 
	 * @param uid
	 * @return
	 * @throws SelfServiceException
	 */
	Accounts exhibitionBaseProfile(Integer uid) throws SelfServiceException;

	/**
	 * 修改基本资料:名字和电话
	 * 
	 * @param usrname
	 * @param phone
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	Integer reviseBaseProfile(String usrname, String phone, Integer usrid) throws SelfServiceException;

	/**
	 * 修改密码
	 * 
	 * @param old     旧密码
	 * @param trueNew 页面提交之新密码
	 * @param uid     账号ID
	 * @return
	 * @throws SelfServiceException
	 */
	Integer revisePassword(String old, String trueNew, Integer uid) throws SelfServiceException;

	/**
	 * 注册一个角色账号<br>
	 * 密码默认666666. 注册时仅需填写姓名+电话+部门编号+职务权限即可
	 * 
	 * @param accounts
	 * @return
	 */
	Integer registerRole(Accounts accounts) throws SelfServiceException;

	/**
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 * @throws SelfServiceException
	 */
	Accounts login(String username, String password, HttpSession session) throws SelfServiceException;

	/**
	 * 根据ID检查权限,判断是否为administrator,并判断是否已被注销
	 * 
	 * @param usrname
	 * @return
	 */
	String checkAdminCompetence(Integer uid, ModelMap model);

	/**
	 * 遍览全部账户
	 * 
	 * @param model
	 * @return
	 */
	String browsersAllAccounts(ModelMap model);

	/**
	 * 消除一个账户
	 * 
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	Integer earseAnAccount(Integer usrid) throws SelfServiceException;

	/**
	 * 获取单个账号数据
	 * 
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	Accounts gainAccount(Integer usrid) throws SelfServiceException;

	/**
	 * 修改单个账号简介
	 * 
	 * @param usrname
	 * @param phone
	 * @param competence
	 * @param regionDepartment
	 * @param usrid
	 * @return
	 * @throws SelfServiceException
	 */
	Integer alterAccountProfile(String usrname, String phone, Integer competence, Integer regionDepartment,
			Integer usrid) throws SelfServiceException;

	/**
	 * 获取要修改的目标简介,并转发至指定编辑页
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	String showingProfileToEditing(HttpServletRequest request, ModelMap modelMap);

	/**
	 * 多人注销
	 * 
	 * @param ids
	 * @return
	 */
	Integer multipleCancel(Integer[] ids);

	/**
	 * 多人激活
	 * 
	 * @param ids
	 * @return
	 */
	Integer multipleActive(Integer[] ids);

	/**
	 * 多人重置密码
	 * 
	 * @param ids
	 * @return
	 */
	Integer multipleResetPwd(Integer[] ids);

	/**
	 * 按部门地区编号查询对应账户
	 * 
	 * @param regionDepartment 页面上的地区部门之名
	 * @return
	 */
	List<Accounts> gainByRegionDepartment(String regionDepartment);

	/**
	 * 按职务查询对应账户
	 * 
	 * @param position
	 * @return
	 */
	List<Accounts> gainByCompetence(String position);

	/**
	 * 按已激活/已注销查询对应账户
	 * 
	 * @param status
	 * @return
	 */
	List<Accounts> gainByActiveStatus(String status);

	/**
	 * 基于获取的只言片语查询
	 * 
	 * @param name
	 * @return
	 * @throws SelfServiceException
	 */
	List<Accounts> findBaseOnLikeName(String name) throws SelfServiceException;

	/**
	 * 从文本内读取内容
	 * 
	 * @param usrid
	 * @return
	 * @throws IOException
	 * @throws SelfServiceException
	 */
	List<String> readSubstanceFromLog(Integer usrid) throws IOException, SelfServiceException;
}
