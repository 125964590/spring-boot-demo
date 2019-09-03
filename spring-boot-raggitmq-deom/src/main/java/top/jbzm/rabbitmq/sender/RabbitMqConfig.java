package top.jbzm.rabbitmq.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static top.jbzm.rabbitmq.sender.RabbitMqConstant.*;

/**
 * @author jbzm
 * @date 2019-05-15 21:15
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue exportEventQueue() {
        return new Queue(DATA_EXPORT_QUEUE);
    }

    @Bean
    public Exchange dataProcessExchange() {
        return ExchangeBuilder.topicExchange(DATA_PROCESS_EXCHANGE).build();
    }

    @Bean
    public Binding bindExportEventQueueToDataProcessExchangeQueue(
            Queue exportEventQueue, Exchange dataProcessExchange) {
        return BindingBuilder.bind(exportEventQueue)
                .to(dataProcessExchange)
                .with(DATA_EXPORT_ROUTING_KEY)
                .noargs();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(
            @Autowired ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
