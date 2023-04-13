package com.flyaway;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class RegistrationServlet
 */

import java.sql.SQLException;
import java.util.HashMap;



import com.database.Dao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		
		HashMap<String,String> user=new HashMap<>();
		user.put("email", email);
		user.put("password", password);
		user.put("name", name);
		user.put("phno", phno);
		
		try {
			Dao dao=new Dao();
			boolean result=dao.insertUser(user);
			HttpSession session=request.getSession();
			if(result) {
				session.setAttribute("message", "User Added Successfully");
			}
			else {
				session.setAttribute("message","Invalid Credentials!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("User.jsp");
	}

}