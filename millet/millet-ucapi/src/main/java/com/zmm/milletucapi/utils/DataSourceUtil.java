package com.zmm.milletucapi.utils;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Descriprion: 手动连接数据库工具类
 * @Author: zhoutao
 * @Date: 2019/11/11
 **/
public class DataSourceUtil {

    //默认的jdbcDriver
    private static final String mySqlDriverClassName = "com.mysql.jdbc.Driver";

    public static DriverManagerDataSource getDataSource(String driverClassName, String url,
                                                        String dbUsername, String dbPassword) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if(StringUtils.isBlank(driverClassName)){
            dataSource.setDriverClassName(mySqlDriverClassName);
        }else{
            dataSource.setDriverClassName(driverClassName);
        }
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

}
