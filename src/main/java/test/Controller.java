package test;

import com.ypring2.ioc.ApplicationContext.AnnotationYApplicationContext;
import com.ypring2.ioc.annotation.YComponent;
import com.ypring2.ioc.annotation.YResource;

/**
 * @program: ypring20
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-03-31 18:18
 **/
@YComponent("controller")
public class Controller {
    @YResource("service")
    Service service;

    @YResource("service1")
    Service1 service1;

    public void say(){
        System.out.println("先进行了Controller的say");
        service.say();
        service1.say();
    }

    public static void main(String[] args) {
        AnnotationYApplicationContext yApplicationContext=new AnnotationYApplicationContext("applicationContext.properties");
        Controller controller=yApplicationContext.getBean("controller",Controller.class);
        controller.say();

    }
}
