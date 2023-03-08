package com.github.jj.springbootlearn.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MysqlAdminTest {
    private Connection connection;
    private MysqlAdmin mysqlAdmin;

    @BeforeEach
    public void init() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:13306/local", "root", "123456");
        mysqlAdmin = new MysqlAdmin(connection);
    }

    @Test
    public void testGetPrimaryKeys() throws SQLException {
        System.out.println(mysqlAdmin.getPrimaryKeys("test"));
    }

}