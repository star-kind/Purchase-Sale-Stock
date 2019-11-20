package com.allstargh.ssm.pojo;

/**
 * 申请者姓名,存储物品之联合实体
 * 
 * @author admin
 *
 */
public class AssociativeEntity extends TStock {
	/**
	 * 专为申请者而设
	 */
	private String applicant;

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "AssociativeEntity [applicant=" + applicant + ", toString()=" + super.toString() + "]";
	}

}
