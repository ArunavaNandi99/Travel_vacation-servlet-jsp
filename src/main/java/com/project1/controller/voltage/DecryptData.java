package com.project1.controller.voltage;

import com.project1.service.VoltageService;
import com.project1.service.VoltageServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/decrypt")
public class DecryptData extends HttpServlet {

    VoltageService voltageService = new VoltageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phoneNumber = request.getParameter("phoneNumber");

        HttpSession session = request.getSession();


        try {
            String decrypt = decrypt(phoneNumber);
            //change after deploy voltage
            Long fakeData = Long.parseLong(decrypt) * 2 + 10 - 2 + 6;

            session.setAttribute("data", fakeData);

            response.sendRedirect("/project1/showData");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/showData");
//            dispatcher.forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    private String decrypt(String PhoneNumber) throws Exception {
        String[] phoneNumberList = new String[1];
        phoneNumberList[0] = PhoneNumber;
        return voltageService.fetchData(phoneNumberList);
    }
}
