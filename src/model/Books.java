package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.MysqlConnection;

public class Books {
	private int id;
	private String name;
	private String publisher;
	private int price;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	
	
	public Books() {
		super();
		this.id = 0;
		this.name = "";
		this.publisher = "";
		this.price = 0;
	}


	public List<Books> getListBooks() {
		List<Books> listGetBook = new ArrayList<>();
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select * from books";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				listGetBook.add(book);
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
		return listGetBook;
	}
	
	
	public Books(int id, String name, String publisher, int price) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}


	public List<Books> searchBooks(String name) {
		List<Books> listSearchBook = new ArrayList<>();
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select * from books" + " where name = " + "'" + name + "'";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Books book= new Books();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				listSearchBook.add(book);
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
		return listSearchBook;
	}
	
	public void updateBook( Books newBook) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = " update " + " Books" + " set "
					+ " id = ?, "
					+ " name = ?, "
					+ " publisher = ?, "
					+ " price = ? "
					+ " where id = " + newBook.getId();
		
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preStatement.setInt(1, newBook.getId());
			preStatement.setString(2, newBook.getName());
			preStatement.setString(3, newBook.getPublisher());
			preStatement.setInt(4, newBook.getPrice());
			
			
			preStatement.executeUpdate();
			
			preStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook( Books newBook) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = "delete from " + "Books"
					+ " where id = " + newBook.getId();
			java.sql.PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preparedStatement.execute();
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
