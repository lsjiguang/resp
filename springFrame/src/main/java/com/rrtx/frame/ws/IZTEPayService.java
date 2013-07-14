package com.rrtx.frame.ws;

import javax.jws.WebService;

@WebService
public interface IZTEPayService {
	public CommData ZTEPayProxy(CommData requestData);
}
