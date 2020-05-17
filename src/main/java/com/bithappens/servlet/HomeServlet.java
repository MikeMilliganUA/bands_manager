package com.bithappens.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class HomeServlet extends HttpServlet {
        public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Date date = new Date();
            pw.println(date.toString());
            pw.close();
        }
}