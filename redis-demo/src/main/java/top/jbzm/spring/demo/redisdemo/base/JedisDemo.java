package top.jbzm.spring.demo.redisdemo.base;

import redis.clients.jedis.Jedis;

/**
 * @author jbzm
 * @date 2019-05-20 20:20
 **/
public class JedisDemo {

    public static Jedis getConnection() {
        Jedis jedis = new Jedis("221.122.129.89", 6379);
        jedis.auth("jbzm");
        return jedis;
    }

    public static void main(String[] args) {
        getConnection().del("export_data_3e5ca795a3514831bb61e9510de03cfd");
    }
}