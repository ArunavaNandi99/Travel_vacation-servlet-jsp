package com.project1.controller;

import java.io.IOException;
import java.io.Serial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.DAO.UserDAO;
import com.project1.db.DBConnection;
import com.project1.entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String username = request.getParameter("username").trim();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirmpassword = request.getParameter("confirmpassword");

			HttpSession session = request.getSession();

			if ((!(username.equals(null) || username.equals("")) && !(fname.equals(null) || fname.equals(""))
					&& (!(lname.equals(null) || lname.equals("")) && !(email.equals(null) || email.equals(""))
							&& !(password.equals(null) || password.equals(""))
							&& !(confirmpassword.equals(null) || confirmpassword.equals(""))))) {

				if (password.equals(confirmpassword)) {

					Long phone = Long.parseLong(phoneNumber);

					User user = new User();

					user.setUsername(username);
					user.setFname(fname);
					user.setLname(lname);
					user.setPhoneNumber(phone);
					user.setEmail(email);
					user.setPassword(password);

					UserDAO dao = new UserDAO(DBConnection.getConnection());
					boolean f = dao.registerUser(user);

					if (f) {
						session.setAttribute("register", "User hasbeen Register");
						response.sendRedirect("/project1/login");

					} else {
						session.setAttribute("userexist", "Username already exist");
						response.sendRedirect("/project1/register");
					}

				} else {
					session.setAttribute("password_no_match", "password and confirmpassword not match");
					response.sendRedirect("/project1/register");
				}
			} else {
				session.setAttribute("required", "All fields are required");
				response.sendRedirect("/project1/register");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}

	}

}
