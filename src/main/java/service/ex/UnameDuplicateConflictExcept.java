package service.ex;

/**
 * 用户名重复冲突
 * @author gzh
 *
 */
public class UnameDuplicateConflictExcept extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnameDuplicateConflictExcept() {
		super();
		
	}

	public UnameDuplicateConflictExcept(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UnameDuplicateConflictExcept(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UnameDuplicateConflictExcept(String message) {
		super(message);
		
	}

	public UnameDuplicateConflictExcept(Throwable cause) {
		super(cause);
		
	}
}