package top.jbzm.rabbitmq.sender;

/**
 * @author jbzm
 * @date 2019-05-15 21:15
 */
public class RabbitMqConstant {
    public static final String DATA_EXPORT_QUEUE = "data_export_queue";
    public static final String DATA_PROCESS_EXCHANGE = "data_process_exchange";
    public static final String DATA_EXPORT_ROUTING_KEY = "data.process.export.#";
}
