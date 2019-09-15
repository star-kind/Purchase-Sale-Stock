package service.ex;

/**
 * 单个账号绑定之电话号码超出范围(3个)
 * 
 * @author gzh
 *
 */
public class CountPhoneOutRangeException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountPhoneOutRangeException() {
		super();
		
	}

	public CountPhoneOutRangeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CountPhoneOutRangeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CountPhoneOutRangeException(String message) {
		super(message);
		
	}

	public CountPhoneOutRangeException(Throwable cause) {
		super(cause);
		
	}

}