package test;

import com.ypring2.ioc.annotation.YComponent;

/**
 * @program: ypring20
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-03-31 18:18
 **/
@YComponent("233")
public class Service {
    public void say(){
        System.out.println("这里是service");
    }
}
