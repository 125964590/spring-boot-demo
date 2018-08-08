package top.jbzm.rabbitmq.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

/**
 * @author jbzm
 * @date Create on 2018/3/19 15:35
 */
@Component
public class GalaxyReceiver {

    @Autowired
    private MessageConverter messageConverter;
    @RabbitListener(queues = "galaxy_data_check")
    public void lolOnMessage(Message message) {
        String token = (String)messageConverter.fromMessage(message);

        System.out.println("Receiver : " + token);
    }
}
