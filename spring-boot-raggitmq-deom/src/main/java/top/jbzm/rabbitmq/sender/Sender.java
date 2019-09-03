package top.jbzm.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.function.Consumer;

/** @Author jbzm @Date Create on 2018/3/18 0:55 */
@RestController
public class Sender {

    @Autowired private AmqpTemplate rabbitTemplate;
    public String lol = "lolL";

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    public static <T extends ApplicationEvent> void test(
            Class<T> tClass, Object source, Consumer<T> tConsumer)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
                    InstantiationException {
        Constructor<T> constructor = tClass.getConstructor(Object.class);
        T t = constructor.newInstance(source);
        tConsumer.accept(t);
        System.out.println(t);
    }

    @Autowired private ApplicationPublisher myPublisher;

    @GetMapping("/test-mq01")
    public void test01() {
        DataProcessEvent dataProcessEvent = new DataProcessEvent(this);
        dataProcessEvent.setTaskId("jbzm-nb");
        myPublisher.publishAsync(dataProcessEvent);
    }
}
