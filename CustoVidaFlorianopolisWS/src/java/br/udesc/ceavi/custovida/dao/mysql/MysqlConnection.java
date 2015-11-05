package br.udesc.ceavi.custovida.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class MysqlConnection {

    private static final String URL = "jdbc:mysql://bsi.ceavi.udesc.br:3306/custodevida";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "custodevida";
    private static final String PASSWORD = "custodevida";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;

    }

}
