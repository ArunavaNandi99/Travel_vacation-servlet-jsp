package com.project1.controller;

import java.io.IOException;
import java.io.Serial;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			session.removeAttribute("userDetails");

			HttpSession session2 = request.getSession();
			session2.setAttribute("logoutMsg", "Logout Successfully");

			response.sendRedirect("/project1/login");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
