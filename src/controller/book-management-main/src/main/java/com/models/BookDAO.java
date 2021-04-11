package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/db_27?useSSL=false";
    private String jdbcUsername = "test123";
    private String jdbcPassword = "test123";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public List<Book> selectAllBook(){
    	return;
    }
    
    public Book getBookFromID(int id) {
    	return;
    }
    public List<Book> searchBookByName(String name){
    	///
    	//r
    	return;
    }
    private static final String INSERT_BOOK = "INSERT INTO book" + "  (id, name, publisher, price) VALUES " +
            " (?, ?, ?, ?);";

        private static final String SELECT_BOOK_BY_ID = "select id,name,email,country from users where id =?";
        private static final String SELECT_ALL_BOOK = "select * from book";
        private static final String DELETE_BOOK_SQL = "delete from users where id = ?;";
        private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
        
}
