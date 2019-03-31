package test;

import com.ypring2.ioc.ApplicationContext.AnnotationYApplicationContext;
import com.ypring2.ioc.annotation.YAutowired;
import com.ypring2.ioc.annotation.YComponent;

/**
 * @program: ypring20
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-03-31 18:18
 **/
@YComponent("controller")
public class Controller {
    @YAutowired("service")
    Service service;

    public void say(){
        System.out.println("先进行了Controller的say");
        service.say();
    }

    public static void main(String[] args) {
        AnnotationYApplicationContext yApplicationContext=new AnnotationYApplicationContext("applicationContext.properties");
        Controller controller=yApplicationContext.getBean("controller",Controller.class);
        controller.say();

    }
}
