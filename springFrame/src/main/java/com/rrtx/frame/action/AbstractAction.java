package com.rrtx.frame.action;

import java.lang.reflect.Field;

import com.rrtx.app.constants.Constants;
import com.rrtx.frame.context.Context;
import com.rrtx.frame.domain.Request;
import com.rrtx.frame.domain.RequestHeader;
import com.rrtx.frame.domain.Response;
import com.rrtx.frame.domain.ResponseHeader;
import com.rrtx.frame.exception.ZTEPayException;
import com.rrtx.frame.util.AmountUtil;
import com.rrtx.frame.util.ClassUtil;
import com.rrtx.frame.util.MacUtil;
import com.rrtx.frame.ws.CommData;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

/**
 * @ClassName: AbstractAction
 * @Description: action的抽象类，所有交易的action均需继承此action。
 * 				  范型为AbstractAction<com.zte.pay.domain.Request,com.zte.pay.domain.Response>
 * @author qijia
 * @date 2013-5-13 上午11:42:42
 * @version	1.0
 */
public abstract class AbstractAction<T,T1> implements IAction{
	
	private Class<T> requestClass; 
	private Context context;
	/**  
	 * @Description: 将webservice上送的数据填充到request中
	*/ 
	T ConvertCommData2Request(CommData commData) {
		requestClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Field[] fields=ClassUtil.getAllDecaredFields(requestClass);
		T obj=null;
		try {
			obj = requestClass.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
			
		BeanWrapperImpl wrapper = new BeanWrapperImpl(obj);
		BeanWrapperImpl commDataWrapper = new BeanWrapperImpl(commData);
		
		for (Field field : fields) {
			// 处理报文头
			if (field.getType().isAssignableFrom(RequestHeader.class)) {
				Field[] headerFields = RequestHeader.class.getDeclaredFields();
				BeanWrapperImpl headWrapper = new BeanWrapperImpl(
						wrapper.getPropertyValue(field.getName()));
				
				for (Field headField : headerFields) {
				  headWrapper.setPropertyValue(headField.getName(),commDataWrapper.getPropertyValue(headField.getName()));					 
				}
			} else if(field.getType().isAssignableFrom(List.class)) {//如果是list
				
				ParameterizedType pt = (ParameterizedType) field.getGenericType();
				
				Class listActualType=(Class)pt.getActualTypeArguments()[0]; // 获得list范型的真实类型
				
				List list=new ArrayList(); //将array中的数据转储到List中
				
				Field[] listActualTypeFields=listActualType.getDeclaredFields();
				 			
					Object[] arrays= (Object[])commDataWrapper.getPropertyValue(field.getName());// commdata中的数组 
					
					for(Object objInArray:arrays){
						Object o;
						try {
							o = listActualType.newInstance();
							BeanWrapperImpl owrapper = new BeanWrapperImpl(o);
							
							BeanWrapperImpl objInArrayWrapper = new BeanWrapperImpl(objInArray);
							
							for(Field listActualTypeField:listActualTypeFields){
								owrapper.setPropertyValue(listActualTypeField.getName(),objInArrayWrapper.getPropertyValue(listActualTypeField.getName()));
							} 
							list.add(o);
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						
					}
					wrapper.setPropertyValue(field.getName(),list);	
			}else{
				 wrapper.setPropertyValue(field.getName(),commDataWrapper.getPropertyValue(field.getName())); 
			}
		} 
		
		return  obj;
	}
	
	/**  
	 * @Description: 将返回的response数据填充到commData中
	*/ 
	CommData ConvertResult2CommData(T1 response){
		Field[] fields=ClassUtil.getAllDecaredFields(response.getClass());
		CommData obj=new CommData();
		BeanWrapperImpl commDataWrapper = new BeanWrapperImpl(obj);
		BeanWrapperImpl responseWrapper = new BeanWrapperImpl(response);
		try {
			
			 //如果交易失败，直接返回response header，不再处理报文体
			 if(((Response)response).getResponseHeader().getSuccess().equals("false")){
				 Field[] headerFields=ResponseHeader.class.getDeclaredFields();
				 for(Field headField:headerFields){
					 commDataWrapper.setPropertyValue(headField.getName(), headField.get(((Response)response).getResponseHeader()));
				 }
				 return obj;
			 }
			 
			
			//如果交易成功，逐个数据域处理
			 for(Field field:fields){
				 
				 // 处理报文头
				 if(field.getType().isAssignableFrom(ResponseHeader.class)){
					 
					 Field[] headerFields=ResponseHeader.class.getDeclaredFields();
					 
					 for(Field headField:headerFields){
						 commDataWrapper.setPropertyValue(headField.getName(), headField.get(field.get(response)));
					 }
					 
					 continue;
					 
				 } else if(field.getType().isAssignableFrom(List.class)) {//如果是list,将list中的数据转储到array中
						
						ParameterizedType pt = (ParameterizedType) field.getGenericType();
						
						Class listActualType=(Class)pt.getActualTypeArguments()[0];
						
						Class arrayActualType=commDataWrapper.getPropertyType(field.getName()).getComponentType();
					
						List list=(List)responseWrapper.getPropertyValue(field.getName());
						int length = list.size();
						Object[] objs= new Object[length];
						
						Field[] listActualTypeFields=listActualType.getDeclaredFields();
						
						try {
							 
							for(int i=0;i<list.size();i++) {
								
								Object objInArray=arrayActualType.newInstance(); 
								
								BeanWrapperImpl owrapper = new BeanWrapperImpl(objInArray);
								
								BeanWrapperImpl arwrapper = new BeanWrapperImpl(list.get(i));
								
								for(Field fieldListE:listActualTypeFields){ 
									owrapper.setPropertyValue(fieldListE.getName(),arwrapper.getPropertyValue(fieldListE.getName())); 
								} 
								objs[i] = objInArray; 
							}
							commDataWrapper.setPropertyValue(field.getName(),objs);	 
						} catch (InstantiationException e){
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} 		
						
					}else{
						commDataWrapper.setPropertyValue(field.getName(),responseWrapper.getPropertyValue(field.getName())); 
					}
			 } 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}  catch (SecurityException e) {
			e.printStackTrace();
		}  catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		return  obj; 
	}
	
	/**  
	 * @Description: 将异常消息设置到responseHeader中
	*/ 
	Response TellException2Client(ZTEPayException exception,Response reponse){
		String errorCode = exception.getErrorCode();
		String errors = exception.getErrorMessage(); 
		if(errors ==null || errors.equals("")){
			errors = Constants.getErrorMessage(errorCode); 
		}
		reponse.getResponseHeader().errorCode = errorCode;
		reponse.getResponseHeader().errors = errors;
		reponse.getResponseHeader().success = "false";
		return reponse;
	}
	
	public CommData execute(CommData commData){
		Request request = (Request)ConvertCommData2Request(commData);
		CommData responseData=new CommData();
		
		try{
			validRequestData((T) request);
		}catch(ZTEPayException e){
			responseData.setErrorCode(e.getErrorCode());
			responseData.setErrors(e.getErrorMessage());
			responseData.setSuccess("false");
			return responseData;
		}
		
		if(!CheckMac(request)){
			responseData.setErrorCode("BIZPUB02");
			responseData.setErrors(Constants.getErrorMessage(responseData.getErrorCode()));
			responseData.setSuccess("false");
		} else {
			//对金额进行特殊处理，输入时，中兴金额单位为分，转成以元为单位
			BeanWrapperImpl wrapper = new BeanWrapperImpl(request);
			
			try{
				if(wrapper.isReadableProperty("balance")){
					wrapper.setPropertyValue("balance",AmountUtil.changeF2Y(String.valueOf(wrapper.getPropertyValue("balance"))));
				}
				
				if(wrapper.isReadableProperty("amount")){
					wrapper.setPropertyValue("amount",AmountUtil.changeF2Y(String.valueOf(wrapper.getPropertyValue("amount"))));
				}
				
			}catch (BeansException e) {
				e.printStackTrace();
				responseData.setErrorCode(Constants.SERVER_ERROR_EXCEPTION.getErrorCode()); 
				responseData.setSuccess("false");
				return responseData;
				
			} catch (Exception e) { 
				e.printStackTrace();
				responseData.setErrorCode(Constants.SERVER_ERROR_EXCEPTION.getErrorCode()); 
				responseData.setSuccess("false");
				return responseData;
			}
			
			Response response = (Response)execute(request);
			
			//对金额进行特殊处理，输出时，系统以元为单位，中兴金额单位为分，转成以分为单位
			BeanWrapperImpl responseWrapper = new BeanWrapperImpl(response);
			
			try{
				if(responseWrapper.isReadableProperty("balance")){
					responseWrapper.setPropertyValue("balance",AmountUtil.changeY2F(String.valueOf(responseWrapper.getPropertyValue("balance"))));
				}
				if(responseWrapper.isReadableProperty("amount")){
					responseWrapper.setPropertyValue("amount",AmountUtil.changeY2F(String.valueOf(responseWrapper.getPropertyValue("amount"))));
				}
			} catch (BeansException e) {
				e.printStackTrace();
				responseData.setErrorCode(Constants.SERVER_ERROR_EXCEPTION.getErrorCode()); 
				responseData.setErrors(Constants.SERVER_ERROR_EXCEPTION.getErrorMessage());
				responseData.setSuccess("false");
				return responseData;
				
			} catch (Exception e) { 
				e.printStackTrace();
				responseData.setErrorCode(Constants.SERVER_ERROR_EXCEPTION.getErrorCode()); 
				responseData.setErrors(Constants.SERVER_ERROR_EXCEPTION.getErrorMessage());
				responseData.setSuccess("false");
				return responseData;
			}
			AddMac(response);
			responseData = ConvertResult2CommData((T1) response);
		}
		
		return responseData;
	}
	
	/**  
	 * @Description: mac校验
	*/ 
	public boolean CheckMac(Request requestData){
//		System.out.println(Constants.getAppConfig(Constants.APP_CONFIG_MAC_CHECK));
		// 如果不需要进行mac校验，则返回true
		if(!Boolean.parseBoolean(Constants.getAppConfig(Constants.APP_CONFIG_MAC_CHECK))){
			return true;
		}
		 Logger logger = Logger.getLogger(AbstractAction.class); 
		logger.debug("client="+requestData.requestHeader.mac);
		logger.debug("source="+requestData.getMACSource());
		logger.debug("Server="+MacUtil.getDigest(requestData.getMACSource()));
		
		if(MacUtil.getDigest(requestData.getMACSource()).equals(requestData.requestHeader.mac))
			return true;
		else
			return false;
	}
	
	/**  
	 * @Description: 将mac值添加到responseHeader中
	*/ 
	public void AddMac(Response responesData){
		Logger logger = Logger.getLogger(AbstractAction.class); 
		logger.debug("Respones MAC Source:"+responesData.getMACSource());
		logger.debug("Respones MAC :"+MacUtil.getDigest(responesData.getMACSource()));
		responesData.responseHeader.mac=MacUtil.getDigest(responesData.getMACSource());
	}
	
	/**  
	 * @Description: 对request数据进行校验
	*/ 
	public void validRequestData(T obj) throws ZTEPayException{
		Validator validator = Constants.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		//如果有检验问题
		if(constraintViolations.size()>0){
			String errors = "";
			Iterator<ConstraintViolation<T>> validMessages = constraintViolations.iterator();
			while(validMessages.hasNext()){
				ConstraintViolation<T> validMessage =  validMessages.next();
				errors = errors + validMessage.getPropertyPath() +" "+ validMessage.getMessage() + ",";
			}
			throw new ZTEPayException("FAPPUB02",errors.substring(0,errors.length()-1));
		}
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
}
