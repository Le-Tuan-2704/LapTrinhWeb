package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Book;
import com.models.BookDAO;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/")
public class BookController extends HttpServlet {
	private BookDAO bookDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
            switch (action) {
                
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                case "/search":
                    searchBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//userDao.deleteUser(id); 
	}
	private void searchBook (HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        String name = request.getParameter("name");
		        List<Book> searchBook = bookDAO.searchBookByName(name);
		        request.setAttribute("listBook", searchBook);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		        dispatcher.forward(request, response);
		    }
	private void updateBook(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String publisher = request.getParameter("publisher");
		        int price = Integer.parseInt(request.getParameter("price")); 

		        Book book = new Book(id, name, publisher, price);
		        //bookDAO.updateBook(book);
		        response.sendRedirect("list");
		    }
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Book existingBook = bookDAO.getBookFromID(id); // 
		        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-book-form.jsp");
		        request.setAttribute("book", existingBook);
		        dispatcher.forward(request, response);

		    }
	private void listBook (HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Book> listBook = bookDAO.selectAllBook();
		        request.setAttribute("listBook", listBook);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		        dispatcher.forward(request, response);
		    }

}
