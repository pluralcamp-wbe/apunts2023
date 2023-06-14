package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.pluralcamp.data.MenuDataService;
import com.pluralcamp.domain.MenuItem;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {
    public void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><body><h1>Quark's Restaurant</h1>");

        out.println("<h2>Order your food</h2>");
        out.println("<form action='orderReceived.html' method='POST'>");
        out.println("<ul>");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();

        for (MenuItem menuItem : menuItems) {
            out.println("<li>" + menuItem.toString() + "<input type='text' name='item_"
                    + menuItem.getId() + "'/></li>");
        }

        out.println("</ul>");
        out.println("<input type='submit'/>");
        out.println("</form></body></html>");
        out.close();
    }
}
