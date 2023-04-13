package com.flyaway;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class PasswordChangeServlet
 */


import java.sql.SQLException;


import com.database.Dao;
@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			Dao dao=new Dao();
			HttpSession session=request.getSession();
			if(dao.changeAdminPassword(email,password)) {
				session.setAttribute("message", "Password Changed Successfully");
			}
			else {
				session.setAttribute("message", "Invalid Credentials!, Please input valid information");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AdminLoginPage.jsp");
		
	}

}