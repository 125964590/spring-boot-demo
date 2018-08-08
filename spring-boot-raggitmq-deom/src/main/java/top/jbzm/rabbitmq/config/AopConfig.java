package top.jbzm.rabbitmq.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jbzm.rabbitmq.sender.Sender;

/**
 * @author jbzm
 * @date Create on 2018/3/19 14:44
 */
@Aspect
@Component
public class AopConfig {
    private final Sender sender;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AopConfig(Sender sender, RabbitTemplate rabbitTemplate) {
        this.sender = sender;
        this.rabbitTemplate = rabbitTemplate;
    }

    @AfterReturning(returning = "ret", pointcut = "execution(public * top.jbzm.rabbitmq.controller.AopTest.test01(..))")
    public void after(String ret) {
        System.out.println(ret);
        rabbitTemplate.convertAndSend("lol",ret);
    }

}
