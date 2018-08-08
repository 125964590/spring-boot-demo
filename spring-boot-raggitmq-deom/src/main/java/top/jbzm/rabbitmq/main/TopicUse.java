package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.*;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author zhengyi
 * @date 2018/8/8 11:23 AM
 **/
public class TopicUse {
    static final String ExchangeName = "topic";

    public static void main(String[] args) throws Exception {
        publish();
    }

    public static void publish() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(ExchangeName, "topic");
        String time = "时间" + System.currentTimeMillis();
        channel.basicPublish(ExchangeName, "jbzm.mq.topic.test", null, time.getBytes("UTF-8"));
        channel.close();
        connection.close();
    }

    public static void consumer() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        String runtingKey = "jbzm.mq.topic.test";
        String queue = "base_test";
        channel.queueDeclare(queue, false, false, false, null);
        channel.queueBind(queue, ExchangeName, runtingKey);
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                String str = new String(body, "UTF-8");
                System.out.println(str);
            }
        });
    }

}