package service.ex;

/**
 * 登录时用户名错误
 * 
 * @author gzh
 *
 */
public class UsrnameErrException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsrnameErrException() {
		super();
		
	}

	public UsrnameErrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UsrnameErrException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsrnameErrException(String message) {
		super(message);
		
	}

	public UsrnameErrException(Throwable cause) {
		super(cause);
		
	}

}