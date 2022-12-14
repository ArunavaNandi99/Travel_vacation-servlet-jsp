package com.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.DAO.UserDAO;
import com.project1.db.DBConnection;
import com.project1.entity.User;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserDAO dao = new  UserDAO(DBConnection.getConnection());
		User us = dao.login(user);
		
		HttpSession session = request.getSession();
		
		if(us != null) {			
			session.setAttribute("userDetails", us);
			session.setMaxInactiveInterval(10 * 60);
			session.setAttribute("user", username);
			
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/welcome");
			dispatcher.forward(request, response);
		}else {
			session.setAttribute("loginFailed", "invalid username and password");
			
			response.sendRedirect("/project1/login");
			
		}
	}

}
