package com.rrtx.app.constants;
import org.apache.log4j.Logger;
/**
 * @ClassName: ErrorMessage 
 * @Description: 数据库中的错误码
 * @author qijia
 * @date 2013-5-27 下午5:51:47
 * @version	1.0
 */
public class ErrorMessage {
	private static final Logger logger = Logger.getLogger(ErrorMessage.class);
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
