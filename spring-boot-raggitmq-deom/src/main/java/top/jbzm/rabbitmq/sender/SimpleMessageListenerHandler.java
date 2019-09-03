package top.jbzm.rabbitmq.sender;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static top.jbzm.rabbitmq.sender.RabbitMqConstant.DATA_EXPORT_QUEUE;

@Configuration
public class SimpleMessageListenerHandler {

    private final ConnectionFactory connectionFactory;
    private final AmqpAdmin amqpAdmin;

    @Autowired
    public SimpleMessageListenerHandler(ConnectionFactory connectionFactory, AmqpAdmin amqpAdmin) {
        this.connectionFactory = connectionFactory;
        this.amqpAdmin = amqpAdmin;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(
            @Autowired DataProcessMessageListener mqMessageListener) {
        SimpleMessageListenerContainer simpleMessageListenerContainer =
                new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setQueueNames(DATA_EXPORT_QUEUE);
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setConcurrentConsumers(5);
        simpleMessageListenerContainer.setMessageListener(mqMessageListener);
        if (amqpAdmin instanceof RabbitAdmin) {
            simpleMessageListenerContainer.setRabbitAdmin((RabbitAdmin) amqpAdmin);
        }
        return simpleMessageListenerContainer;
    }
}
