package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

/**
 * Servlet implementation class EmployeeServelt
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private UserDao userDao;

	    public void init() {
	        userDao = new UserDao();
	    }
	    
	    public UserServlet() {
	    	super();
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
             response.getWriter().append("Served at: ").append(request.getContextPath());
             
             RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/userregister.jsp");
             dispatcher.forward(request, response);
	      }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String contact = request.getParameter("contact");

	        User employee = new User();
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setEmail(email);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);

	        try {
	            userDao.registerEmployee(employee);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/userdetails.jsp");
            dispatcher.forward(request, response);
	    }
}
