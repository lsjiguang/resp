package com.rrtx.frame.action;

import com.rrtx.frame.domain.Request;
import com.rrtx.frame.domain.Response;

public interface IAction {
	public Response execute(Request request);
}
