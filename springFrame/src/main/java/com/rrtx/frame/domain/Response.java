package com.rrtx.frame.domain;

public abstract class Response extends DomainWapper{
	public ResponseHeader responseHeader = new ResponseHeader();
 
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	public abstract String getMACSource();
}
