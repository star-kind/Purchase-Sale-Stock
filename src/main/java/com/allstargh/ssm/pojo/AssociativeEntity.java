package com.allstargh.ssm.pojo;

/**
 * 用户姓名,存储物品之联合实体
 * 
 * @author admin
 *
 */
public class AssociativeEntity extends TStock {
	/**
	 * 专为申请者而设
	 */
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AssociativeEntity [username=" + username + ", toString()=" + super.toString() + "]";
	}

}
