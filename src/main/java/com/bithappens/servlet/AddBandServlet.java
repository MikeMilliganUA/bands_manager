package com.bithappens.servlet;

import com.bithappens.entity.Band;
import com.bithappens.repository.BandRepository;
import com.bithappens.repository.JdbcBandRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Add")
public class AddBandServlet extends HttpServlet {

    BandRepository bandRepository = new JdbcBandRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String genre = req.getParameter("genre");
        Integer year = Integer.valueOf(req.getParameter("year"));

        bandRepository.addNewBand(name, country, genre, year);

        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        /*printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>New band info</h1>");
        printWriter.print("<p> Name :: " + name + "</p>");
        printWriter.print("<p> Country :: " + country + "</p>");
        printWriter.print("<p> Genre :: " + genre + "</p>");
        printWriter.print("<p> Year :: " + year + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");*/

        printWriter.close();
    }
}
