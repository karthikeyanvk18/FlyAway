package com.flyaway;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class AdminLoginServlet
 */
import java.sql.SQLException;


import com.database.Dao;



@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			Dao dao=new Dao();
			
			if(dao.checkAdmin(email,password)) {
				response.sendRedirect("AdminLandingPage.jsp");
			}
			else {
				HttpSession session=request.getSession();
				session.setAttribute("message", "Invalid Details");
				response.sendRedirect("AdminLandingPage.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}