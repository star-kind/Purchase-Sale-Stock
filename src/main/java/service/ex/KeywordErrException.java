package service.ex;

/**
 * 登录时密码错误
 * 
 * @author gzh
 *
 */
public class KeywordErrException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KeywordErrException() {
		super();
		
	}

	public KeywordErrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public KeywordErrException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public KeywordErrException(String message) {
		super(message);
		
	}

	public KeywordErrException(Throwable cause) {
		super(cause);
		
	}

}