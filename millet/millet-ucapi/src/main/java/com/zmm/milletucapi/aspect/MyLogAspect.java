package com.zmm.milletucapi.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/9/22
 * @apiNote 日志切面类
 */
@Component
@Aspect
@Slf4j
public class MyLogAspect {

    @Pointcut("@annotation(com.zmm.milletucapi.aspect.MyLogAnnotation)")
    public void methodAspect() {
    }

    @Before("methodAspect()")
    public void printLog(JoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("切了！！！！！");
        //目标对象
        Class<?> clazz = joinPoint.getTarget().getClass();
        //方法签名
        String method = joinPoint.getSignature().getName();
        //方法参数
        Object[] thisArgs = joinPoint.getArgs();
        //参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        //方法
        Method thisMethod = clazz.getMethod(method, parameterTypes);

        System.out.println(method);
        System.out.println(thisArgs);
    }

}
