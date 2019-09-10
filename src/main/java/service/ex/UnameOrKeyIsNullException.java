package service.ex;

/**
 * 用户名或密码为空
 * 
 * @author gzh
 *
 */
public class UnameOrKeyIsNullException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnameOrKeyIsNullException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnameOrKeyIsNullException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnameOrKeyIsNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnameOrKeyIsNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnameOrKeyIsNullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}