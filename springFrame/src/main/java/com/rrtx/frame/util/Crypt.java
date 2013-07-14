package com.rrtx.frame.util;

import com.rrtx.app.constants.Constants;

//import des.SoftMobileEncryptor;
//import des.TransferUtil;

public class Crypt {

	//获得ZTE明文
	public static String Decrypt(String pwd){
		/*
		//双方约定密钥
		 String key=Constants.getAppConfig(Constants.APP_CONFIG_CRYPT_KEY);
		// 加密
		byte [] pw_byte=new byte[32];
		byte [] key_byte=new byte[32];
				
		pw_byte=TransferUtil.hexStr2Bytes(pwd);
		key_byte=TransferUtil.hexStr2Bytes(key);
				
		SoftMobileEncryptor encryt = new SoftMobileEncryptor();
		byte[] d_key = encryt.decryptByKey16(key_byte, pw_byte);
		String pwd_orin=TransferUtil.byte2HexStr(d_key);
		System.out.println("password:"+pwd_orin.substring(0,6));
		return pwd_orin.substring(0,6);
		*/
		return "";
	}
	
	//SHA1加密
	public static String SHA1Crypt(String source) {
        byte input[] = new byte[1024];
        String encPwd = null;
        try {
              input = source.getBytes();
              SHA1 sha1 = new SHA1();
              sha1.init();
              sha1.update(input, input.length);
              byte byEncoded[] = (new Base64()).encode(sha1.end());
              encPwd = new String(byEncoded);
        } catch (Exception e) {
              return null;
        }
        return encPwd;
   }	
	
}
