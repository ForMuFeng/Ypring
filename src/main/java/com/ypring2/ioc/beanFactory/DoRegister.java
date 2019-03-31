package com.ypring2.ioc.beanFactory;

import com.ypring2.ioc.IocInterface.YApplicationContext;
import com.ypring2.ioc.annotation.YComponent;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.io.*;

/**
 * @program: ypring20
 * @description: 注册
 * @author: Mr.Yqy
 * @create: 2019-03-31 12:55
 **/
public class DoRegister {
    public static final String SCAN_NAME="YPackage";
    private Properties config;
    private YApplicationContext yac;

    public DoRegister(Properties config,YApplicationContext yac){
        this.config=config;
        this.yac=yac;
    }
    //获取文件信息
    public void register(){
        String packageName=config.getProperty(SCAN_NAME);
        Register(packageName);
    }
    //进行递归的文件解析，获取所有带注解的类
    private void Register(String packageName){
        try{
            String path= URLDecoder.decode(getClass().getClassLoader().getResource(packageName).toString(), "UTF-8").substring(6);
            File dir=new File(path);
            for(File file:dir.listFiles()){
                if(file.isDirectory()){
                    Register(packageName+"."+file.getName());
                }else{
                    String className=packageName+"."+file.getName().replaceAll(".class","").trim();
                    yac.newBean(createBean(className));
                }
            }

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    //通过类名获取bean的id和类的类型，返回一个Bean类型
    public static Bean createBean(String className){
        try {
            Class clazz=Class.forName(className);
            if(clazz.isAnnotationPresent(YComponent.class)){
                return new Bean(getId(clazz),clazz);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String getId(Class clazz){
        if(clazz.isAnnotationPresent(YComponent.class)){
            YComponent yComponent=(YComponent) clazz.getAnnotation(YComponent.class);
            return yComponent.value();
        }else{
            return null;
        }
    }



}
