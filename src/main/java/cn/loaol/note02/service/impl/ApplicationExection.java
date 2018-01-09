package cn.loaol.note02.service.impl;

public class ApplicationExection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationExection() {
	}
	
	public ApplicationExection(String message) {
		super(message);
	}

	public ApplicationExection(Throwable cause) {
		super(cause);
	}

	public ApplicationExection(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationExection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
