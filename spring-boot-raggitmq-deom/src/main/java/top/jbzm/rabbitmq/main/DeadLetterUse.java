package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhengyi
 * @date 2018/8/8 3:36 PM
 **/
public class DeadLetterUse {

    public static void publish() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("dead0-test-exchange", "direct");
        //declare dead letter queue parameter
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("x-dead-letter-exchange", "some.exchange.name");
        channel.queueDeclare("dead-letter", false, false, false, args);

    }
}