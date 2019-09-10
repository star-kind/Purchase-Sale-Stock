package service.ex;

/**
 * 异常:账号已被注销
 * 
 * @author gzh
 *
 */
public class CanceledAccountException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CanceledAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CanceledAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CanceledAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CanceledAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CanceledAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}