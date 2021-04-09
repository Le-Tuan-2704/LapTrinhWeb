package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 *
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "bd_27_tuan_7";
        String userName = "root";
        String password = "";
        return getMysqlConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password) 
        throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://" + hostName + "/" + dbName;
        Connection conn = (Connection) DriverManager.getConnection(connectionUrl, userName, password);
        return conn;
    }
    
}
