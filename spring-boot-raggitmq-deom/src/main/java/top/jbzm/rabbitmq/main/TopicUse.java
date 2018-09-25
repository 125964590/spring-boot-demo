package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.*;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author zhengyi
 * @date 2018/8/8 11:23 AM
 **/
public class TopicUse {
    static final String ExchangeName = "topic";

    public static void main(String[] args) throws Exception {
        consumerRegister();
        consumerAll();
//        publishRegister();
//        publishActve();
    }

    public static void publishRegister() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(ExchangeName, "topic");
        String time = "时间" + System.currentTimeMillis() + "register";
        channel.basicPublish(ExchangeName, "jbzm.mq.topic.register", null, time.getBytes("UTF-8"));
        channel.close();
        connection.close();
    }

    public static void publishActve() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(ExchangeName, "topic");
        String time = "时间" + System.currentTimeMillis() + "active";
        channel.basicPublish(ExchangeName, "jbzm.mq.topic.active", null, time.getBytes("UTF-8"));
        channel.close();
        connection.close();
    }

    public static void consumerAll() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        String runtingKey = "jbzm.mq.topic.*";
        String queue = "base_test_all";
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

    public static void consumerRegister() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        String runtingKey = "jbzm.mq.topic.register";
        String queue = "base_test_register";
        channel.queueDeclare(queue, false, false, false, null);
        channel.queueBind(queue, ExchangeName, runtingKey);
        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String str = new String(body, "UTF-8");
                System.out.println(str);
                // ack message by hand if multiple is true will batch ack
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }

}