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
		// TODO Auto-generated constructor stub
	}

	public DeleteAccountDefeatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DeleteAccountDefeatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeleteAccountDefeatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeleteAccountDefeatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}