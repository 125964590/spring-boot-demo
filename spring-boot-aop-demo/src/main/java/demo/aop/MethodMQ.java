package demo.aop;

import java.lang.annotation.*;
/**
 * @author jbzm
 * @date Create on 2018/3/15 23:39
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodMQ {
    /**
     * 记录操作描述
     */
    String description() default "";

    /**
     * 增删改的数据的类型
     */
    Class<?> clazz();
}