package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {

    @Autowired //自动装配
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }

    /**
     * HikariProxyConnection@1153329578 wrapping com.mysql.cj.jdbc.ConnectionImpl@7219ac49
     * 有这个输出
     * 数据库连接池
     * jdbc: dbcp
     * c3p0 淘汰
     * hikari 最快的连接池 底层还是c3p0管理连接对象
     * @throws SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
