package top.jbzm.cloud.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jbzm
 * @date 2018下午5:36
 **/
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class Oauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

    @GetMapping("lol")
    public String test(){
        return "lol";
    }
}
