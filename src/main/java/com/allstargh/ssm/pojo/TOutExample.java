/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2019-11-14 18:08:07
 */
public class TOutExample {
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
    public TOutExample() {
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
     * 出库记录表t_out
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

        public Criteria andStoreOrderIsNull() {
            addCriterion("store_order is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIsNotNull() {
            addCriterion("store_order is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderEqualTo(Long value) {
            addCriterion("store_order =", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotEqualTo(Long value) {
            addCriterion("store_order <>", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderGreaterThan(Long value) {
            addCriterion("store_order >", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("store_order >=", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderLessThan(Long value) {
            addCriterion("store_order <", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderLessThanOrEqualTo(Long value) {
            addCriterion("store_order <=", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIn(List<Long> values) {
            addCriterion("store_order in", values, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotIn(List<Long> values) {
            addCriterion("store_order not in", values, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderBetween(Long value1, Long value2) {
            addCriterion("store_order between", value1, value2, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotBetween(Long value1, Long value2) {
            addCriterion("store_order not between", value1, value2, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIsNull() {
            addCriterion("store_area is null");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIsNotNull() {
            addCriterion("store_area is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAreaEqualTo(Byte value) {
            addCriterion("store_area =", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotEqualTo(Byte value) {
            addCriterion("store_area <>", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaGreaterThan(Byte value) {
            addCriterion("store_area >", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaGreaterThanOrEqualTo(Byte value) {
            addCriterion("store_area >=", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaLessThan(Byte value) {
            addCriterion("store_area <", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaLessThanOrEqualTo(Byte value) {
            addCriterion("store_area <=", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIn(List<Byte> values) {
            addCriterion("store_area in", values, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotIn(List<Byte> values) {
            addCriterion("store_area not in", values, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaBetween(Byte value1, Byte value2) {
            addCriterion("store_area between", value1, value2, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotBetween(Byte value1, Byte value2) {
            addCriterion("store_area not between", value1, value2, "storeArea");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(Integer value) {
            addCriterion("classify =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(Integer value) {
            addCriterion("classify <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(Integer value) {
            addCriterion("classify >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("classify >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(Integer value) {
            addCriterion("classify <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(Integer value) {
            addCriterion("classify <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<Integer> values) {
            addCriterion("classify in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<Integer> values) {
            addCriterion("classify not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(Integer value1, Integer value2) {
            addCriterion("classify between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(Integer value1, Integer value2) {
            addCriterion("classify not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeIsNull() {
            addCriterion("approver_is_agree is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeIsNotNull() {
            addCriterion("approver_is_agree is not null");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeEqualTo(Boolean value) {
            addCriterion("approver_is_agree =", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeNotEqualTo(Boolean value) {
            addCriterion("approver_is_agree <>", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeGreaterThan(Boolean value) {
            addCriterion("approver_is_agree >", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("approver_is_agree >=", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeLessThan(Boolean value) {
            addCriterion("approver_is_agree <", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeLessThanOrEqualTo(Boolean value) {
            addCriterion("approver_is_agree <=", value, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeIn(List<Boolean> values) {
            addCriterion("approver_is_agree in", values, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeNotIn(List<Boolean> values) {
            addCriterion("approver_is_agree not in", values, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeBetween(Boolean value1, Boolean value2) {
            addCriterion("approver_is_agree between", value1, value2, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andApproverIsAgreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("approver_is_agree not between", value1, value2, "approverIsAgree");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(Integer value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(Integer value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(Integer value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(Integer value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(Integer value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(Integer value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<Integer> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<Integer> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(Integer value1, Integer value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(Integer value1, Integer value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIsNull() {
            addCriterion("sale_order is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIsNotNull() {
            addCriterion("sale_order is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderEqualTo(Integer value) {
            addCriterion("sale_order =", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNotEqualTo(Integer value) {
            addCriterion("sale_order <>", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderGreaterThan(Integer value) {
            addCriterion("sale_order >", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_order >=", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLessThan(Integer value) {
            addCriterion("sale_order <", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sale_order <=", value, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIn(List<Integer> values) {
            addCriterion("sale_order in", values, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNotIn(List<Integer> values) {
            addCriterion("sale_order not in", values, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderBetween(Integer value1, Integer value2) {
            addCriterion("sale_order between", value1, value2, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andSaleOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_order not between", value1, value2, "saleOrder");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeIsNull() {
            addCriterion("stocker_is_agree is null");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeIsNotNull() {
            addCriterion("stocker_is_agree is not null");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeEqualTo(Boolean value) {
            addCriterion("stocker_is_agree =", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeNotEqualTo(Boolean value) {
            addCriterion("stocker_is_agree <>", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeGreaterThan(Boolean value) {
            addCriterion("stocker_is_agree >", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("stocker_is_agree >=", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeLessThan(Boolean value) {
            addCriterion("stocker_is_agree <", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeLessThanOrEqualTo(Boolean value) {
            addCriterion("stocker_is_agree <=", value, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeIn(List<Boolean> values) {
            addCriterion("stocker_is_agree in", values, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeNotIn(List<Boolean> values) {
            addCriterion("stocker_is_agree not in", values, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeBetween(Boolean value1, Boolean value2) {
            addCriterion("stocker_is_agree between", value1, value2, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andStockerIsAgreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("stocker_is_agree not between", value1, value2, "stockerIsAgree");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorIsNull() {
            addCriterion("sale_operator is null");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorIsNotNull() {
            addCriterion("sale_operator is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorEqualTo(Integer value) {
            addCriterion("sale_operator =", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorNotEqualTo(Integer value) {
            addCriterion("sale_operator <>", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorGreaterThan(Integer value) {
            addCriterion("sale_operator >", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_operator >=", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorLessThan(Integer value) {
            addCriterion("sale_operator <", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("sale_operator <=", value, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorIn(List<Integer> values) {
            addCriterion("sale_operator in", values, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorNotIn(List<Integer> values) {
            addCriterion("sale_operator not in", values, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorBetween(Integer value1, Integer value2) {
            addCriterion("sale_operator between", value1, value2, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andSaleOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_operator not between", value1, value2, "saleOperator");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(Integer value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(Integer value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(Integer value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(Integer value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(Integer value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(Integer value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<Integer> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<Integer> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(Integer value1, Integer value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(Integer value1, Integer value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    /**
     * 出库记录表t_out的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 出库记录表t_out的动态SQL对象.
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