package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ThankYouServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //String total = request.getParameter("total"); //?total=123.4
        HttpSession session = request.getSession();
        Double total = (Double)session.getAttribute("total");

        if(total == null) {//first time visitors
        
            response.sendRedirect("order.html");
            return;

        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Quark's Restaurant</h1>");
        out.println("<h2>Order your food</h2>");

        out.printf("Thank you - your order has been received. You need to pay %s euros", total);

        out.println("</body></html>");
        out.close();
    }
}
