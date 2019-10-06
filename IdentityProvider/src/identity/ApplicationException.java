package identity;

public class ApplicationException extends Exception
{

	private static final long serialVersionUID = 7718828512143293558L;
	
	
	// Exception Code
	private final ErrorCodes code;
	
	// ExceptionMessage
	protected String message;


	/**
	 * Constructor
	 * @param code The ErrorCode
	 */
	public ApplicationException(ErrorCodes code)
	{
		super();
		this.code = code;
	}
	
	/** 
	 * Constructor
	 * @param message  The Exception Message
	 * @param cause The Exception Cause
	 * @param code The ErrorCode
	 */
	public ApplicationException(String message, Throwable cause, ErrorCodes code) {
		super(message, cause);
		this.code = code;
	}

	/**
	 * Constructor
	 * @param message  The Exception Message
	 * @param code The ErrorCode
	 */
	public ApplicationException(String message, ErrorCodes code) {
		super(message);
		this.code = code;
	}

	/**
	 * Constructor
	 * @param cause  The Exception Cause
	 * @param code The ErrorCode
	 */
	public ApplicationException(Throwable cause, ErrorCodes code) {
		super(cause);
		this.code = code;
	}
	
	/**
	 * getCode
	 * @return The error code
	 */
	public ErrorCodes getCode() {
		return this.code;
	}
}
