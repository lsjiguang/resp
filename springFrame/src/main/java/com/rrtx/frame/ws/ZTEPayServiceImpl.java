package com.rrtx.frame.ws;
 
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.rrtx.app.constants.Constants;
import com.rrtx.frame.action.AbstractAction;
import com.rrtx.frame.exception.ZTEPayException;
import com.rrtx.frame.util.DebugUtil;

@WebService(endpointInterface = "com.zte.pay.ws.IZTEPayService")
public class ZTEPayServiceImpl implements IZTEPayService,ApplicationContextAware {
	private static final Logger logger = Logger.getLogger(ZTEPayServiceImpl.class); 
	private static ApplicationContext context;
	
	CommData responseData=new CommData();
	public CommData ZTEPayProxy(CommData requestData){
		AbstractAction action =null;
		String messageId = requestData.getMessageId();
		String mac=requestData.getMac();
		
		//debug 请求信息
		logger.debug("Message: "+messageId+"'s request data is:");
		DebugUtil.printInfo(requestData, ZTEPayServiceImpl.class);
		
		try {
			String actionName=Constants.getTransName(requestData.getBizCode()).trim(); 
			//如果首字母大写，调整为小写。使其与spring容器中注册的bean Name 一致
			actionName = actionName.substring(0,1).toLowerCase() + actionName.substring(1);
			action=(AbstractAction)context.getBean(actionName);
			logger.info("Message: "+messageId+",Request for biz: "+requestData.getBizCode()+",action is: "+ actionName );
			responseData =  action.execute(requestData);
			responseData.setMessageId(messageId);
		} catch (ZTEPayException e) { 
			responseData.setSuccess("false");
			responseData.setErrorCode(Constants.SERVER_ERROR_EXCEPTION.getErrorCode());
			responseData.setErrors(Constants.SERVER_ERROR_EXCEPTION.getErrorMessage());
			return responseData;
		} catch(Exception e) { 
			e.printStackTrace();
			responseData.setSuccess("false");
			responseData.setErrorCode(Constants.SERVER_NOT_EXIST_EXCEPTION.getErrorCode());
			responseData.setErrors(Constants.SERVER_NOT_EXIST_EXCEPTION.getErrorMessage());
		}
		
		logger.info("Message: "+messageId+",Request for biz: "+requestData.getBizCode()+",deal result is: Success:"+responseData.getSuccess()+" "+( Boolean.parseBoolean(responseData.getSuccess())?"":responseData.getErrorCode()+","+responseData.getErrors()));
		//debug 返回信息
		logger.debug("Message: "+messageId+"'s response data is:");
		DebugUtil.printInfo(responseData, ZTEPayServiceImpl.class);
		
		return responseData;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
	
	
	
}
