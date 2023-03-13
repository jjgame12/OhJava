package com.github.jj.springbootlearn.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jj
 */
public class MysqlAdmin {
    private Connection connection;

    public MysqlAdmin(Connection connection) {
        this.connection = connection;
    }

    /**
     * 获取主键
     */
    public List<String> getPrimaryKeys(String tableName) throws SQLException {
        DatabaseMetaData metaData = getMetaData();
        ResultSet primaryKeys = metaData.getPrimaryKeys(null, "%", tableName);
        return traverseResultSet(primaryKeys);
    }

    private List<String> traverseResultSet(ResultSet primaryKeys) throws SQLException {
        List<String> keys = new ArrayList<>();
        while (primaryKeys.next()) {
            keys.add(primaryKeys.getString("COLUMN_NAME"));
        }
        return keys;
    }

    private DatabaseMetaData getMetaData() {
        try {
            return connection.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
