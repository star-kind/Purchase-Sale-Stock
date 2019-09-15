package service.ex;

/**
 * 提交之数据不完整
 * 
 * @author gzh
 *
 */
public class SubmitDataUnCompletelyException extends SelfServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubmitDataUnCompletelyException() {
		super();
		
	}

	public SubmitDataUnCompletelyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public SubmitDataUnCompletelyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SubmitDataUnCompletelyException(String message) {
		super(message);
		
	}

	public SubmitDataUnCompletelyException(Throwable cause) {
		super(cause);
		
	}

}