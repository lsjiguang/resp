package com.rrtx.frame.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public abstract class Request extends DomainWapper {
	@NotNull
    @Valid
	public RequestHeader requestHeader = new RequestHeader();
	
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	/**  
	 * @Description: 获取mac校验所用的拼接字符串
	*/ 
	public abstract String getMACSource();
}
