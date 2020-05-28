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
import java.util.List;

@WebServlet("/genre")
public class GenreServlet extends HttpServlet {

    BandRepository bandRepository = new JdbcBandRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("genre");
        List<Band> bandsByGenre = bandRepository.bandByGenre(s);
        req.setAttribute("genre", bandsByGenre);
        req.getRequestDispatcher("byGenre.jsp").forward(req, resp);
    }
}
