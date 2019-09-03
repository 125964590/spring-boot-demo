package top.jbzm.rabbitmq.sender;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jbzm
 * @date 2019-05-15 20:16
 */
@Slf4j
@Component
public class DataProcessMessageListener implements ChannelAwareMessageListener {

    @Autowired private Jackson2JsonMessageConverter jackson2JsonMessageConverter;

    @Override
    public void onMessage(Message message, Channel channel) {
        try {
            DataProcessEvent myEvent =
                    (DataProcessEvent) jackson2JsonMessageConverter.fromMessage(message);
            System.out.println(myEvent);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }
}
