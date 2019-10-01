package mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Accounts;

public interface AccountsMapper {
	/**
	 * 修改部分资料:名字和电话,据ID
	 * 
	 * @param usrname
	 * @param phone
	 * @param usrid
	 * @return
	 */
	Integer updatePartialProfileById(@Param("usrname") String usrname, @Param("phone") String phone,
			@Param("usrid") Integer usrid);

	/**
	 * 
	 * @param accounts
	 * @return
	 */
	Integer insertIntoAccounts(Accounts accounts);

	/**
	 * 根据名字查询完整的一行记录
	 *
	 * @param uname
	 * @return
	 */
	Accounts selectByUname(String uname);

	/**
	 * 根据电话查询对应记录的行数
	 *
	 * @param phone
	 * @return
	 */
	Integer countUidByPhone(String phone);

	/**
	 * 寻找全表账号记录
	 * 
	 * @return
	 */
	List<Accounts> selectAllFromAccounts();

	/**
	 * 
	 * @param usrid
	 * @return
	 */
	Integer deleteOneUsrByUsrid(Integer usrid);

	/**
	 * 根据id修改账号简介
	 * 
	 * @param usrname
	 * @param phone
	 * @param competence
	 * @param regionDepartment
	 * @param usrid
	 * @return
	 */
	Integer updateAccountProfileByUsrid(@Param(value = "usrname") String usrname, @Param(value = "phone") String phone,
			@Param(value = "competence") Integer competence,
			@Param(value = "regionDepartment") Integer regionDepartment,
			@Param(value = "modifiedTime") Date modifiedTime, @Param(value = "usrid") Integer usrid);

	/**
	 * 根据id查找单个账号的全部简介
	 * 
	 * @param usrid
	 * @return
	 */
	Accounts selectAccountByUsrid(Integer usrid);

	/**
	 * 根据id批量注销
	 * 
	 * @param usrids
	 * @return
	 */
	Integer batchSetCancelByUsrid(@Param(value = "usrids") Integer[] usrids);

	/**
	 * 根据id批量激活
	 * 
	 * @param usrids
	 * @return
	 */
	Integer batchSetActiveByUsrid(@Param(value = "usrids") Integer[] usrids);

	/**
	 * 
	 * @param password
	 * @param Usrid
	 * @return
	 */
	Integer updatePasswordByUsrid(@Param("password") String password, @Param("usrid") Integer Usrid);

	/**
	 * 在一个区间内根据部门地区编号查询相应账户
	 * 
	 * @param start 起始编号
	 * @param end   终末编号
	 * @return
	 */
	List<Accounts> selectByRegionDepartment(@Param("start") Integer start, @Param("end") Integer end);

	/**
	 * 新:根据[1个]地区部门编号查找对应的用户集合
	 * 
	 * @param regionDepartment
	 * @return
	 */
	List<Accounts> selectByRegionDepartmentBySingleNum(@Param("regionDepartment") Integer regionDepartment);

	/**
	 * 
	 * @param competence 权限码
	 * @return
	 */
	List<Accounts> selectByCompetence(Integer competence);

	/**
	 * 
	 * @param activeStatus 状态码
	 * @return
	 */
	List<Accounts> selectByActiveStatus(Integer activeStatus);

	/**
	 * 模糊查询,按名寻
	 * 
	 * @param usrname
	 * @return
	 */
	List<Accounts> selectLikeUsrname(String usrname);
}
