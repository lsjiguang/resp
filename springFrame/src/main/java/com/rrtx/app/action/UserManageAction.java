package com.rrtx.app.action;
 
import com.rrtx.frame.action.AbstractWebAction; 
import com.rrtx.frame.context.Context;

public class UserManageAction extends AbstractWebAction {

	@Override
	public void execute(Context context) {
		super.addResult("message"," hello world!");
		super.setReturnPage("/hello.jsp");
	}
 

}
