package top.jbzm.spring.demo.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@SpringBootApplication
@RestController
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @PostMapping("/jbzm/{lol}")
    public Object test(@PathParam("lol") String lol, HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURI();
    }

}
