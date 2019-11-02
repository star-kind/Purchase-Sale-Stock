/* https://github.com/orange1438 */
package com.allstargh.ssm.mapper;

import com.allstargh.ssm.pojo.TApproval;
import com.allstargh.ssm.pojo.TApprovalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由
 * https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation
 * 自动生成
 * 
 * @author orange1438 code generator date:2019-10-27 18:56:36
 */
public interface TApprovalDAO {
	/**
	 * 查询数量
	 * 
	 * @param example 条件对象
	 * @return 返回数据的数量
	 */
	long countByExample(TApprovalExample example);

	/**
	 * 根据条件删除
	 * 
	 * @param example 条件对象
	 * @return 返回删除成功的数量
	 */
	int deleteByExample(TApprovalExample example);

	/**
	 * 根据ID删除
	 * 
	 * @param id 主键ID
	 * @return 返回删除成功的数量
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 添加对象所有字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insert(TApproval record);

	/**
	 * 添加对象对应字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insertSelective(TApproval record);

	/**
	 * 根据条件查询（二进制大对象）
	 * 
	 * @param example 条件对象
	 * @return 返回查询的结果
	 */
	List<TApproval> selectByExample(TApprovalExample example);

	/**
	 * 根据ID查询
	 * 
	 * @param id 主键ID
	 * @return 返回查询的结果
	 */
	TApproval selectByPrimaryKey(Integer id);

	/**
	 * 根据条件修改对应字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExampleSelective(@Param("record") TApproval record, @Param("example") TApprovalExample example);

	/**
	 * 根据条件修改所有字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExample(@Param("record") TApproval record, @Param("example") TApprovalExample example);

	/**
	 * 根据ID修改对应字段
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKeySelective(TApproval record);

	/**
	 * 根据ID修改所有字段(必须含ID）
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKey(TApproval record);
}