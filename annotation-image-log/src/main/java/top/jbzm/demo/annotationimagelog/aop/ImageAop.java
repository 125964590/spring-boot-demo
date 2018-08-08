package top.jbzm.demo.annotationimagelog.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author jbzm
 * @date 201811:39 AM
 **/
@Aspect
@Component
@Slf4j
public class ImageAop {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * define a section for @Image
     */
    @Pointcut("@annotation(top.jbzm.demo.annotationimagelog.aop.LogToolNB)")
    private void cut() {
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        try {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            log.info("request url:" + request.getRequestURL());
            log.info("request method" + joinPoint.getSignature().getDeclaringTypeName());
            log.info("request parameter:" + Arrays.toString(joinPoint.getArgs()));
            startTime.set(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterReturning("cut() && @annotation(logToolNB)")
    public void afterReturn(LogToolNB logToolNB) {
        logToolNB.logType();
        switch (logToolNB.logType()) {
            case "web":
                log.info("this is web");
                break;
            case "rabbitmq":
                log.info("this is rabbitmq");
            default:
        }
        log.info("run time :" + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(value = "cut() && @annotation(logToolNB)", throwing = "e")
    public void afterThrowing(Exception e, LogToolNB logToolNB) {
        log.error("error information:" + e.toString() + "\n" + "from:" + logToolNB.logType());
    }

}