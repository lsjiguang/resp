package com.rrtx.frame.action;

import com.rrtx.frame.context.Context;

public class AbstractWebAction {
	Context context;
	public void execute(Context context) {
		
	}
	
	public void setReturnPage(String uri){
		context.put("page", uri);
	}
	
	public void addResult(String key,Object value){
		context.put(key, value);
	}
}
