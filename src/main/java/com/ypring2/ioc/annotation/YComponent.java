package com.ypring2.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: ypring20
 * @description: YComponent注解
 * @author: Mr.Yqy
 * @create: 2019-03-31 12:33
 **/
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Target(ElementType.TYPE)//注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface YComponent {
    String value() default "";
}
