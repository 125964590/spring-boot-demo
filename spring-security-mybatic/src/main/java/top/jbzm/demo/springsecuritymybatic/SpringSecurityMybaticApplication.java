package top.jbzm.demo.springsecuritymybatic;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jbzm.common.ErrorResult;
import top.jbzm.exception.MyException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jbzm
 * @date Create on 2018/3/9 17:36
 */
@SpringBootApplication
@RestController
public class SpringSecurityMybaticApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(
                SpringSecurityMybaticApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("datasource is :" + dataSource);
        //检查数据库是否是hikar数据库连接池
        if (!(dataSource instanceof HikariDataSource)) {
            System.err.println(" Wrong datasource type :"
                    + dataSource.getClass().getCanonicalName());
            System.exit(-1);
        }
        try {
            Connection connection = dataSource.getConnection();
            ResultSet rs = connection.createStatement()
                    .executeQuery("SELECT 1");
            if (rs.first()) {

                System.out.println("Connection OK!");
            } else {
                System.out.println("Something is wrong");
            }
            // connection.close();
            // System.exit(0);

        } catch (SQLException e) {
            System.out.println("FAILED");
            e.printStackTrace();
            System.exit(-2);
            // TODO: handle exception
        }
    }
    @GetMapping("test01")
    public void test01(){
        throw new MyException(ErrorResult.create(111,"lol"));
    }
    @GetMapping("test02")
    public void test02() throws Exception {
        throw new Exception("lll");
    }


}
