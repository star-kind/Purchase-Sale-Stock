/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TOut {
	/**
	 * 是否经过审批部处理,false-未经过,true-已经过
	 */
	private Boolean hasApprovalHandle;

	/**
	 * 是否经过仓管处理,false-未经过,true-已经过
	 */
	private Boolean hasStockHandle;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 货物物品之名
	 */
	private String storeCommodity;

	/**
	 * 货品仓储主键
	 */
	private Long storeOrder;

	/**
	 * 货物之数量
	 */
	private Integer quantity;

	/**
	 * 原存储区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区
	 */
	private Byte storeArea;

	/**
	 * 货品类型:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品
	 */
	private Integer classify;

	/**
	 * 审批部门人员是否同意,false-不准,true-准许
	 */
	private Boolean approverIsAgree;

	/**
	 * 目的地:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8- 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	private Integer destination;

	/**
	 * 对应销售记录主键
	 */
	private Integer saleOrder;

	/**
	 * 仓管是否同意出库,false-不准,true-准许
	 */
	private Boolean stockerIsAgree;

	/**
	 * 出库时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date outTime;

	/**
	 * 出库经办人,对应账号表usrid
	 */
	private Integer saleOperator;

	/**
	 * 提货申请者,对应账号表usrid
	 */
	private Integer applicant;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 获取 主键 t_out.id
	 * 
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 主键 t_out.id
	 * 
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 货物物品之名 t_out.store_commodity
	 * 
	 * @return 货物物品之名
	 */
	public String getStoreCommodity() {
		return storeCommodity;
	}

	/**
	 * 设置 货物物品之名 t_out.store_commodity
	 * 
	 * @param storeCommodity 货物物品之名
	 */
	public void setStoreCommodity(String storeCommodity) {
		this.storeCommodity = storeCommodity == null ? null : storeCommodity.trim();
	}

	/**
	 * 获取 货品仓储主键 t_out.store_order
	 * 
	 * @return 货品仓储主键
	 */
	public Long getStoreOrder() {
		return storeOrder;
	}

	/**
	 * 设置 货品仓储主键 t_out.store_order
	 * 
	 * @param storeOrder 货品仓储主键
	 */
	public void setStoreOrder(Long storeOrder) {
		this.storeOrder = storeOrder;
	}

	/**
	 * 获取 货物之数量 t_out.quantity
	 * 
	 * @return 货物之数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置 货物之数量 t_out.quantity
	 * 
	 * @param quantity 货物之数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取 原存储区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区
	 * t_out.store_area
	 * 
	 * @return 原存储区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区
	 */
	public Byte getStoreArea() {
		return storeArea;
	}

	/**
	 * 设置 原存储区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区
	 * t_out.store_area
	 * 
	 * @param storeArea 原存储区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区
	 */
	public void setStoreArea(Byte storeArea) {
		this.storeArea = storeArea;
	}

	/**
	 * 获取 货品类型:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品 t_out.classify
	 * 
	 * @return 货品类型:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品
	 */
	public Integer getClassify() {
		return classify;
	}

	/**
	 * 设置 货品类型:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品 t_out.classify
	 * 
	 * @param classify 货品类型:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品
	 */
	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	/**
	 * 获取 审批部门人员是否同意,false-不准,true-准许 t_out.approver_is_agree
	 * 
	 * @return 审批部门人员是否同意,false-不准,true-准许
	 */
	public Boolean getApproverIsAgree() {
		return approverIsAgree;
	}

	/**
	 * 设置 审批部门人员是否同意,false-不准,true-准许 t_out.approver_is_agree
	 * 
	 * @param approverIsAgree 审批部门人员是否同意,false-不准,true-准许
	 */
	public void setApproverIsAgree(Boolean approverIsAgree) {
		this.approverIsAgree = approverIsAgree;
	}

	/**
	 * 获取 目的地:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 * 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店 t_out.destination
	 * 
	 * @return 目的地:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 *         鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	public Integer getDestination() {
		return destination;
	}

	/**
	 * 设置 目的地:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 * 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店 t_out.destination
	 * 
	 * @param destination 目的地:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 *                    鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	public void setDestination(Integer destination) {
		this.destination = destination;
	}

	/**
	 * 获取 对应销售记录主键 t_out.sale_order
	 * 
	 * @return 对应销售记录主键
	 */
	public Integer getSaleOrder() {
		return saleOrder;
	}

	/**
	 * 设置 对应销售记录主键 t_out.sale_order
	 * 
	 * @param saleOrder 对应销售记录主键
	 */
	public void setSaleOrder(Integer saleOrder) {
		this.saleOrder = saleOrder;
	}

	/**
	 * 获取 仓管是否同意出库,false-不准,true-准许 t_out.stocker_is_agree
	 * 
	 * @return 仓管是否同意出库,false-不准,true-准许
	 */
	public Boolean getStockerIsAgree() {
		return stockerIsAgree;
	}

	/**
	 * 设置 仓管是否同意出库,false-不准,true-准许 t_out.stocker_is_agree
	 * 
	 * @param stockerIsAgree 仓管是否同意出库,false-不准,true-准许
	 */
	public void setStockerIsAgree(Boolean stockerIsAgree) {
		this.stockerIsAgree = stockerIsAgree;
	}

	/**
	 * 获取 出库时间 t_out.out_time
	 * 
	 * @return 出库时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getOutTime() {
		return outTime;
	}

	/**
	 * 设置 出库时间 t_out.out_time
	 * 
	 * @param outTime 出库时间
	 */
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	/**
	 * 获取 出库经办人,对应账号表usrid t_out.sale_operator
	 * 
	 * @return 出库经办人,对应账号表usrid
	 */
	public Integer getSaleOperator() {
		return saleOperator;
	}

	/**
	 * 设置 出库经办人,对应账号表usrid t_out.sale_operator
	 * 
	 * @param saleOperator 出库经办人,对应账号表usrid
	 */
	public void setSaleOperator(Integer saleOperator) {
		this.saleOperator = saleOperator;
	}

	/**
	 * 获取 提货申请者,对应账号表usrid t_out.applicant
	 * 
	 * @return 提货申请者,对应账号表usrid
	 */
	public Integer getApplicant() {
		return applicant;
	}

	/**
	 * 设置 提货申请者,对应账号表usrid t_out.applicant
	 * 
	 * @param applicant 提货申请者,对应账号表usrid
	 */
	public void setApplicant(Integer applicant) {
		this.applicant = applicant;
	}

	/**
	 * 获取 备注 t_out.remarks
	 * 
	 * @return 备注
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置 备注 t_out.remarks
	 * 
	 * @param remarks 备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Boolean getHasApprovalHandle() {
		return hasApprovalHandle;
	}

	public void setHasApprovalHandle(Boolean hasApprovalHandle) {
		this.hasApprovalHandle = hasApprovalHandle;
	}

	public Boolean getHasStockHandle() {
		return hasStockHandle;
	}

	public void setHasStockHandle(Boolean hasStockHandle) {
		this.hasStockHandle = hasStockHandle;
	}

	@Override
	public String toString() {
		return "TOut [hasApprovalHandle=" + hasApprovalHandle + ", hasStockHandle=" + hasStockHandle + ", id=" + id
				+ ", storeCommodity=" + storeCommodity + ", storeOrder=" + storeOrder + ", quantity=" + quantity
				+ ", storeArea=" + storeArea + ", classify=" + classify + ", approverIsAgree=" + approverIsAgree
				+ ", destination=" + destination + ", saleOrder=" + saleOrder + ", stockerIsAgree=" + stockerIsAgree
				+ ", outTime=" + outTime + ", saleOperator=" + saleOperator + ", applicant=" + applicant + ", remarks="
				+ remarks + "]";
	}

}