package com.project1.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project1.DAO.VacationDAO;
import com.project1.db.DBConnection;
import com.project1.entity.Vacation;


@WebServlet("/vacationServlet")
@MultipartConfig(
				location ="G:\\Images",
				fileSizeThreshold =1024*1024, //1MB
				maxFileSize = 1024*1024*10, //10MB
				maxRequestSize = 1024*1024*10 //11MB
			)
public class vacationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hname = request.getParameter("hname");
		String description = request.getParameter("description");
		String type = request.getParameter("type");
		String city = request.getParameter("city");
		String numberOfDays = request.getParameter("numberofdays");
		String price = request.getParameter("price");
		String validTill = request.getParameter("validTill");
		String SoldOut = request.getParameter("soldout");
		String image = request.getParameter("image");



//    	Part file = request.getPart("image");
//		String imageFileName = file.getSubmittedFileName();
//		System.out.println("select imageFile name" + imageFileName);
//
//		String uploadPath = "G:/OFFICE PROJECT/Travel_vacation-servlet-jsp/src/main/webapp/images/" + imageFileName;
//		System.out.println(uploadPath);
//
//		try {
//			FileOutputStream fos = new FileOutputStream(uploadPath);
//			InputStream is = file.getInputStream();
//
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			fos.write(data);
//			fos.close();
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		{

			Vacation vacation = new Vacation();

			vacation.setHname(hname);
			vacation.setDescription(description);
			vacation.setType(type);
			vacation.setCity(city);
			vacation.setNumberofdays(numberOfDays);
			vacation.setPrice(price);
			vacation.setValidTill(validTill);
			vacation.setSoldout(SoldOut);
			vacation.setImage(image);

			VacationDAO vacationDao = new VacationDAO(DBConnection.getConnection());
			boolean f = vacationDao.addVacation(vacation);

			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("vacation", "Added Successfully");
				response.sendRedirect("Vacation.jsp");
			}

		}

	}
}
