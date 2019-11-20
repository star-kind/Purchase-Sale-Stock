package com.allstargh.ssm.pojo;

/**
 * 联合实体:用户ID+仓储品+销售表ID...etc
 * 
 * @author admin
 *
 */
public class JointStockVO extends TStock {
	/** 用户ID */
	private Integer uid;

	/** 销售表主键 */
	private Integer salePrimaryKey;

	/** 仓管员是否同意 */
	private Boolean stockerIsAgree;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getSalePrimaryKey() {
		return salePrimaryKey;
	}

	public void setSalePrimaryKey(Integer salePrimaryKey) {
		this.salePrimaryKey = salePrimaryKey;
	}

	public Boolean getStockerIsAgree() {
		return stockerIsAgree;
	}

	public void setStockerIsAgree(Boolean stockerIsAgree) {
		this.stockerIsAgree = stockerIsAgree;
	}

	@Override
	public String toString() {
		return "JointStockVO [uid=" + uid + ", salePrimaryKey=" + salePrimaryKey + ", stockerIsAgree=" + stockerIsAgree
				+ ", toString()=" + super.toString() + "]";
	}

}
