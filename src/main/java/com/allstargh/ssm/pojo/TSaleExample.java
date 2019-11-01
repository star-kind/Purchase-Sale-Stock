/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2019-11-01 23:48:26
 */
public class TSaleExample {
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
    public TSaleExample() {
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
     * 销售记录表t_sale
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

        public Criteria andCommodityIsNull() {
            addCriterion("commodity is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIsNotNull() {
            addCriterion("commodity is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityEqualTo(String value) {
            addCriterion("commodity =", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotEqualTo(String value) {
            addCriterion("commodity <>", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityGreaterThan(String value) {
            addCriterion("commodity >", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityGreaterThanOrEqualTo(String value) {
            addCriterion("commodity >=", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLessThan(String value) {
            addCriterion("commodity <", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLessThanOrEqualTo(String value) {
            addCriterion("commodity <=", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityLike(String value) {
            addCriterion("commodity like", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotLike(String value) {
            addCriterion("commodity not like", value, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityIn(List<String> values) {
            addCriterion("commodity in", values, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotIn(List<String> values) {
            addCriterion("commodity not in", values, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityBetween(String value1, String value2) {
            addCriterion("commodity between", value1, value2, "commodity");
            return (Criteria) this;
        }

        public Criteria andCommodityNotBetween(String value1, String value2) {
            addCriterion("commodity not between", value1, value2, "commodity");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNull() {
            addCriterion("customer is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("customer is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("customer =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("customer <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("customer >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("customer >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("customer <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("customer <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("customer like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("customer not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("customer in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("customer not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("customer between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("customer not between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIsNull() {
            addCriterion("amount_money is null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIsNotNull() {
            addCriterion("amount_money is not null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyEqualTo(Float value) {
            addCriterion("amount_money =", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotEqualTo(Float value) {
            addCriterion("amount_money <>", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyGreaterThan(Float value) {
            addCriterion("amount_money >", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("amount_money >=", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyLessThan(Float value) {
            addCriterion("amount_money <", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyLessThanOrEqualTo(Float value) {
            addCriterion("amount_money <=", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIn(List<Float> values) {
            addCriterion("amount_money in", values, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotIn(List<Float> values) {
            addCriterion("amount_money not in", values, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyBetween(Float value1, Float value2) {
            addCriterion("amount_money between", value1, value2, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotBetween(Float value1, Float value2) {
            addCriterion("amount_money not between", value1, value2, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIsNull() {
            addCriterion("amount_paid is null");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIsNotNull() {
            addCriterion("amount_paid is not null");
            return (Criteria) this;
        }

        public Criteria andAmountPaidEqualTo(BigDecimal value) {
            addCriterion("amount_paid =", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotEqualTo(BigDecimal value) {
            addCriterion("amount_paid <>", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidGreaterThan(BigDecimal value) {
            addCriterion("amount_paid >", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_paid >=", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidLessThan(BigDecimal value) {
            addCriterion("amount_paid <", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_paid <=", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIn(List<BigDecimal> values) {
            addCriterion("amount_paid in", values, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotIn(List<BigDecimal> values) {
            addCriterion("amount_paid not in", values, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_paid between", value1, value2, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_paid not between", value1, value2, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(Integer value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(Integer value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(Integer value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(Integer value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(Integer value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<Integer> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<Integer> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(Integer value1, Integer value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Integer value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Integer value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Integer value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Integer value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Integer value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Integer> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Integer> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Integer value1, Integer value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
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

        public Criteria andRegionDepartmentIsNull() {
            addCriterion("region_department is null");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentIsNotNull() {
            addCriterion("region_department is not null");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentEqualTo(Integer value) {
            addCriterion("region_department =", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentNotEqualTo(Integer value) {
            addCriterion("region_department <>", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentGreaterThan(Integer value) {
            addCriterion("region_department >", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_department >=", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentLessThan(Integer value) {
            addCriterion("region_department <", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("region_department <=", value, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentIn(List<Integer> values) {
            addCriterion("region_department in", values, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentNotIn(List<Integer> values) {
            addCriterion("region_department not in", values, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentBetween(Integer value1, Integer value2) {
            addCriterion("region_department between", value1, value2, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andRegionDepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("region_department not between", value1, value2, "regionDepartment");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNull() {
            addCriterion("sale_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNotNull() {
            addCriterion("sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeEqualTo(Date value) {
            addCriterion("sale_time =", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotEqualTo(Date value) {
            addCriterion("sale_time <>", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThan(Date value) {
            addCriterion("sale_time >", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_time >=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThan(Date value) {
            addCriterion("sale_time <", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_time <=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIn(List<Date> values) {
            addCriterion("sale_time in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotIn(List<Date> values) {
            addCriterion("sale_time not in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeBetween(Date value1, Date value2) {
            addCriterion("sale_time between", value1, value2, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_time not between", value1, value2, "saleTime");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockIsNull() {
            addCriterion("is_enough_stock is null");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockIsNotNull() {
            addCriterion("is_enough_stock is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockEqualTo(Short value) {
            addCriterion("is_enough_stock =", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockNotEqualTo(Short value) {
            addCriterion("is_enough_stock <>", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockGreaterThan(Short value) {
            addCriterion("is_enough_stock >", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockGreaterThanOrEqualTo(Short value) {
            addCriterion("is_enough_stock >=", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockLessThan(Short value) {
            addCriterion("is_enough_stock <", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockLessThanOrEqualTo(Short value) {
            addCriterion("is_enough_stock <=", value, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockIn(List<Short> values) {
            addCriterion("is_enough_stock in", values, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockNotIn(List<Short> values) {
            addCriterion("is_enough_stock not in", values, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockBetween(Short value1, Short value2) {
            addCriterion("is_enough_stock between", value1, value2, "isEnoughStock");
            return (Criteria) this;
        }

        public Criteria andIsEnoughStockNotBetween(Short value1, Short value2) {
            addCriterion("is_enough_stock not between", value1, value2, "isEnoughStock");
            return (Criteria) this;
        }
    }

    /**
     * 销售记录表t_sale的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 销售记录表t_sale的动态SQL对象.
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