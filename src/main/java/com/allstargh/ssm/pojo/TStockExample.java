/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2019-10-08 08:41:26
 */
public class TStockExample {
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
    public TStockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
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
     * 货仓存储表t_stock
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNull() {
            addCriterion("purchase_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNotNull() {
            addCriterion("purchase_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdEqualTo(Integer value) {
            addCriterion("purchase_id =", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotEqualTo(Integer value) {
            addCriterion("purchase_id <>", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThan(Integer value) {
            addCriterion("purchase_id >", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_id >=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThan(Integer value) {
            addCriterion("purchase_id <", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_id <=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIn(List<Integer> values) {
            addCriterion("purchase_id in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotIn(List<Integer> values) {
            addCriterion("purchase_id not in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id not between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityIsNull() {
            addCriterion("store_commodity is null");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityIsNotNull() {
            addCriterion("store_commodity is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityEqualTo(String value) {
            addCriterion("store_commodity =", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityNotEqualTo(String value) {
            addCriterion("store_commodity <>", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityGreaterThan(String value) {
            addCriterion("store_commodity >", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityGreaterThanOrEqualTo(String value) {
            addCriterion("store_commodity >=", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityLessThan(String value) {
            addCriterion("store_commodity <", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityLessThanOrEqualTo(String value) {
            addCriterion("store_commodity <=", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityLike(String value) {
            addCriterion("store_commodity like", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityNotLike(String value) {
            addCriterion("store_commodity not like", value, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityIn(List<String> values) {
            addCriterion("store_commodity in", values, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityNotIn(List<String> values) {
            addCriterion("store_commodity not in", values, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityBetween(String value1, String value2) {
            addCriterion("store_commodity between", value1, value2, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreCommodityNotBetween(String value1, String value2) {
            addCriterion("store_commodity not between", value1, value2, "storeCommodity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityIsNull() {
            addCriterion("store_quantity is null");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityIsNotNull() {
            addCriterion("store_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityEqualTo(Integer value) {
            addCriterion("store_quantity =", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityNotEqualTo(Integer value) {
            addCriterion("store_quantity <>", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityGreaterThan(Integer value) {
            addCriterion("store_quantity >", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_quantity >=", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityLessThan(Integer value) {
            addCriterion("store_quantity <", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("store_quantity <=", value, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityIn(List<Integer> values) {
            addCriterion("store_quantity in", values, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityNotIn(List<Integer> values) {
            addCriterion("store_quantity not in", values, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityBetween(Integer value1, Integer value2) {
            addCriterion("store_quantity between", value1, value2, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andStoreQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("store_quantity not between", value1, value2, "storeQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Long value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Long value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Long value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Long value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Long value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Long> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Long> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Long value1, Long value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Long value1, Long value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaIsNull() {
            addCriterion("stock_type_area is null");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaIsNotNull() {
            addCriterion("stock_type_area is not null");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaEqualTo(Byte value) {
            addCriterion("stock_type_area =", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaNotEqualTo(Byte value) {
            addCriterion("stock_type_area <>", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaGreaterThan(Byte value) {
            addCriterion("stock_type_area >", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaGreaterThanOrEqualTo(Byte value) {
            addCriterion("stock_type_area >=", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaLessThan(Byte value) {
            addCriterion("stock_type_area <", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaLessThanOrEqualTo(Byte value) {
            addCriterion("stock_type_area <=", value, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaIn(List<Byte> values) {
            addCriterion("stock_type_area in", values, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaNotIn(List<Byte> values) {
            addCriterion("stock_type_area not in", values, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaBetween(Byte value1, Byte value2) {
            addCriterion("stock_type_area between", value1, value2, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockTypeAreaNotBetween(Byte value1, Byte value2) {
            addCriterion("stock_type_area not between", value1, value2, "stockTypeArea");
            return (Criteria) this;
        }

        public Criteria andStockOperatorIsNull() {
            addCriterion("stock_operator is null");
            return (Criteria) this;
        }

        public Criteria andStockOperatorIsNotNull() {
            addCriterion("stock_operator is not null");
            return (Criteria) this;
        }

        public Criteria andStockOperatorEqualTo(String value) {
            addCriterion("stock_operator =", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorNotEqualTo(String value) {
            addCriterion("stock_operator <>", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorGreaterThan(String value) {
            addCriterion("stock_operator >", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("stock_operator >=", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorLessThan(String value) {
            addCriterion("stock_operator <", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorLessThanOrEqualTo(String value) {
            addCriterion("stock_operator <=", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorLike(String value) {
            addCriterion("stock_operator like", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorNotLike(String value) {
            addCriterion("stock_operator not like", value, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorIn(List<String> values) {
            addCriterion("stock_operator in", values, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorNotIn(List<String> values) {
            addCriterion("stock_operator not in", values, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorBetween(String value1, String value2) {
            addCriterion("stock_operator between", value1, value2, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andStockOperatorNotBetween(String value1, String value2) {
            addCriterion("stock_operator not between", value1, value2, "stockOperator");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeIsNull() {
            addCriterion("enter_stock_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeIsNotNull() {
            addCriterion("enter_stock_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeEqualTo(Date value) {
            addCriterion("enter_stock_time =", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeNotEqualTo(Date value) {
            addCriterion("enter_stock_time <>", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeGreaterThan(Date value) {
            addCriterion("enter_stock_time >", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enter_stock_time >=", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeLessThan(Date value) {
            addCriterion("enter_stock_time <", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeLessThanOrEqualTo(Date value) {
            addCriterion("enter_stock_time <=", value, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeIn(List<Date> values) {
            addCriterion("enter_stock_time in", values, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeNotIn(List<Date> values) {
            addCriterion("enter_stock_time not in", values, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeBetween(Date value1, Date value2) {
            addCriterion("enter_stock_time between", value1, value2, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andEnterStockTimeNotBetween(Date value1, Date value2) {
            addCriterion("enter_stock_time not between", value1, value2, "enterStockTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockIsNull() {
            addCriterion("agree_enter_stock is null");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockIsNotNull() {
            addCriterion("agree_enter_stock is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockEqualTo(Boolean value) {
            addCriterion("agree_enter_stock =", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockNotEqualTo(Boolean value) {
            addCriterion("agree_enter_stock <>", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockGreaterThan(Boolean value) {
            addCriterion("agree_enter_stock >", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("agree_enter_stock >=", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockLessThan(Boolean value) {
            addCriterion("agree_enter_stock <", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockLessThanOrEqualTo(Boolean value) {
            addCriterion("agree_enter_stock <=", value, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockIn(List<Boolean> values) {
            addCriterion("agree_enter_stock in", values, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockNotIn(List<Boolean> values) {
            addCriterion("agree_enter_stock not in", values, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockBetween(Boolean value1, Boolean value2) {
            addCriterion("agree_enter_stock between", value1, value2, "agreeEnterStock");
            return (Criteria) this;
        }

        public Criteria andAgreeEnterStockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("agree_enter_stock not between", value1, value2, "agreeEnterStock");
            return (Criteria) this;
        }
    }

    /**
     * 货仓存储表t_stock的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 货仓存储表t_stock的动态SQL对象.
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