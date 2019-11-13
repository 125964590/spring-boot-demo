package top.zhengyiwoaini.apollo.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jbzm
 * @date 2019-09-25 11:24
 */
@EnableApolloConfig
@SpringBootApplication
public class ApolloDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(ApolloDemoApplication.class, args);
  }
}
