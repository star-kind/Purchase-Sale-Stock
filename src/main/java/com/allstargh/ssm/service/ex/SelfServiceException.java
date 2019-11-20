package com.allstargh.ssm.service.ex;

/**
 * 于前台因自身不当操作而引起的异常之超类
 * 
 * @author admin
 *
 */
public class SelfServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SelfServiceException() {
		super();

	}

	public SelfServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public SelfServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public SelfServiceException(String message) {
		super(message);

	}

	public SelfServiceException(Throwable cause) {
		super(cause);

	}

}