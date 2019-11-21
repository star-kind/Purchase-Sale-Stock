/* https://github.com/orange1438 */
package com.allstargh.ssm.mapper;

import com.allstargh.ssm.pojo.TSale;
import com.allstargh.ssm.pojo.TSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由
 * https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation
 * 自动生成
 * 
 * @author orange1438 code generator date:2019-11-01 23:48:26
 */
public interface TSaleDAO {
	/**
	 * 根据对应的仓储ID更改剩余需求量
	 * 
	 * @param surplusDemand
	 * @param warehouseGoodsOrder
	 * @return
	 */
	abstract Integer updateSurplusDemandByOrder(@Param("surplusDemand") Integer surplusDemand,
			@Param("warehouseGoodsOrder") Long warehouseGoodsOrder);

	/**
	 * 根据对应的仓储ID查询
	 * 
	 * @param warehouseGoodsOrder
	 * @return
	 */
	abstract TSale selectByGoodsOrder(Long warehouseGoodsOrder);

	/**
	 * 根据hasSubmittedApproval分页查询
	 * 
	 * @param hasSubmittedApproval
	 * @param pageNum
	 * @param lines
	 * @return
	 */
	List<TSale> selectByHasSubmittedApprovalAndLimit(@Param("hasSubmittedApproval") Short hasSubmittedApproval,
			@Param("pageNum") Integer pageNum, @Param("lines") Integer lines);

	/**
	 * 根据是否已经送审查询
	 * 
	 * @return
	 */
	List<TSale> selectByHasSubmittedApproval(Short hasSubmittedApproval);

	/**
	 * 分页查询基础语句
	 * 
	 * @param pageth 页码
	 * @param rows   每页行数
	 * @return
	 */
	List<TSale> selectLimitByPageRows(@Param("pageth") Integer pageth, @Param("rows") Integer rows);

	/**
	 * 查询数量
	 * 
	 * @param example 条件对象
	 * @return 返回数据的数量
	 */
	long countByExample(TSaleExample example);

	/**
	 * 根据条件删除
	 * 
	 * @param example 条件对象
	 * @return 返回删除成功的数量
	 */
	int deleteByExample(TSaleExample example);

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
	int insert(TSale record);

	/**
	 * 添加对象对应字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insertSelective(TSale record);

	/**
	 * 根据条件查询（二进制大对象）
	 * 
	 * @param example 条件对象
	 * @return 返回查询的结果
	 */
	List<TSale> selectByExample(TSaleExample example);

	/**
	 * 根据ID查询
	 * 
	 * @param id 主键ID
	 * @return 返回查询的结果
	 */
	TSale selectByPrimaryKey(Integer id);

	/**
	 * 根据条件修改对应字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExampleSelective(@Param("record") TSale record, @Param("example") TSaleExample example);

	/**
	 * 根据条件修改所有字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExample(@Param("record") TSale record, @Param("example") TSaleExample example);

	/**
	 * 根据ID修改对应字段
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKeySelective(TSale record);

	/**
	 * 根据ID修改所有字段(必须含ID）
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKey(TSale record);
}