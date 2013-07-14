package com.rrtx.frame.exception;

import com.rrtx.app.constants.Constants;

public class ZTEPayException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public ZTEPayException() {
		super();
	}

	public ZTEPayException(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public ZTEPayException(String errorCode,String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ZTEPayException(Throwable cause) {
		super(cause);
	}

	public ZTEPayException(String message, Throwable cause) {
		super(message, cause);
	}

	public ZTEPayException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		if(errorMessage==null||errorMessage.equals("")){
			errorMessage = Constants.getErrorMessage(errorCode);
		}
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}