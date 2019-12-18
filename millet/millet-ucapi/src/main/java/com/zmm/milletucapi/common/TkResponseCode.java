package com.zmm.milletucapi.common;

public interface TkResponseCode {
	
	/**返回状态值：成功   */
	public static final String SUCCESS 					= "200";
	public static final String CONNECT_ERROR 			= "9000";
	public static final String ERROR_NORMAL 			= "0099";
	public static final String ERROR_REDIS				= "1000";
	public static final String ERROR_PARAMS				= "1001";
	public static final String ERROR_DBSAVE				= "1002";
	public static final String ERROR_DES				= "1003"; 
	public static final String ERROR_DBQUERY			= "1004";
	public static final String ERROR_INIT				= "1005"; 
	public static final String ERROR_EMPTY				= "1006";
	public static final String ERROR_VERIFY				= "1007";
	public static final String ERROR_ISEXISTS			= "1008";
	public static final String ERROR_LOGIN				= "1009";
	public static final String USER_NULL 				= "1010";
	public static final String CASH_PASSWORD_ERROR	    = "1011";
		
	/********************************py*2000****************************************/


	
	/********************************我是分割线**************************************/	
	
	public static final String[][] CODE_CONTENT = {
		{SUCCESS 					,"处理成功"},
		{CONNECT_ERROR 				,"连接超时"},
		{ERROR_NORMAL 				,"处理错误"},
		{ERROR_REDIS				,"缓存错误"},
		{ERROR_PARAMS				,"参数非法"},
		{ERROR_DBSAVE				,"数据持久化错误"},
		{ERROR_DES					,"协议报文加解密错误"},
		{ERROR_INIT					,"初始化错误"},
		{ERROR_EMPTY				,"数据为空"},
		{ERROR_VERIFY				,"数据验证错误"},
		{ERROR_ISEXISTS				,"数据已经存在"},
		{ERROR_LOGIN				,"登陆错误"},
		{USER_NULL					,"登录状态失效，请重新登录"},
		{CASH_PASSWORD_ERROR		,"交易密码错误"},
		
		
		/********************************py*2000****************************************/

		
		
		
		
		/********************************我是分割线**************************************/	
		
		
		
		
		
		
		
		
	};

}
