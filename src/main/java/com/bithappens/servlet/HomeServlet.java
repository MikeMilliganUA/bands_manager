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

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    BandRepository bandRepository = new JdbcBandRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Band> allBands = bandRepository.findAll();
        req.setAttribute("allBands", allBands);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
