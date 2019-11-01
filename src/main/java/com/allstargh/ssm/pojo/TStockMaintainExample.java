/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由
 * https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation
 * 自动生成
 * 
 * @author orange1438 code generator date:2019-11-01 23:48:26
 */
public class TStockMaintainExample {
	/**
	 * 排序字段
	 */
	protected String orderByClause;

	/**
	 * 过滤重复数据
	 */
	protected boolean distinct;

	/**
	 * 查询条件
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * 构造查询条件
	 */
	public TStockMaintainExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * 设置排序字段
	 * 
	 * @param orderByClause 排序字段
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 获取排序字段
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * 设置过滤重复数据
	 * 
	 * @param distinct 是否过滤重复数据
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 是否过滤重复数据
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 获取当前的查询条件实例
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * 增加或者的查询条件,用于构建或者查询
	 * 
	 * @param criteria 过滤条件实例
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 创建一个新的或者查询条件
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 创建一个查询条件
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 内部构建查询条件对象
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 清除查询条件
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * 货仓维护记录表t_stock_maintain
	 */
	protected abstract static class BaseCriteria {
		protected List<Criterion> criteria;

		protected BaseCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeIsNull() {
			addCriterion("lastest_modified_time is null");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeIsNotNull() {
			addCriterion("lastest_modified_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeEqualTo(Date value) {
			addCriterion("lastest_modified_time =", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeNotEqualTo(Date value) {
			addCriterion("lastest_modified_time <>", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeGreaterThan(Date value) {
			addCriterion("lastest_modified_time >", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("lastest_modified_time >=", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeLessThan(Date value) {
			addCriterion("lastest_modified_time <", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeLessThanOrEqualTo(Date value) {
			addCriterion("lastest_modified_time <=", value, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeIn(List<Date> values) {
			addCriterion("lastest_modified_time in", values, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeNotIn(List<Date> values) {
			addCriterion("lastest_modified_time not in", values, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeBetween(Date value1, Date value2) {
			addCriterion("lastest_modified_time between", value1, value2, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifiedTimeNotBetween(Date value1, Date value2) {
			addCriterion("lastest_modified_time not between", value1, value2, "lastestModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastestModifierIsNull() {
			addCriterion("lastest_modifier is null");
			return (Criteria) this;
		}

		public Criteria andLastestModifierIsNotNull() {
			addCriterion("lastest_modifier is not null");
			return (Criteria) this;
		}

		public Criteria andLastestModifierEqualTo(Integer value) {
			addCriterion("lastest_modifier =", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierNotEqualTo(Integer value) {
			addCriterion("lastest_modifier <>", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierGreaterThan(Integer value) {
			addCriterion("lastest_modifier >", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierGreaterThanOrEqualTo(Integer value) {
			addCriterion("lastest_modifier >=", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierLessThan(Integer value) {
			addCriterion("lastest_modifier <", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierLessThanOrEqualTo(Integer value) {
			addCriterion("lastest_modifier <=", value, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierIn(List<Integer> values) {
			addCriterion("lastest_modifier in", values, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierNotIn(List<Integer> values) {
			addCriterion("lastest_modifier not in", values, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierBetween(Integer value1, Integer value2) {
			addCriterion("lastest_modifier between", value1, value2, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andLastestModifierNotBetween(Integer value1, Integer value2) {
			addCriterion("lastest_modifier not between", value1, value2, "lastestModifier");
			return (Criteria) this;
		}

		public Criteria andModifyTypeIsNull() {
			addCriterion("modify_type is null");
			return (Criteria) this;
		}

		public Criteria andModifyTypeIsNotNull() {
			addCriterion("modify_type is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTypeEqualTo(Short value) {
			addCriterion("modify_type =", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeNotEqualTo(Short value) {
			addCriterion("modify_type <>", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeGreaterThan(Short value) {
			addCriterion("modify_type >", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeGreaterThanOrEqualTo(Short value) {
			addCriterion("modify_type >=", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeLessThan(Short value) {
			addCriterion("modify_type <", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeLessThanOrEqualTo(Short value) {
			addCriterion("modify_type <=", value, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeIn(List<Short> values) {
			addCriterion("modify_type in", values, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeNotIn(List<Short> values) {
			addCriterion("modify_type not in", values, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeBetween(Short value1, Short value2) {
			addCriterion("modify_type between", value1, value2, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyTypeNotBetween(Short value1, Short value2) {
			addCriterion("modify_type not between", value1, value2, "modifyType");
			return (Criteria) this;
		}

		public Criteria andModifyInfoIsNull() {
			addCriterion("modify_info is null");
			return (Criteria) this;
		}

		public Criteria andModifyInfoIsNotNull() {
			addCriterion("modify_info is not null");
			return (Criteria) this;
		}

		public Criteria andModifyInfoEqualTo(String value) {
			addCriterion("modify_info =", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoNotEqualTo(String value) {
			addCriterion("modify_info <>", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoGreaterThan(String value) {
			addCriterion("modify_info >", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoGreaterThanOrEqualTo(String value) {
			addCriterion("modify_info >=", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoLessThan(String value) {
			addCriterion("modify_info <", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoLessThanOrEqualTo(String value) {
			addCriterion("modify_info <=", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoLike(String value) {
			addCriterion("modify_info like", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoNotLike(String value) {
			addCriterion("modify_info not like", value, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoIn(List<String> values) {
			addCriterion("modify_info in", values, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoNotIn(List<String> values) {
			addCriterion("modify_info not in", values, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoBetween(String value1, String value2) {
			addCriterion("modify_info between", value1, value2, "modifyInfo");
			return (Criteria) this;
		}

		public Criteria andModifyInfoNotBetween(String value1, String value2) {
			addCriterion("modify_info not between", value1, value2, "modifyInfo");
			return (Criteria) this;
		}
	}

	/**
	 * 货仓维护记录表t_stock_maintain的映射实体
	 */
	public static class Criteria extends BaseCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * 货仓维护记录表t_stock_maintain的动态SQL对象.
	 */
	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}