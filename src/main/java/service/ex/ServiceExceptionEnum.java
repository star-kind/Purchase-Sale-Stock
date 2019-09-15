package service.ex;

/**
 * 业务异常之枚举
 * 
 * @author gzh
 * 
 */
public enum ServiceExceptionEnum {
	/** 实例成员 */
	INSTANCE,
	/** 您已下线,请重新登录 */
	OFFLINE_LOGIN(410, "您已下线,请重新登录")

	;

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