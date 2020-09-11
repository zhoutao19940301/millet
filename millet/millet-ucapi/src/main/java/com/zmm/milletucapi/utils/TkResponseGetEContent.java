package com.zmm.milletucapi.utils;


import com.zmm.milletucapi.common.TkResponseCode;

public class TkResponseGetEContent {

	/**
	 * 获取返回信息
	 * @param ecode
	 * @return
	 */
	public static String getEContent(String ecode){
		if((null == ecode)|| (ecode.trim().length()<4) ){
			return "";
		}
		for(String[] code_content: TkResponseCode.CODE_CONTENT){
			if(code_content[0].equals(ecode)) {
				return code_content[1];
    		}
    	}
    	return "ERROR";
	}

}
