package top.jbzm.demo;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengyi
 * @date 2018/9/7 5:37 PM
 **/
public class mainlol {
    public static void main(String[] args) {
        //这一段完全可以做声工具类或者单例实现
        // http://base.dianxiaohuocy.net/api 为接口地址
        UserService userService = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(UserService.class, "http://localhost:11195/uc");

        AuthServer authServer = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(AuthServer.class, "http://localhost:11195/uc");
        LoginRequest build = LoginRequest.builder().username("jbzm").password("jbzm").build();
        ResponseData login = authServer.login(build);
        System.out.println(login.toString());
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.100.20", 6489));
        nodes.add(new HostAndPort("192.168.100.20", 6689));
        nodes.add(new HostAndPort("192.168.100.20", 6589));
        JedisCluster cluster = new JedisCluster(nodes);
        String s = cluster.get(login.getData().toString());
        System.out.println(s);
//         以下是真正通过Feign调用接口的方法
//        ResponseData str = userService.getUser(1L);
//        UserInfo build = UserInfo.builder().name("jbzm").password("jbzm").username("jbzm").phone(123423134L).build();
//        build.setId(40L);
//        ResponseData responseData = userService.saveUser(build);

//        System.out.println(responseData.toString());
    }
}