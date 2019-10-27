/* https://github.com/orange1438 */
package com.allstargh.ssm.mapper;

import com.allstargh.ssm.pojo.TStock;
import com.allstargh.ssm.pojo.TStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由
 * https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation
 * 自动生成
 * 
 * @author orange1438 code generator date:2019-10-08 08:41:26
 */
public interface TStockDAO {
	/**
	 * 据储藏区查找
	 * 
	 * @param stockTypeArea
	 * @return
	 */
	abstract List<TStock> selectByPurchaseStockTypeArea(Byte stockTypeArea);

	/**
	 * 更新储藏物品资料
	 * 
	 * @param tStock
	 * @return
	 */
	Integer updateStoreGoodByPurchase(TStock tStock);

	/**
	 * 
	 * @param purchaseId
	 * @return
	 */
	abstract TStock selectByPurchaseId(Integer purchaseId);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<TStock> selectAllRows();

	/**
	 * 查询数量
	 * 
	 * @param example 条件对象
	 * @return 返回数据的数量
	 */
	long countByExample(TStockExample example);

	/**
	 * 根据条件删除
	 * 
	 * @param example 条件对象
	 * @return 返回删除成功的数量
	 */
	int deleteByExample(TStockExample example);

	/**
	 * 根据ID删除
	 * 
	 * @param id 主键ID
	 * @return 返回删除成功的数量
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 添加对象所有字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insert(TStock record);

	/**
	 * 添加对象对应字段
	 * 
	 * @param record 插入字段对象(必须含ID）
	 * @return 返回添加成功的数量
	 */
	int insertSelective(TStock record);

	/**
	 * 根据条件查询（二进制大对象）
	 * 
	 * @param example 条件对象
	 * @return 返回查询的结果
	 */
	List<TStock> selectByExample(TStockExample example);

	/**
	 * 根据ID查询
	 * 
	 * @param id 主键ID
	 * @return 返回查询的结果
	 */
	TStock selectByPrimaryKey(Long id);

	/**
	 * 根据条件修改对应字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExampleSelective(@Param("record") TStock record, @Param("example") TStockExample example);

	/**
	 * 根据条件修改所有字段
	 * 
	 * @param record  修改字段对象 (JOPO)
	 * @param example 条件对象
	 * @return 返回更新成功的数量
	 */
	int updateByExample(@Param("record") TStock record, @Param("example") TStockExample example);

	/**
	 * 根据ID修改对应字段
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKeySelective(TStock record);

	/**
	 * 根据ID修改所有字段(必须含ID）
	 * 
	 * @param record 修改字段对象(必须含ID）
	 * @return 返回更新成功的数量
	 */
	int updateByPrimaryKey(TStock record);
}