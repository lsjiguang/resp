package com.rrtx.app.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.rrtx.frame.exception.ServerException;
import com.rrtx.frame.exception.ZTEPayException;
import com.rrtx.frame.service.CommService;

public class Constants { 
	private static final Logger logger = Logger.getLogger(Constants.class);
	//错误信息参数 及 交易码对照
	private static final Properties errorTable = new Properties();
	private static final Properties transTable = new Properties();
	//应用配置信息
	private static final Properties appConfig = new Properties();
	//系统配置参数的key值
	public static final String APP_CONFIG_MAC_CHECK="MAC_CHECK";
	public static final String APP_CONFIG_MAC_KEY="MAC_KEY";
	public static final String APP_CONFIG_CRYPT_KEY="CRYPT_KEY";
	
	//定义系统通用异常
	public static ZTEPayException SERVER_NOT_EXIST_EXCEPTION = new ServerException("FAPPUB01");
	public static ZTEPayException VALID_ERROR_EXCEPTION = new ServerException("FAPPUB02");
	public static ZTEPayException SERVER_ERROR_EXCEPTION = new ServerException("FAPPUB03");
	
	//用于数据校验的检验器
	private  static Validator validator;
	
	//数据库中的错误码表，应用启动时，在InitService中初始化
	private static Map errorTables= new HashMap();
	
	public static void init(CommService commService){
		//初始化校验器
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		//初始化数据库中的错误码表
		commService.initErrorTables(errorTables);
		//初始化配置文件
        try {
        	errorTable.load( Constants.class.getResourceAsStream("/errorMessage.properties"));
			transTable.load( Constants.class.getResourceAsStream( "/tranCode.properties" )); 
			appConfig.load( Constants.class.getResourceAsStream( "/appConfig.properties" ));
        } catch (Exception e) {
        	System.out.println("=====================加载参数失败===============================");
        	System.out.println("失败原因"+e.getMessage());
        }
	}
	
	public static  String getErrorMessage(String errorCode){
		String errorMessage = (String)errorTable.get(errorCode);
		if(errorMessage == null){
			errorMessage = (String)errorTables.get(errorCode);
		}
		if(errorMessage == null){
			errorMessage = "错误原因未知";
		}
		return errorMessage;
	}
	
	public static String getTransName(String transCode) throws ZTEPayException{ 
		String transName = (String)transTable.get(transCode);
		if(transName == null){
			throw SERVER_NOT_EXIST_EXCEPTION;
		}
		return transName;
	}

	public static Validator getValidator() {
		return validator;
	}
	
	public static String getAppConfig(String configKey){
		String configValue = (String)appConfig.get(configKey);
		if(configValue == null){
			logger.warn("系统参数:configKey 未定义");
		}
		return configValue;
	}
}
