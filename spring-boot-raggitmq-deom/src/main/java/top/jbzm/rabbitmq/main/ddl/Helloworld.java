package top.jbzm.rabbitmq.main.ddl;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.ExchangeTypes;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @author jbzm
 * @date 2019-04-26 14:39
 */
public class Helloworld {
    private static Channel channel;
    private static final String EXCHANGE_NAME = "ddl-base";
    private static final String EXCHANGE_NAME_DLX = "dlx";
    private static final String DLX_QUEUE = "dlx.queue";

    static {
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.TOPIC);
            channel.exchangeDeclare(EXCHANGE_NAME_DLX, ExchangeTypes.TOPIC);
            channel.queueDeclare(DLX_QUEUE, true, false, false, null);
            channel.queueBind(DLX_QUEUE, EXCHANGE_NAME_DLX, "#");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void declareQueue(String queueName, int priority, String routingKey) {
        try {
            Map<String, Object> args = new HashMap<>(16);
            args.put("x-max-priority", priority);
            args.put("x-dead-letter-exchange", EXCHANGE_NAME_DLX);
            channel.queueDeclare(queueName, false, false, false, args);
            channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void producter(String message, String routingKey, int delayTime) {
        AMQP.BasicProperties.Builder basicProperties = new AMQP.BasicProperties.Builder();
        Connection connection = ConnectionFactoryUtil.GetRabbitConnection();
        try {
            Channel channel = connection.createChannel();
            basicProperties.expiration(delayTime * 1000 + "");
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
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(queueName + ":" + message);
                        System.out.println(System.currentTimeMillis());
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

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        declareQueue("low-direct", 5, "top.jbzm.#");
        Random random = new Random();
        executorService.execute(
                () ->
                        Stream.generate(() -> random.nextInt(100) + 1)
                                .limit(20)
                                .parallel()
                                .forEach(
                                        x ->
                                                producter(
                                                        "I'm delay " + x + " seconds !!!!",
                                                        "top.jbzm.high",
                                                        x)));
        executorService.execute(
                () ->
                        Stream.generate(() -> random.nextInt(100) + 1)
                                .limit(20)
                                .parallel()
                                .forEach(
                                        x ->
                                                producter(
                                                        "I'm delay " + x + " seconds !!!!",
                                                        "top.jbzm.high",
                                                        x)));
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
        consumer(DLX_QUEUE);
    }
}
