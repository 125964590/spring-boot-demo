package top.jbzm.demo.annotationimagelog.aop;

import java.lang.annotation.*;

/**
 * @author jbzm
 * @date 201811:44 AM
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogToolNB {
    String logLeve() default "info";

    String logType() default "web";
}