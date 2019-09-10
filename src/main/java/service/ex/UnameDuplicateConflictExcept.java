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
		// TODO Auto-generated constructor stub
	}

	public UnameDuplicateConflictExcept(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnameDuplicateConflictExcept(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnameDuplicateConflictExcept(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnameDuplicateConflictExcept(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}