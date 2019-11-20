package com.allstargh.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.allstargh.ssm.pojo.AssociativeEntity;
import com.allstargh.ssm.pojo.JointStockVO;

/**
 * 混合联动
 * 
 * @author admin
 *
 */
public interface AssociativeMapper {
	/**
	 * 
	 * @param sid
	 * @return
	 */
	abstract List<JointStockVO> queryByStID(@Param("sid") Integer sid);

	/**
	 * 多表联合查询,总
	 * 
	 * @param deptNum
	 * @param operate
	 * @return
	 */
	abstract List<AssociativeEntity> multiTableJointQuery(@Param("deptNum") Integer deptNum,
			@Param("operate") Integer operate);

	/**
	 * 多表联合查询,分页
	 * 
	 * @param deptNum
	 * @param operate
	 * @param pageth
	 * @param lines
	 * @return
	 */
	abstract List<AssociativeEntity> multiTableJointQueryLimit(@Param("deptNum") Integer deptNum,
			@Param("operate") Integer operate, @Param("pageth") Integer pageth, @Param("lines") Integer lines);
}
