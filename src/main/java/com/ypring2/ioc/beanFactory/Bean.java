package com.ypring2.ioc.beanFactory;

/**
 * @program: ypring20
 * @description: Bean的po类
 * @author: Mr.Yqy
 * @create: 2019-03-31 12:36
 **/
public class Bean {
    private String id;
    private Class clazz;

    public Bean(String id, Class clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }


    //获取实例（使用时要强制转化类型）
    public Object getInstance(){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
