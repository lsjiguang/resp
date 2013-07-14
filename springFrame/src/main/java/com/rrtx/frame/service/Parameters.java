package com.rrtx.frame.service;

import com.rrtx.frame.domain.Request;
import com.rrtx.frame.domain.Response;

/**
 * @ClassName: Parameters 
 * @Description: 调用存储过程时的输入输出参数
 * @author qijia
 * @date 2013-5-15 下午4:07:41
 * @version	1.0
 */
public class Parameters {
	private Request request;
	private Response response;
	private String retCode;
	Parameters (Request request,Response response){
		this.request=request;
		this.response=response;
		retCode = "0";
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	
}
