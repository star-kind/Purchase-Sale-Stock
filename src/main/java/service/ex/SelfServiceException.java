package service.ex;

/**
 * 于前台因自身不当操作而引起的异常之超类
 * 
 * @author gzh
 *
 */
public class SelfServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelfServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelfServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SelfServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SelfServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SelfServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}