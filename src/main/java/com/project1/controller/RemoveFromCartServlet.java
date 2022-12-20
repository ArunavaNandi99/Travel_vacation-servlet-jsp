package com.project1.controller;

import java.io.IOException;
import java.io.Serial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.DAO.CartDao;
import com.project1.db.DBConnection;
import com.project1.entity.Cart;

@WebServlet("/removeFormCart")
public class RemoveFromCartServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Cart cart = new Cart();
		cart.setCid(Integer.parseInt(id));

		CartDao dao = new CartDao(DBConnection.getConnection());
		dao.removeItem(cart);

		response.sendRedirect("/project1/cart");
	}

}
