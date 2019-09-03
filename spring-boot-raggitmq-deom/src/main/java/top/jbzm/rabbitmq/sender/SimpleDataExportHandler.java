package top.jbzm.rabbitmq.sender;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

import static top.jbzm.rabbitmq.sender.RabbitMqConstant.DATA_PROCESS_EXCHANGE;

/**
 * @author jbzm
 * @date 2019-05-15 16:43
 */
@Component
public class SimpleDataExportHandler extends AbstractDataProcessHandler {

    private final RabbitTemplate rabbitTemplate;

    private final Jackson2JsonMessageConverter jackson2JsonMessageConverter;

    public SimpleDataExportHandler(RabbitTemplate rabbitTemplate, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.jackson2JsonMessageConverter = jackson2JsonMessageConverter;
    }

    @Override
    void execute(DataProcessEvent dataProcessEvent) {

        rabbitTemplate.send(
                DATA_PROCESS_EXCHANGE,
                "data.process.export",
                jackson2JsonMessageConverter.toMessage(dataProcessEvent, new MessageProperties()));
    }
}
