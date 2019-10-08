/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.Date;

public class TStock {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 采购申请单ID
	 */
	private Integer purchaseId;

	/**
	 * 存储货物之名
	 */
	private String storeCommodity;

	/**
	 * 存储数量
	 */
	private Integer storeQuantity;

	/**
	 * 单价
	 */
	private Long unitPrice;

	/**
	 * 存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区
	 */
	private Byte stockTypeArea;

	/**
	 * 入库经办仓管
	 */
	private String stockOperator;

	/**
	 * 入库时间
	 */
	private Date enterStockTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 同意入库与否:0-否,1-可
	 */
	private Boolean agreeEnterStock;

	/**
	 * 获取 主键 t_stock.id
	 * 
	 * @return 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键 t_stock.id
	 * 
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 采购申请单ID t_stock.purchase_id
	 * 
	 * @return 采购申请单ID
	 */
	public Integer getPurchaseId() {
		return purchaseId;
	}

	/**
	 * 设置 采购申请单ID t_stock.purchase_id
	 * 
	 * @param purchaseId 采购申请单ID
	 */
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * 获取 存储货物之名 t_stock.store_commodity
	 * 
	 * @return 存储货物之名
	 */
	public String getStoreCommodity() {
		return storeCommodity;
	}

	/**
	 * 设置 存储货物之名 t_stock.store_commodity
	 * 
	 * @param storeCommodity 存储货物之名
	 */
	public void setStoreCommodity(String storeCommodity) {
		this.storeCommodity = storeCommodity == null ? null : storeCommodity.trim();
	}

	/**
	 * 获取 存储数量 t_stock.store_quantity
	 * 
	 * @return 存储数量
	 */
	public Integer getStoreQuantity() {
		return storeQuantity;
	}

	/**
	 * 设置 存储数量 t_stock.store_quantity
	 * 
	 * @param storeQuantity 存储数量
	 */
	public void setStoreQuantity(Integer storeQuantity) {
		this.storeQuantity = storeQuantity;
	}

	/**
	 * 获取 单价 t_stock.unit_price
	 * 
	 * @return 单价
	 */
	public Long getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 设置 单价 t_stock.unit_price
	 * 
	 * @param unitPrice 单价
	 */
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 获取 存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区 t_stock.stock_type_area
	 * 
	 * @return 存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区
	 */
	public Byte getStockTypeArea() {
		return stockTypeArea;
	}

	/**
	 * 设置 存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区 t_stock.stock_type_area
	 * 
	 * @param stockTypeArea 存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区
	 */
	public void setStockTypeArea(Byte stockTypeArea) {
		this.stockTypeArea = stockTypeArea;
	}

	/**
	 * 获取 入库经办仓管 t_stock.stock_operator
	 * 
	 * @return 入库经办仓管
	 */
	public String getStockOperator() {
		return stockOperator;
	}

	/**
	 * 设置 入库经办仓管 t_stock.stock_operator
	 * 
	 * @param stockOperator 入库经办仓管
	 */
	public void setStockOperator(String stockOperator) {
		this.stockOperator = stockOperator == null ? null : stockOperator.trim();
	}

	/**
	 * 获取 入库时间 t_stock.enter_stock_time
	 * 
	 * @return 入库时间
	 */
	public Date getEnterStockTime() {
		return enterStockTime;
	}

	/**
	 * 设置 入库时间 t_stock.enter_stock_time
	 * 
	 * @param enterStockTime 入库时间
	 */
	public void setEnterStockTime(Date enterStockTime) {
		this.enterStockTime = enterStockTime;
	}

	/**
	 * 获取 备注 t_stock.remark
	 * 
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注 t_stock.remark
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 获取 同意入库与否:0-否,1-可 t_stock.agree_enter_stock
	 * 
	 * @return 同意入库与否:0-否,1-可
	 */
	public Boolean getAgreeEnterStock() {
		return agreeEnterStock;
	}

	/**
	 * 设置 同意入库与否:0-否,1-可 t_stock.agree_enter_stock
	 * 
	 * @param agreeEnterStock 同意入库与否:0-否,1-可
	 */
	public void setAgreeEnterStock(Boolean agreeEnterStock) {
		this.agreeEnterStock = agreeEnterStock;
	}

	@Override
	public String toString() {
		return "TStock [id=" + id + ", purchaseId=" + purchaseId + ", storeCommodity=" + storeCommodity
				+ ", storeQuantity=" + storeQuantity + ", unitPrice=" + unitPrice + ", stockTypeArea=" + stockTypeArea
				+ ", stockOperator=" + stockOperator + ", enterStockTime=" + enterStockTime + ", remark=" + remark
				+ ", agreeEnterStock=" + agreeEnterStock + "]";
	}

}