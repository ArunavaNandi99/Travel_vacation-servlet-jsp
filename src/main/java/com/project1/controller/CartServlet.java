package com.project1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project1.DAO.CartDao;
import com.project1.DAO.VacationDAO;
import com.project1.db.DBConnection;
import com.project1.entity.Cart;
import com.project1.entity.Vacation;

@WebServlet("/addToCart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int vid = Integer.parseInt(request.getParameter("vid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			
			Vacation vacation = new Vacation();
			vacation.setId(vid);

			VacationDAO dao = new VacationDAO(DBConnection.getConnection());
			Vacation vac = dao.searchVacation(vacation);

			Cart c = new Cart();
			c.setVid(vid);
			c.setUid(uid);
			c.setHname(vac.getHname());
			c.setDescription(vac.getDescription());
			c.setType(vac.getType());
			c.setCity(vac.getCity());
			c.setPrice(vac.getPrice());
			c.setTotalPrice(Integer.parseInt(vac.getPrice()));

			CartDao dao2 = new CartDao(DBConnection.getConnection());
			boolean f = dao2.addCart(c);
			
			if(f) {
				System.out.println("Add Cart sucess");
				response.sendRedirect("/project1/cart");
			}else {
				System.out.println("not added to cart");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
