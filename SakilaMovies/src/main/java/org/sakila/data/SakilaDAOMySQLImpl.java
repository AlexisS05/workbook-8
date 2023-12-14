package org.sakila.data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SakilaDAOMySQLImpl {
    private DataSource dataSource;
    private Connection connection;

    public SakilaDAOMySQLImpl(DataSource dataSource){
        this.dataSource = dataSource;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
