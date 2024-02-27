package org.example.component.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

    /**
     * Create connection to database
     * @return Connection
     * @throws SQLException
     */
    Connection getDBConnection() throws SQLException;
}
