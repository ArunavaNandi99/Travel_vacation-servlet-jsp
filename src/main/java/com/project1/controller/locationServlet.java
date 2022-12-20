package com.project1.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.DAO.VacationDAO;
import com.project1.db.DBConnection;
import com.project1.entity.Vacation;

@WebServlet("/locationServlet")
public class locationServlet extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("city");

		HttpSession session = request.getSession();

		if ((!(city.equals(null) || city.equals("")))) {

			Vacation vacation = new Vacation();
			vacation.setCity(city);

			VacationDAO dao = new VacationDAO(DBConnection.getConnection());
			List<Vacation> vs = dao.searchLocation(vacation);

			if (vs != null) {
				request.setAttribute("list", vs);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listOfVacation.jsp");
				dispatcher.forward(request, response);

			} 
		} else {
			session.setAttribute("valid", "Please Enter Valid City");

			response.sendRedirect("/project1/welcome");
		}

	}

}
