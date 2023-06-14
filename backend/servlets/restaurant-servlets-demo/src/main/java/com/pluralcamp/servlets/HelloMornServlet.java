package com.pluralcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloMornServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("<html style='background-color: black; color: white'><body>");
                out.println("<h1>Hello Morn!</h1>");
                out.println("<p>The time in Deep Space 9 is " + new Date() + "</p>");
                out.println("</body></html>");
                out.close();
    }
}
