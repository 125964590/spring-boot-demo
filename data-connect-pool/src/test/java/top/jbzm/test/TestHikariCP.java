package top.jbzm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.config.HikariCPConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhengyi
 * @date 2018/10/15 5:01 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHikariCP {
    @Autowired
    HikariCPConfig hikariCPConfig;

    /**
     * test HikariCp multiple datasource
     */
    @Test
    public void test01() throws SQLException {
        Statement statement_21 = hikariCPConfig.getConnection_21().createStatement();
        Statement statement_210 = hikariCPConfig.getConnection_210().createStatement();
        String sql_21 = "select * from test.data_connect_pool";
        String sql_210 = "select * from db_zy_test.data_connect_pool";
        ResultSet resultSet_21 = statement_21.executeQuery(sql_21);
        while (resultSet_21.next()) {
            System.out.println(resultSet_21.getInt(1));
        }
        ResultSet resultSet_210 = statement_210.executeQuery(sql_210);
        while (resultSet_210.next()) {
            System.out.println(resultSet_210.getInt(1));
        }
    }
}