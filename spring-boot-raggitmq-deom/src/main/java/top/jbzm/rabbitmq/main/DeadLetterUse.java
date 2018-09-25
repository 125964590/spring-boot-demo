package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.*;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhengyi
 * @date 2018/8/8 3:36 PM
 **/
public class DeadLetterUse {

    public static void main(String[] args) throws Exception {
        publish();
    }

    public static void publish() throws Exception {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topic", "topic");
        channel.exchangeDeclare("dead.exchange", "topic");
        //declare dead letter queue parameter
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("x-dead-letter-exchange", "dead.exchange");
        args.put("x-message-ttl", 6000);
        args.put("x-dead-letter-routing-key", "queue.dlx.test");
        channel.queueDeclare("test-queue", false, false, false, args);
        channel.queueDeclare("dead-letter", false, false, false, null);
        channel.queueBind("test-queue", "topic", "test.#");
        channel.queueBind("dead-letter", "dead.exchange", "queue.dlx.*");
        String newTime = System.currentTimeMillis() + "";
        channel.basicPublish("topic", "test.dead.letter", null, newTime.getBytes());
    }

    public static void consumer() throws Exception {
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = conn.createChannel();
        // 声明队列  random get queue name
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println(message + "~~~" + deliveryTag);
            }
        };
        channel.basicConsume("test-queue", true, consumer);
    }
}