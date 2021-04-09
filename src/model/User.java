package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class User {
	private String name;
	private String password;
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean seachUser(User user) {
		boolean check = false;
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = " select username from user " + " where username = " 
			+ "'" + user.name + "' and"
			+" password = " +"'" + user.password +"'";
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
			
			stmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public User() {
		super();
	}
	
	
}
