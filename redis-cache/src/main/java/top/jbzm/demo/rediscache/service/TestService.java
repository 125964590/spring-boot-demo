package top.jbzm.demo.rediscache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.jbzm.demo.rediscache.pojo.TestPojo;

/**
 * @author zhengyi
 * @date 2018/7/26 5:50 PM
 **/
@Service
public class TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value = "5-seconds", keyGenerator = "keyGenerator")
    public String getTestData01() {
        return "5-seconds" + Math.random();
    }

    @Cacheable(value = "10000-seconds", keyGenerator = "keyGenerator")
    public String getTestData02() {
        return "10000-seconds" + Math.random();
    }

    @Cacheable(value = "test", keyGenerator = "keyGenerator")
    public TestPojo lol() {
        TestPojo testPojo = new TestPojo();
        testPojo.setId(1);
        testPojo.setName("jbzm");
        testPojo.setTimestamp(System.currentTimeMillis());
        return testPojo;
    }
}