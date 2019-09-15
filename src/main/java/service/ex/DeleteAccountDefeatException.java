package service.ex;

/**
 * 删除账号失败异常
 * 
 * @author gzh
 *
 */
public class DeleteAccountDefeatException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteAccountDefeatException() {
		super();
		
	}

	public DeleteAccountDefeatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DeleteAccountDefeatException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DeleteAccountDefeatException(String message) {
		super(message);
		
	}

	public DeleteAccountDefeatException(Throwable cause) {
		super(cause);
		
	}

}