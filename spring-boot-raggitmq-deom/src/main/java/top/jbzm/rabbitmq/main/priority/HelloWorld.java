package top.jbzm.rabbitmq.main.priority;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ExchangeTypes;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author jbzm
 * @date 2019-04-23 18:06
 */
public class HelloWorld {

    private static Channel channel;
    private static final String EXCHANGE_NAME = "priority-direct";

    static {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.TOPIC);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void declareQueue(String queueName, int priority, String routingKey) {
        try {
            Map<String, Object> args = new HashMap<>(16);
            args.put("x-max-priority", priority);
            channel.queueDeclare(queueName, false, false, false, args);
            channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void producter(String message, String routingKey, int priority) {
        AMQP.BasicProperties.Builder basicProperties = new AMQP.BasicProperties.Builder();
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        try {
            Channel channel = connection.createChannel();
            basicProperties.priority(priority);
            channel.basicPublish(
                    EXCHANGE_NAME,
                    routingKey,
                    basicProperties.build(),
                    message.getBytes(StandardCharsets.UTF_8));
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void consumer(String queueName) {
        Consumer defaultConsumer =
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag,
                            Envelope envelope,
                            AMQP.BasicProperties properties,
                            byte[] body)
                            throws IOException {
                        String message = new String(body);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(queueName + ":" + message);
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                };
        try {
            channel.basicQos(1);
            channel.basicConsume(queueName, false, defaultConsumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        declareQueue("high-direct", 20, "top.jbzm");
        declareQueue("middle-direct", 10, "top.jbzm");
        declareQueue("low-direct", 5, "top.jbzm");
        producter("I'm high 22 !!!!", "top.jbzm.high", 22);
        producter("I'm middle 18 !!!!", "top.jbzm.middle", 18);
        producter("I'm middle 15 !!!!", "top.jbzm.middle", 15);
        producter("I'm high 19 !!!!", "top.jbzm.high", 19);
        producter("I'm low 1 !!!!", "top.jbzm.low", 1);
        producter("I'm low 5 !!!!", "top.jbzm.low", 5);
        consumer("high-direct");
        consumer("middle-direct");
        consumer("low-direct");
        declareQueue("direct", 10, "");
        consumer("direct1");
    }

    @Test
    void test01() {
        producter("I'm high 22 !!!!", "top.jbzm", 22);
        producter("I'm middle 18 !!!!", "top.jbzm", 18);
        producter("I'm middle 15 !!!!", "top.jbzm", 15);
        producter("I'm high 19 !!!!", "top.jbzm", 19);
        producter("I'm low 1 !!!!", "top.jbzm", 1);
        producter("I'm low 5 !!!!", "top.jbzm", 5);
    }

    @Test
    void test() {
        Stream.generate(() -> (int) (Math.random() * 20))
                .limit(20)
                .forEach(
                        x -> {
                            System.out.println(x);
                            producter("I'm" + x, "", x);
                        });
    }

    @Test
    void test03() {
        declareQueue("direct1", 20, "");
        consumer("direct");
    }
}
