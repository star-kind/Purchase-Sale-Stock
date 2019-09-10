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
		// TODO Auto-generated constructor stub
	}

	public UsrnameErrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsrnameErrException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsrnameErrException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsrnameErrException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}