package Componentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMYSQL {

    private Connection conn;
    private String bd = "mrysiEscuelas";
    private String host = "localhost";
    private String port = "3306";

    public ConexionMYSQL() {
        conn = null;
    }

    private boolean setDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() throws SQLException {
        if (setDriver()) {
            String URL = "jdbc:mysql://" + host + ":" + port + "/" + bd;
            conn = DriverManager.getConnection(URL, "lania", "admin");
        }
        return conn;
    }
}
