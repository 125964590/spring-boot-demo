package top.jbzm.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhengyi
 * @date 2018/10/15 3:26 PM
 **/
@Configuration
public class HikariCPConfig {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private Connection connection_210;
    private Connection connection_21;

    @Bean
    public Connection start() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.100.210:3307?&useSSL=false");
        config.setUsername("root");
        config.setPassword("huatu2017mysqltest1121");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        logger.info("210---->ok");
        return connection_210 = ds.getConnection();
    }

    public Connection getConnection_21() {
        return connection_21;
    }

    public Connection getConnection_210() {
        return connection_210;
    }

    @Bean
    public Connection createDataConnectPool() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://192.168.100.21:3306?&useSSL=false");
        config.setUsername("root");
        config.setPassword("unimob@12254ns");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        logger.info("21---->ok");
        return connection_21 = ds.getConnection();
    }
}