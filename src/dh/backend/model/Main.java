package dh.backend.model;

import dh.backend.db.H2Connection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static Logger LOGGER = Logger.getLogger(Main.class);

    public static String SQL_CREATE = "DROP TABLE IF EXIST CUENTAS;"+
            "CREATE TABLE CUENTAS(ID INT AUTO_INCREMENT PRIMARY KEY, NROCUENTA INT NOT NULL,"+
            "NOMBRE VARCHAR(50) NOT NULL, SALDO NUMERIC(7,2) NOT NULL,)";

    public static void main(String[] args) {

        Connection connection = null;
        Cuenta cuenta  = new Cuenta();

        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
