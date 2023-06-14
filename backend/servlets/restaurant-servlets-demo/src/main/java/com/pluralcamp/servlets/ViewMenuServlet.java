package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.pluralcamp.data.MenuDataService;
import com.pluralcamp.domain.MenuItem;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewMenuServlet extends HttpServlet {
    public void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();

        out.println("<html><body><h1>Quark's Restaurant</h1>");
        out.println("<h2>Menu</h2><ul>");

        for (MenuItem menuItem : menuItems) {
            out.printf("<li>%s</li>%n", menuItem);
        }
        out.println("</ul>");
        out.println("<p><a href='searchResults.html?searchTerm=chicken'>" + 
        "View all our chicken dishes</a></p>");
        out.println("<p><a href='order.html'>Make an order here</a></p>");
        out.println("</body></html>");
        out.close();
    }
}
