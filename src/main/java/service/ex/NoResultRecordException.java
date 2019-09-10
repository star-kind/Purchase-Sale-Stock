package service.ex;

/**
 * 查无所获
 * 
 * @author gzh
 *
 */
public class NoResultRecordException extends SelfServiceException {

	private static final long serialVersionUID = 1L;

	public NoResultRecordException() {
		super();

	}

	public NoResultRecordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public NoResultRecordException(String message, Throwable cause) {
		super(message, cause);

	}

	public NoResultRecordException(String message) {
		super(message);

	}

	public NoResultRecordException(Throwable cause) {
		super(cause);

	}

}