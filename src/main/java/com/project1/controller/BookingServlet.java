//package com.project1.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.project1.DAO.VacationDAO;
//import com.project1.db.DBConnection;
//import com.project1.entity.Cart;
//
//import com.project1.entity.Vacation;
//
//@WebServlet("/BookingServlet")
//public class BookingServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static List<Cart> listShopping = new ArrayList<>();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		try {
//
//			int id = Integer.parseInt(request.getParameter("id")) ;
//
//			Vacation vacation = new Vacation();
//			vacation.setId(id);
//
//			VacationDAO dao = new VacationDAO(DBConnection.getConnection());
//			Vacation vs = dao.searchVacation(vacation);
//
//			HttpSession session = request.getSession();
//
//			if (vs != null) {
//				Cart shoppingCart = new Cart(vs.getId(),vs.getHname(), vs.getDescription(), vs.getType(), vs.getCity(),
//						vs.getPrice());
//
//				listShopping.add(shoppingCart);
//
//				session.setAttribute("cartList", listShopping);
//				
//				
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
//				dispatcher.forward(request, response);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
