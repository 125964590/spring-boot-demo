package top.jbzm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jbzm.controller.TestController;

/**
 * @author zhengyi
 * @date 2018/10/15 9:04 PM
 **/
public class SpringApplicationBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringApplicationBeanTest.class);
        TestController controll = (TestController) annotationConfigApplicationContext.getBean("testService");
    }
}