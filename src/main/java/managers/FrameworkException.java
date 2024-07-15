package managers;

/**
 * Generic exception from Framework. Will be utilized for failures that are generated from tests/functions.
 * 
 */
public class FrameworkException extends RuntimeException {



	public FrameworkException() {
	 // Default Constructor	
	}

	public FrameworkException(String arg0) {
		super(arg0);
	}

	public FrameworkException(Throwable arg0) {
		super(arg0);
	}

	public FrameworkException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FrameworkException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
