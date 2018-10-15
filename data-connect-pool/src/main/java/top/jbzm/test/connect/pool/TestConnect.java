package top.jbzm.test.connect.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhengyi
 * @date 2018/10/15 1:33 PM
 **/
public class TestConnect {
    /**
     * 数据库连接
     */
    private Connection connection;

    @BeforeEach
    public void createDataConnectPool() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.100.210:3307?&useSSL=false");
        config.setUsername("root");
        config.setPassword("huatu2017mysqltest1121");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        connection = ds.getConnection();
    }

    @Test
    public void getConnectTest() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select * from db_zy_test.data_connect_pool";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
    }
}