package test;

import com.ypring2.ioc.annotation.YComponent;

/**
 * @program: ypring20
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-03-31 19:39
 **/
@YComponent("service1")
public class Service1 {
    public void say(){
        System.out.println("这里是Service1");
    }
}
