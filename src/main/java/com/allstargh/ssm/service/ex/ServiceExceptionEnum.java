package com.allstargh.ssm.service.ex;

/**
 * 业务异常之枚举
 * 
 * @author gzh
 * 
 */
public enum ServiceExceptionEnum {
	/** 实例成员 */
	INSTANCE,
	/** 审批已过截止期,禁止更改 */
	OVER_DEADLINE(422, "审批已过截止期,禁止更改"),
	/** 您已下线,请重新登录 */
	OFFLINE_LOGIN(410, "您已下线,请重新登录"),
	/** 此名已有人先用,请另换名字 */
	UNAME_DUPLICATE_CONFLICT(411, "此名已有人先用,请另换名字"),
	/** ("1个电话至多只准绑定注册1个账户") */
	COUNT_PHONE_OUT_RANGE(412, "1个电话至多只准绑定注册1个账户"),
	/** "您尚未填完信息" */
	SUBMIT_DATA_UNCOMPLETELY(413, "您尚未填完信息"),
	/** "用户名或密码未输入" */
	UNAME_OR_KWD_NOT_INPUT(414, "用户名或密码未输入"),
	/** "用户名错误,无此用户名" */
	USRNAME_ERR(415, "用户名错误,无此用户名"),
	/** "密码错误,请检查密码无误后再登录" */
	KEYWORD_ERR(416, "密码错误,请检查密码无误后再登录"),
	/** 您的账号已被注销,请联络管理员重新激活 */
	CANCELED_ACCOUNT(417, "您的账号已被注销,请联络管理员重新激活"),
	/** 系统繁忙,请稍后重试 */
	SYSTEM_BUSY(418, "系统繁忙,请稍后重试"),
	/** ("未寻获有关结果") */
	NO_RESULT_RECORD(419, "未寻获有关结果"),
	/** 提交为空 */
	COMMIT_HAS_NULL(420, "提交为空"),
	/** 权限错位,您没有相应权限 */
	COMPETENCE_DISLOCATION(421, "权限错位,您没有相应权限"),;

	private Integer code;
	private String description;

	private ServiceExceptionEnum() {
		System.out.println("无参数构造方法");
	}

	private ServiceExceptionEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
		System.out.println("双参数构造方法");
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 根据code获取description
	 * 
	 * @param code
	 * @return
	 */
	public String getDescByCode(Integer code) {
		for (ServiceExceptionEnum element : ServiceExceptionEnum.values()) {
			if (code == element.code) {
				return element.description;
			}
		}

		return null;
	}

	/**
	 * 根据description获取code
	 * 
	 * @param description
	 * @return
	 */
	public Integer getCodeByDesc(String description) {
		for (ServiceExceptionEnum element : ServiceExceptionEnum.values()) {
			if (description.equals(element.description)) {
				return element.code;
			}
		}

		return null;
	}

	/*
	 * 懒汉式
	 */
	private static ServiceExceptionEnum exEnum;

	// 锁
	private static final Object LOCK = new Object();

	public static ServiceExceptionEnum getInstance() {
		if (exEnum == null) {
			// 决定是否需要锁定
			synchronized (LOCK) {
				if (exEnum == null) {
					exEnum = ServiceExceptionEnum.INSTANCE;
				}
			}
		}

		return exEnum;
	}

}