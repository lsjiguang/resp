package com.rrtx.frame.util;

import com.rrtx.app.constants.Constants;
//import com.zte.zxywpub.MD5;

public class MacUtil {
	
	public static String getDigest(String digest) {
		if(digest.equals("")){
			return "";
		}
		String key=Constants.getAppConfig(Constants.APP_CONFIG_MAC_KEY);
      //  digest = MD5.MD5Encode2Hex(digest).toUpperCase();
      //  digest = MD5.MD5Encode2Hex(digest+key).toUpperCase();
        
        return digest;
    }
}
