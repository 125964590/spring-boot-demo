package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.*;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;

/**
 * @author zhengyi
 * @date 2018/8/7 5:58 PM
 **/
public class FunOutUse {
    static final String ExchangeName = "fanoutec";

    public static void main(String[] args) throws Exception {
        provide();
        provide();
        consumer();
    }

    public static void provide() throws Exception {
        // 交换器名称
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = conn.createChannel();
        // 声明fanout交换器
        channel.exchangeDeclare(ExchangeName, "fanout");
        String message = "时间：" + System.currentTimeMillis();
        channel.basicPublish(ExchangeName, "", null, message.getBytes("UTF-8"));
    }

    public static void consumer() throws Exception {
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = conn.createChannel();
        // 声明fanout交换器
        // 声明队列  random get queue name
        String queueName = channel.queueDeclare().getQueue();
        channel.exchangeDeclare(ExchangeName, "fanout");
        channel.queueBind(queueName, ExchangeName, "");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}