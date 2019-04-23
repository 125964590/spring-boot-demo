package top.jbzm.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author zhengyi
 * @date 2018/8/7 4:48 PM
 */
public class ConnectionFactoryUtil {
    public static Connection GetRabbitConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("jbzm");
        factory.setPassword("jbzm");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String args[]) throws IOException {
        Channel channel = GetRabbitConnection().createChannel();
    }
}
