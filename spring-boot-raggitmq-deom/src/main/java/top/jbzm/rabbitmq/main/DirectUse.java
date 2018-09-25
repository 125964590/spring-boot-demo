package top.jbzm.rabbitmq.main;

import com.rabbitmq.client.*;
import top.jbzm.rabbitmq.config.ConnectionFactoryUtil;

import java.io.IOException;

/**
 * @author zhengyi
 * @date 2018/8/7 5:21 PM
 **/
public class DirectUse {
    public static void main(String args[]) throws Exception {

//        BaseUse.Publisher();
        DeadLetterUse.publish();
        rejectMessage();

    }

    public static void Consumer() throws Exception {
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = conn.createChannel();
        // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
        channel.queueDeclare("lol", false, false, false, null);
        Consumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 消息正文
                String message = new String(body, "utf-8");
                System.out.println("收到消息 => " + message);
                // 手动确认消息【参数说明：参数一：该消息的index；参数二：是否批量应答，true批量确认小于当前id的消息】
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume("lol", false, "", defaultConsumer);
    }

    public static void rejectMessage() throws Exception {
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        Channel channel = conn.createChannel();
        channel.queueDeclare("lol", false, false, false, null);
        GetResponse resp = channel.basicGet("lol", false);
        String message = new String(resp.getBody(), "UTF-8");
        System.out.println(message);
        //消息拒绝
        channel.basicReject(resp.getEnvelope().getDeliveryTag(), true);
    }
}