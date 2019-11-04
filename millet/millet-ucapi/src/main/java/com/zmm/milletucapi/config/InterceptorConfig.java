package com.zmm.milletucapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/11/1
 **/
@Configuration
//@Profile({"prod","test"})  //只有测试和生产环境，拦截器才启作用
//@ConfigurationProperties(prefix = "config.path")  //读取配置文件
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private ConfigData configData;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        //另一种写法
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/stuInfo/getAllStuInfoA","/account/register");

        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
        ir.addPathPatterns(configData.getInclude());
//        ir.excludePathPatterns("/login","/js/**","/html/**","/image/**","/css/**");
        ir.excludePathPatterns(configData.getExclude());
    }



}
