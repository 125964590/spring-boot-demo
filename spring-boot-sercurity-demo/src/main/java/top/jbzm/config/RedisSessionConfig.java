package top.jbzm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author jbzm
 * @date Create on 2018/3/9 0:17
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {


}