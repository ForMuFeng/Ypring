package com.ypring2.ioc.beanFactory;


import com.ypring2.ioc.annotation.YAutowired;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @program: ypring20
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-03-31 18:16
 **/
public class DoPopulate {
    public DoPopulate() {
    }

    //通过实现Resource注解来实现IOC
    public void doIoc(Map<String,Object> instanceMapping){
        //Field 提供有关类的信息，以及对它的动态访问权限。
        if(instanceMapping.isEmpty()){
            return;
        }
        for(Map.Entry<String,Object> entry:instanceMapping.entrySet()){
            //获取map中所有的bean
            Field[] fields=entry.getValue().getClass().getDeclaredFields();
            for(Field field:fields){
                //判断类里是否存在YResource注解,如果没有则结束本次循环
                if(!field.isAnnotationPresent(YAutowired.class)){
                    continue;
                }
                //field.getAnnotation返回指定类型的元素的注释,如果不存在则返回null
                YAutowired yAutowired=field.getAnnotation(YAutowired.class);
                String id=yAutowired.value();
                //如果id是空，则按照类型进行注入
                if("".equals(id)){
                    id=field.getType().getName();
                }
                //如果field中有private类型的变量，field访问对象会产生IllegalAccessException异常,设为true之后才能获取访问权限
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(),instanceMapping.get(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
