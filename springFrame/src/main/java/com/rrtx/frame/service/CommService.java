package com.rrtx.frame.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.rrtx.app.constants.Constants;
import com.rrtx.app.constants.ErrorMessage;
import com.rrtx.frame.exception.TransException;
import com.rrtx.frame.exception.ZTEPayException;

/**
 * @ClassName: CommService 
 * @Description: 提供交易用到的公共服务
 * @author qijia
 * @date 2013-5-13 上午3:19:32
 * @version	1.0
 */
@Service
public class CommService extends AbsractService{ 
	private static final Logger logger = Logger.getLogger(Constants.class);
	/**  
	 * @Description: 通过customerId检查用户是否存在
	*/ 
	public boolean checkCustomerExistById(String customerID) throws ZTEPayException{
		int rowCount=0;
		try {
			rowCount = ((Integer) (getSqlMapClientTemplate().queryForObject("Common.checkCustomerExistById", customerID))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			throw Constants.SERVER_ERROR_EXCEPTION; //服务异常
		}
		
		if(rowCount==0)
			throw new TransException("BIZPUB01"); //用户不存在
		
		return true;
	} 
	
	/**  
	 * @Description: 通过tokenId检查用户是否存在(近场支付)
	*/ 
	public boolean checkCustomerExistByToken(String tokenId) throws ZTEPayException{
		int rowCount=0;
		try {
			rowCount = ((Integer) (getSqlMapClientTemplate().queryForObject("Common.checkCustomerExistByToken", tokenId))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			throw Constants.SERVER_ERROR_EXCEPTION; //服务异常
		}
		
		if(rowCount==0)
			throw new TransException("BIZPUB01"); //用户不存在
		
		return true;
	} 
	
	/**  
	 * @Description: 通过tokenId检查用户是否存在(电视支付)
	*/ 
	public boolean checkCustomerExistByTVToken(String tvTokenId) throws ZTEPayException{
		int rowCount=0;
		try {
			rowCount = ((Integer) (getSqlMapClientTemplate().queryForObject("Common.checkCustomerExistByTVToken", tvTokenId))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			throw Constants.SERVER_ERROR_EXCEPTION; //服务异常
		}
		
		if(rowCount==0)
			throw new TransException("BIZPUB01"); //用户不存在
		
		return true;
	} 

	/**  
	 * @Description: 加载错误码表
	*/ 
	public void initErrorTables(Map errorTables){
		try {
			List<ErrorMessage> list = getSqlMapClientTemplate().queryForList("Common.loadErrorMessages");
			for(ErrorMessage error:list){
				errorTables.put(error.getErrorCode(), error.getErrorMessage());
			}
		} catch (SQLException e) {
			logger.warn("加载 pub_error 参数失败");
			e.printStackTrace();
		}
	} 
	
	
	/** 
	 * @Description: 获取TVPTokenID对应的客户号
	*/ 
	public String getCustomerNoByTVPToken(String tvpToken) throws ZTEPayException{
		 try {
			 String custNo = ((String) (getSqlMapClientTemplate().queryForObject("Common.getCustomerNoByTVPToken", tvpToken)));
			 return custNo;
		 } catch (SQLException e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			throw Constants.SERVER_ERROR_EXCEPTION; //服务异常
		}
		
		 
	} 
	
	/** 
	 * @Description: 获取NFPTokenID对应的客户号
	*/ 
	public String getCustomerNoByNFPToken(String nfpToken) throws ZTEPayException{
		 try {
			 String custNo = ((String) (getSqlMapClientTemplate().queryForObject("Common.getCustomerNoByNFPToken", nfpToken)));
			 return custNo;
		 } catch (SQLException e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			throw Constants.SERVER_ERROR_EXCEPTION; //服务异常
		}
		
		 
	} 
}
