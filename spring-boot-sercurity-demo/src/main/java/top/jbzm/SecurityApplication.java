package top.jbzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jbzm
 * @date Create on 2018/3/7 14:24
 */
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run( SecurityApplication.class,args);
    }
}
