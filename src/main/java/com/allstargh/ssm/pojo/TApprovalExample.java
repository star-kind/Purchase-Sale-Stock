/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2019-10-27 18:56:36
 */
public class TApprovalExample {
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
    public TApprovalExample() {
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
     * 申请单审核处理表t_approval
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

        public Criteria andDepartmentNumberIsNull() {
            addCriterion("department_number is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberIsNotNull() {
            addCriterion("department_number is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberEqualTo(Byte value) {
            addCriterion("department_number =", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotEqualTo(Byte value) {
            addCriterion("department_number <>", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberGreaterThan(Byte value) {
            addCriterion("department_number >", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("department_number >=", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberLessThan(Byte value) {
            addCriterion("department_number <", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberLessThanOrEqualTo(Byte value) {
            addCriterion("department_number <=", value, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberIn(List<Byte> values) {
            addCriterion("department_number in", values, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotIn(List<Byte> values) {
            addCriterion("department_number not in", values, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberBetween(Byte value1, Byte value2) {
            addCriterion("department_number between", value1, value2, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("department_number not between", value1, value2, "departmentNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeIsNull() {
            addCriterion("approvals_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeIsNotNull() {
            addCriterion("approvals_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeEqualTo(Date value) {
            addCriterion("approvals_time =", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeNotEqualTo(Date value) {
            addCriterion("approvals_time <>", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeGreaterThan(Date value) {
            addCriterion("approvals_time >", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approvals_time >=", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeLessThan(Date value) {
            addCriterion("approvals_time <", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeLessThanOrEqualTo(Date value) {
            addCriterion("approvals_time <=", value, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeIn(List<Date> values) {
            addCriterion("approvals_time in", values, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeNotIn(List<Date> values) {
            addCriterion("approvals_time not in", values, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeBetween(Date value1, Date value2) {
            addCriterion("approvals_time between", value1, value2, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andApprovalsTimeNotBetween(Date value1, Date value2) {
            addCriterion("approvals_time not between", value1, value2, "approvalsTime");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionIsNull() {
            addCriterion("reply_opinion is null");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionIsNotNull() {
            addCriterion("reply_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionEqualTo(String value) {
            addCriterion("reply_opinion =", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionNotEqualTo(String value) {
            addCriterion("reply_opinion <>", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionGreaterThan(String value) {
            addCriterion("reply_opinion >", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("reply_opinion >=", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionLessThan(String value) {
            addCriterion("reply_opinion <", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionLessThanOrEqualTo(String value) {
            addCriterion("reply_opinion <=", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionLike(String value) {
            addCriterion("reply_opinion like", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionNotLike(String value) {
            addCriterion("reply_opinion not like", value, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionIn(List<String> values) {
            addCriterion("reply_opinion in", values, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionNotIn(List<String> values) {
            addCriterion("reply_opinion not in", values, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionBetween(String value1, String value2) {
            addCriterion("reply_opinion between", value1, value2, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andReplyOpinionNotBetween(String value1, String value2) {
            addCriterion("reply_opinion not between", value1, value2, "replyOpinion");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderIsNull() {
            addCriterion("original_order is null");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderIsNotNull() {
            addCriterion("original_order is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderEqualTo(Integer value) {
            addCriterion("original_order =", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderNotEqualTo(Integer value) {
            addCriterion("original_order <>", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderGreaterThan(Integer value) {
            addCriterion("original_order >", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("original_order >=", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderLessThan(Integer value) {
            addCriterion("original_order <", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderLessThanOrEqualTo(Integer value) {
            addCriterion("original_order <=", value, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderIn(List<Integer> values) {
            addCriterion("original_order in", values, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderNotIn(List<Integer> values) {
            addCriterion("original_order not in", values, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderBetween(Integer value1, Integer value2) {
            addCriterion("original_order between", value1, value2, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andOriginalOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("original_order not between", value1, value2, "originalOrder");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(Integer value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(Integer value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(Integer value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(Integer value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(Integer value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<Integer> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<Integer> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(Integer value1, Integer value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(Integer value1, Integer value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesIsNull() {
            addCriterion("approve_operates is null");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesIsNotNull() {
            addCriterion("approve_operates is not null");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesEqualTo(Boolean value) {
            addCriterion("approve_operates =", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesNotEqualTo(Boolean value) {
            addCriterion("approve_operates <>", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesGreaterThan(Boolean value) {
            addCriterion("approve_operates >", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("approve_operates >=", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesLessThan(Boolean value) {
            addCriterion("approve_operates <", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesLessThanOrEqualTo(Boolean value) {
            addCriterion("approve_operates <=", value, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesIn(List<Boolean> values) {
            addCriterion("approve_operates in", values, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesNotIn(List<Boolean> values) {
            addCriterion("approve_operates not in", values, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_operates between", value1, value2, "approveOperates");
            return (Criteria) this;
        }

        public Criteria andApproveOperatesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_operates not between", value1, value2, "approveOperates");
            return (Criteria) this;
        }
    }

    /**
     * 申请单审核处理表t_approval的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 申请单审核处理表t_approval的动态SQL对象.
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

	@Override
	public String toString() {
		return "TApprovalExample [orderByClause=" + orderByClause + ", distinct=" + distinct + ", oredCriteria="
				+ oredCriteria + "]";
	}
    
}