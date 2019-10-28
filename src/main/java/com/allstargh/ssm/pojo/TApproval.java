/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TApproval {
	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部
	 */
	private Byte departmentNumber;

	/**
	 * 审核处理时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date approvalsTime;

	/**
	 * 批复意见
	 */
	private String replyOpinion;

	/**
	 * 申单原序号
	 */
	private Integer originalOrder;

	/**
	 * 审核者,对应账号表usrid
	 */
	private Integer auditor;

	/**
	 * 审批操作:0.已同意;1.不同意
	 */
	private Boolean approveOperates;

	/**
	 * 获取 主键ID t_approval.id
	 * 
	 * @return 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 主键ID t_approval.id
	 * 
	 * @param id 主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部 t_approval.department_number
	 * 
	 * @return 来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部
	 */
	public Byte getDepartmentNumber() {
		return departmentNumber;
	}

	/**
	 * 设置 来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部 t_approval.department_number
	 * 
	 * @param departmentNumber 来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部
	 */
	public void setDepartmentNumber(Byte departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	/**
	 * 获取 审核处理时间 t_approval.approvals_time
	 * 
	 * @return 审核处理时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getApprovalsTime() {
		return approvalsTime;
	}

	/**
	 * 设置 审核处理时间 t_approval.approvals_time
	 * 
	 * @param approvalsTime 审核处理时间
	 */
	public void setApprovalsTime(Date approvalsTime) {
		this.approvalsTime = approvalsTime;
	}

	/**
	 * 获取 批复意见 t_approval.reply_opinion
	 * 
	 * @return 批复意见
	 */
	public String getReplyOpinion() {
		return replyOpinion;
	}

	/**
	 * 设置 批复意见 t_approval.reply_opinion
	 * 
	 * @param replyOpinion 批复意见
	 */
	public void setReplyOpinion(String replyOpinion) {
		this.replyOpinion = replyOpinion == null ? null : replyOpinion.trim();
	}

	/**
	 * 获取 申单原序号 t_approval.original_order
	 * 
	 * @return 申单原序号
	 */
	public Integer getOriginalOrder() {
		return originalOrder;
	}

	/**
	 * 设置 申单原序号 t_approval.original_order
	 * 
	 * @param originalOrder 申单原序号
	 */
	public void setOriginalOrder(Integer originalOrder) {
		this.originalOrder = originalOrder;
	}

	/**
	 * 获取 审核者,对应账号表usrid t_approval.auditor
	 * 
	 * @return 审核者,对应账号表usrid
	 */
	public Integer getAuditor() {
		return auditor;
	}

	/**
	 * 设置 审核者,对应账号表usrid t_approval.auditor
	 * 
	 * @param auditor 审核者,对应账号表usrid
	 */
	public void setAuditor(Integer auditor) {
		this.auditor = auditor;
	}

	/**
	 * 获取 审批操作:0.已同意;1.不同意 t_approval.approve_operates
	 * 
	 * @return 审批操作:0.已同意;1.不同意
	 */
	public Boolean getApproveOperates() {
		return approveOperates;
	}

	/**
	 * 设置 审批操作:0.已同意;1.不同意 t_approval.approve_operates
	 * 
	 * @param approveOperates 审批操作:0.已同意;1.不同意
	 */
	public void setApproveOperates(Boolean approveOperates) {
		this.approveOperates = approveOperates;
	}

	@Override
	public String toString() {
		return "TApproval [id=" + id + ", departmentNumber=" + departmentNumber + ", approvalsTime=" + approvalsTime
				+ ", replyOpinion=" + replyOpinion + ", originalOrder=" + originalOrder + ", auditor=" + auditor
				+ ", approveOperates=" + approveOperates + "]";
	}

}