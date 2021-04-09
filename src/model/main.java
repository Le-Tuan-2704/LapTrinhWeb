package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import model.*;



public class main {

	// test
    
	public static void main(String[] args) {
		Books book = new Books();
//		book.setId(2);
//		book.setName("Van Hoc");
//		book.setPublisher("abc");
//		book.setPrice(10);
//		book.updateBook(book);
		
		User user = new User();
		user.setName("test123");
		user.setPassword("test13");
		System.out.println(user.seachUser(user));
		
		List<Books> listBooks = book.getListBooks();
		
		for(Books checkBook: listBooks ) {
			System.out.println(checkBook);
		}
		
	}

}
