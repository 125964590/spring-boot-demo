package top.jbzm.annotationtest.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author jbzm
 * @date 2019-11-13 11:25
 */
@Component
public class PropertiesConfig {

  @Bean("userTest")
  @ConfigurationProperties("spring.lol")
  public User test(DataSource dataSource) {
    System.out.println(dataSource.toString());
    return new User();
  }

  @Data
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  class User {
    private String username;
    private String paasword;
    private String email;
  }
}
