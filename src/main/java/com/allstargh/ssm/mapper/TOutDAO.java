/* https://github.com/orange1438 */
package com.allstargh.ssm.mapper;

import com.allstargh.ssm.pojo.TOut;
import com.allstargh.ssm.pojo.TOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由
 * https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation
 * 自动生成
 * 
 * @author orange1438 code generator date:2019-11-14 18:08:07
 */
public interface TOutDAO {
	/**
	 * 根据是否已被审批部门处理查询
	 * 
	 * @param choice
	 * @return
	 */
	List<TOut> selectByHasApprovalHandle(Boolean choice);

	/**
	 * 查询数量
	 * 
	 * @param example 条件对象
	 * @return 返回数据的数量
	 */
	long countByExample(TOutExample example);

	/**
	 * 根据条件删除
	 * 
	 * @param example 条件对象
	 * @return 返回删除成功的数量
	 */
	int deleteByExample(TOutExample example);

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
	int insert(TOut record);

	/**
	 * 添加对象对应字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insertSelective(TOut record);

	/**
	 * 根据条件查询（二进制大对象）
	 * 
	 * @param example 条件对象
	 * @return 返回查询的结果
	 */
	List<TOut> selectByExample(TOutExample example);

	/**
	 * 根据ID查询
	 * 
	 * @param id 主键ID
	 * @return 返回查询的结果
	 */
	TOut selectByPrimaryKey(Integer id);

	/**
	 * 根据条件修改对应字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExampleSelective(@Param("record") TOut record, @Param("example") TOutExample example);

	/**
	 * 根据条件修改所有字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExample(@Param("record") TOut record, @Param("example") TOutExample example);

	/**
	 * 根据ID修改对应字段
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKeySelective(TOut record);

	/**
	 * 根据ID修改所有字段(必须含ID）
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKey(TOut record);
}