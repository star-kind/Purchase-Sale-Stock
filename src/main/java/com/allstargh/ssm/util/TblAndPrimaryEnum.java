package com.allstargh.ssm.util;

/**
 * 表名与primary_key列名之枚举
 * 
 * <em>无用</em>
 * 
 * @author admin
 *
 */
public enum TblAndPrimaryEnum {
	/** 账号表 */
	ACCOUNTS(0, "accounts", "usrid"),
	/** 采购表 */
	PURCHASE(1, "purchase", "purchase_id"),
	/** 存储记录表 */
	T_STOCK(2, "t_stock", "id"),
	/** 审核表 */
	T_APPROVAL(3, "t_approval", "id"),
	/** 销售表 */
	T_SALE(4, "t_sale", "id"),
	/** 出库记录 */
	T_OUT(5, "t_out", "id"),;

	/**
	 * 序号
	 */
	private Integer order;

	/**
	 * 表名
	 */
	private String tblName;

	/**
	 * 主键列名
	 */
	private String primaryColumn;

	private TblAndPrimaryEnum(Integer order, String tblName, String primaryColumn) {
		this.order = order;
		this.tblName = tblName;
		this.setPrimaryColumn(primaryColumn);
	}

	private TblAndPrimaryEnum() {
		System.err.println("Table And Primary Column Name Enum No Parameter Constructor");
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	public String getPrimaryColumn() {
		return primaryColumn;
	}

	public void setPrimaryColumn(String primaryColumn) {
		this.primaryColumn = primaryColumn;
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public static String getTblByOrder(Integer order) {
		for (TblAndPrimaryEnum element : TblAndPrimaryEnum.values()) {
			if (order == element.order) {
				return element.tblName;
			}
		}

		return null;
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public static String getPrimaryColumnByOrder(Integer order) {
		for (TblAndPrimaryEnum element : TblAndPrimaryEnum.values()) {
			if (order == element.order) {
				return element.primaryColumn;
			}
		}

		return null;
	}

}
