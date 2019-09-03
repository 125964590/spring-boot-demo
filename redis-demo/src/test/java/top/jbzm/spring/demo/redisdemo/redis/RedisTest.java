package top.jbzm.spring.demo.redisdemo.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import top.jbzm.spring.demo.redisdemo.RedisDemoApplicationTests;

/**
 * @author jbzm
 * @date 2019-05-10 14:18
 **/
public class RedisTest extends RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        redisTemplate.opsForValue().set("jbzm","jbzm-nb");
        System.out.println(redisTemplate.opsForValue().get("jbzm"));
    }
}