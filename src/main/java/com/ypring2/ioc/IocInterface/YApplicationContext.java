package com.ypring2.ioc.IocInterface;
import com.ypring2.ioc.beanFactory.Bean;

import java.io.*;

public interface YApplicationContext {
    //获取配置文件
    InputStream getApplication(String file);
    //注册
    void register();
    //实例化
    void instantiation();
    //注入
    void populate();

    void newBean(Bean bean);

    void newInstance(String id,Object object);


}
