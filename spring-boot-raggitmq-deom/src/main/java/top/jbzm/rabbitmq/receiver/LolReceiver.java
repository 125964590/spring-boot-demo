package top.jbzm.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author jbzm
 * @date Create on 2018/3/19 15:35
 */
@Component
public class LolReceiver {
    @RabbitListener(queues = "lol")
    public void lolOnMessage(String lol) {
        System.out.println("Receiver : " + lol);
    }
}
