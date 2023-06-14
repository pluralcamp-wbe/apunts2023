package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.util.digester.SystemPropertySource;

import com.pluralcamp.data.MenuDataService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderReceivedServlet extends HttpServlet {

    MenuDataService menuDataService = new MenuDataService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int maxId = menuDataService.getFullMenu().size();

        for (int i = 0; i < maxId; i++) {
            String quantity = request.getParameter("item_" + i);
            try {
                int q = 0;
                if (quantity != null && !quantity.trim().equals(""))
                    q = Integer.parseInt(quantity);
                if (q > 0) {
                    System.out.printf("You have ordered %d items of %s%n", q, menuDataService.getItem(i));
                    menuDataService.addToOrder(menuDataService.getItem(i), q);
                }
            } catch (NumberFormatException nfe) {
                // that's fine it just means there wasn't a valid order for this item
                System.err.println("Error: please enter an integer number");
            }
        }

        System.out.println("-----> A new order has been received <-----");

        Double total = menuDataService.getOrderTotal();

        HttpSession session = request.getSession();
        session.setAttribute("total", total);

        response.sendRedirect("thankYou.html");
        // response.sendRedirect("thankYou.html?total=" + total);//is sending a 302

        // PrintWriter out = response.getWriter();
        // response.setContentType("text/html");
        // out.println("<html><body><h1>Quark's Restaurant</h1>");
        // out.println("<h2>Order your food</h2>");

        // out.printf("Thank you - your order has been received. You need to pay %.2f euros", total);

        // out.println("</body></html>");
        // out.close();  
        // vscode: Ctrl+k Ctrl-c (comment) or Ctrl+k Ctrl+u (uncomment)

    }
}
