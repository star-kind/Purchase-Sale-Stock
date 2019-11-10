/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TSale {
	/**
	 * 是否已送审:0未送,1已送'
	 */
	private Short hasSubmittedApproval;

	/**
	 * 剩余需求量
	 */
	private Integer surplusDemand;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 售出货物之名
	 */
	private String commodity;

	/**
	 * 客户名
	 */
	private String customer;

	/**
	 * 耗资金额
	 */
	private Float amountMoney;

	/**
	 * 已付款金额
	 */
	private BigDecimal amountPaid;

	/**
	 * 支付方式:0-现金,1-网银,2-信用卡,3-其它
	 */
	private Integer paymentMethod;

	/**
	 * 客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完)
	 */
	private Integer isPay;

	/**
	 * 客户货物之数量
	 */
	private Integer quantity;

	/**
	 * 销售经办人(普通雇员或销售经理),对应账号表usrid
	 */
	private Integer saleOperator;

	/**
	 * 部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 * 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	private Integer regionDepartment;

	/**
	 * 销售时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date saleTime;

	/**
	 * 是否有足够存货(-无,1-少量,2-半数左右,3-勉强供应,4-完全满足)
	 */
	private Short isEnoughStock;

	/**
	 * 获取 主键 t_sale.id
	 * 
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 主键 t_sale.id
	 * 
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 售出货物之名 t_sale.commodity
	 * 
	 * @return 售出货物之名
	 */
	public String getCommodity() {
		return commodity;
	}

	/**
	 * 设置 售出货物之名 t_sale.commodity
	 * 
	 * @param commodity 售出货物之名
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity == null ? null : commodity.trim();
	}

	/**
	 * 获取 客户名 t_sale.customer
	 * 
	 * @return 客户名
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * 设置 客户名 t_sale.customer
	 * 
	 * @param customer 客户名
	 */
	public void setCustomer(String customer) {
		this.customer = customer == null ? null : customer.trim();
	}

	/**
	 * 获取 耗资金额 t_sale.amount_money
	 * 
	 * @return 耗资金额
	 */
	public Float getAmountMoney() {
		return amountMoney;
	}

	/**
	 * 设置 耗资金额 t_sale.amount_money
	 * 
	 * @param amountMoney 耗资金额
	 */
	public void setAmountMoney(Float amountMoney) {
		this.amountMoney = amountMoney;
	}

	/**
	 * 获取 已付款金额 t_sale.amount_paid
	 * 
	 * @return 已付款金额
	 */
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	/**
	 * 设置 已付款金额 t_sale.amount_paid
	 * 
	 * @param amountPaid 已付款金额
	 */
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * 获取 支付方式:0-现金,1-网银,2-信用卡,3-其它 t_sale.payment_method
	 * 
	 * @return 支付方式:0-现金,1-网银,2-信用卡,3-其它
	 */
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * 设置 支付方式:0-现金,1-网银,2-信用卡,3-其它 t_sale.payment_method
	 * 
	 * @param paymentMethod 支付方式:0-现金,1-网银,2-信用卡,3-其它
	 */
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * 获取 客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完) t_sale.is_pay
	 * 
	 * @return 客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完)
	 */
	public Integer getIsPay() {
		return isPay;
	}

	/**
	 * 设置 客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完) t_sale.is_pay
	 * 
	 * @param isPay 客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完)
	 */
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	/**
	 * 获取 客户货物之数量 t_sale.quantity
	 * 
	 * @return 客户货物之数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置 客户货物之数量 t_sale.quantity
	 * 
	 * @param quantity 客户货物之数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取 销售经办人(普通雇员或销售经理),对应账号表usrid t_sale.sale_operator
	 * 
	 * @return 销售经办人(普通雇员或销售经理),对应账号表usrid
	 */
	public Integer getSaleOperator() {
		return saleOperator;
	}

	/**
	 * 设置 销售经办人(普通雇员或销售经理),对应账号表usrid t_sale.sale_operator
	 * 
	 * @param saleOperator 销售经办人(普通雇员或销售经理),对应账号表usrid
	 */
	public void setSaleOperator(Integer saleOperator) {
		this.saleOperator = saleOperator;
	}

	/**
	 * 获取 部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 * 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店 t_sale.region_department
	 * 
	 * @return 部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 *         鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	public Integer getRegionDepartment() {
		return regionDepartment;
	}

	/**
	 * 设置 部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 * 鸦岭,9-酒后,10-平等,11-夏堡,12-富留店 t_sale.region_department
	 * 
	 * @param regionDepartment 部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
	 *                         鸦岭,9-酒后,10-平等,11-夏堡,12-富留店
	 */
	public void setRegionDepartment(Integer regionDepartment) {
		this.regionDepartment = regionDepartment;
	}

	/**
	 * 获取 销售时间 t_sale.sale_time
	 * 
	 * @return 销售时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getSaleTime() {
		return saleTime;
	}

	/**
	 * 设置 销售时间 t_sale.sale_time
	 * 
	 * @param saleTime 销售时间
	 */
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	/**
	 * 获取 是否有足够存货(-无,1-少量,2-半数左右,3-勉强供应,4-完全满足) t_sale.is_enough_stock
	 * 
	 * @return 是否有足够存货(-无,1-少量,2-半数左右,3-勉强供应,4-完全满足)
	 */
	public Short getIsEnoughStock() {
		return isEnoughStock;
	}

	/**
	 * 设置 是否有足够存货(-无,1-少量,2-半数左右,3-勉强供应,4-完全满足) t_sale.is_enough_stock
	 * 
	 * @param isEnoughStock 是否有足够存货(-无,1-少量,2-半数左右,3-勉强供应,4-完全满足)
	 */
	public void setIsEnoughStock(Short isEnoughStock) {
		this.isEnoughStock = isEnoughStock;
	}

	public Short getHasSubmittedApproval() {
		return hasSubmittedApproval;
	}

	public void setHasSubmittedApproval(Short hasSubmittedApproval) {
		this.hasSubmittedApproval = hasSubmittedApproval;
	}

	public Integer getSurplusDemand() {
		return surplusDemand;
	}

	public void setSurplusDemand(Integer surplusDemand) {
		this.surplusDemand = surplusDemand;
	}

	@Override
	public String toString() {
		return "TSale [hasSubmittedApproval=" + hasSubmittedApproval + ", surplusDemand=" + surplusDemand + ", id=" + id
				+ ", commodity=" + commodity + ", customer=" + customer + ", amountMoney=" + amountMoney
				+ ", amountPaid=" + amountPaid + ", paymentMethod=" + paymentMethod + ", isPay=" + isPay + ", quantity="
				+ quantity + ", saleOperator=" + saleOperator + ", regionDepartment=" + regionDepartment + ", saleTime="
				+ saleTime + ", isEnoughStock=" + isEnoughStock + "]";
	}

}