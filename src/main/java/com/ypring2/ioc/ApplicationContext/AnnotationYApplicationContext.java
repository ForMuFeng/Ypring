package com.ypring2.ioc.ApplicationContext;

import com.ypring2.ioc.IocInterface.YApplicationContext;
import com.ypring2.ioc.beanFactory.Bean;
import com.ypring2.ioc.beanFactory.DoInstantiation;
import com.ypring2.ioc.beanFactory.DoRegister;
import com.ypring2.ioc.beanFactory.DoPopulate;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: ypring20
 * @description: 核心功能实现
 * @author: Mr.Yqy
 * @create: 2019-03-31 12:38
 **/
public class AnnotationYApplicationContext implements YApplicationContext {
    private  static Map<String,Object> IocBeans=new ConcurrentHashMap<String, Object>();
    private  static List<Bean> beans=new ArrayList<Bean>();
    Properties config=new Properties();
    public AnnotationYApplicationContext(String configFileName){
        try{
            //获取配置文件
            config.load(getApplication(configFileName));
            //注册
            register();
            //实例化
            instantiation();
            //注入
            populate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //通过id获取bean
    public Object getBean(String id) {
        return IocBeans.get(id);
    }
    //通过id和类型获取bean
    public <T> T getBean(String id, Class<T> tClass) {
        return (T)IocBeans.get(id);
    }
    public InputStream getApplication(String file) {
        return this.getClass().getClassLoader().getResourceAsStream(file);
    }

    //注册
    public void register() {
        DoRegister doRegister=new DoRegister(config,this);
        doRegister.register();
    }

    public void instantiation() {
        DoInstantiation doInstantiation=new DoInstantiation(this);
        doInstantiation.creat(beans);
    }

    public void populate() {
        DoPopulate populate=new DoPopulate();
        populate.doIoc(IocBeans);
    }

    public void newBean(Bean bean) {
        beans.add(bean);
    }

    public void newInstance(String id, Object o) {
          IocBeans.put(id,o);
    }
}
