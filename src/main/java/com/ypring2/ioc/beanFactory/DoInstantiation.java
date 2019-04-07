package com.ypring2.ioc.beanFactory;

import com.ypring2.ioc.IocInterface.YApplicationContext;

import java.util.List;

/**
 * @program: ypring20
 * @description: 实现注入
 * @author: Mr.Yqy
 * @create: 2019-03-31 12:56
 **/
public class DoInstantiation {
    private YApplicationContext register;
    public DoInstantiation(YApplicationContext register){
        this.register=register;
    }
    public void creat(List<Bean> beans){
        for(Bean bdf:beans){
            doCreate(bdf);
        }
    }

    private  void doCreate(Bean bd){
        Object instance=bd.getInstance();
        this.register.newInstance(bd.getId(),instance);
    }
}
