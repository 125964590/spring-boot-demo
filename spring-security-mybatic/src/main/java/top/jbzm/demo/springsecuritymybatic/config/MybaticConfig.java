package top.jbzm.demo.springsecuritymybatic.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author jbzm
 * @date 2018下午2:17
 **/
@Configuration
@MapperScan(basePackages = "top.jbzm.demo.springsecuritymybatic.mapper")
public class MybaticConfig {

}
