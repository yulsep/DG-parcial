package dh.backend.db;

import java.sql.Connection;
import java.sql.SQLException;

public class H2Connection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");

        return null;
    }
}
