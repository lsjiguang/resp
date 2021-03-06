package com.rrtx.frame.util;

import java.math.BigDecimal;

public class AmountUtil {
	/** 
     * 将分为单位的转换为元 （除100） 
     *  
     * @param amount 
     * @return 
     * @throws Exception  
     */  
    public static String changeF2Y(String amount) throws Exception{  
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();  
    }  
      
    /**  
     * 将元为单位的转换为分 （乘100） 
     *  
     * @param amount 
     * @return 
     */  
    public static String changeY2F(String amount){  
    	// 如果为空，返回 0
    	if(amount==null||"null".equals(amount)){
    		return "0";
    	}
    	//如果是.01的形式
    	if(amount.startsWith(".")){
    		amount="0"+amount;
    	}
    	// 先看有没有小数点,如果没有 加 .00 如果有，补足小数点后两位
    	if(amount.indexOf(".")>0){
    		while(amount.substring(amount.indexOf(".")).length()<2){
    			amount = amount+"0";
    		}
    	} else{
    		amount = amount+".00";
    	}
    	
    	BigDecimal a= new BigDecimal(amount); 
        return String.valueOf(a.multiply(new BigDecimal(100)).intValue());  
    }
}
