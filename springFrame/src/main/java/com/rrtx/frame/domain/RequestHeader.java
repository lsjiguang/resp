package com.rrtx.frame.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestHeader {
	@Size(min=8,max=20)
	public String messageId;
	
	public String version;
	@Size(min=4,max=4)
	public String bizCode;
	@NotNull
	public String mac;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
}
