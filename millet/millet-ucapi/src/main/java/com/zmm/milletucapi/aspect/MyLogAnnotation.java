package com.zmm.milletucapi.aspect;

import java.lang.annotation.*;

/**
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/9/22
 * @apiNote 自定义注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MyLogAnnotation {



}
