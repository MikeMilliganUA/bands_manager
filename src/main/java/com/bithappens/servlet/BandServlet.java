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

@WebServlet("/band")
public class BandServlet extends HttpServlet {

    BandRepository bandRepository = new JdbcBandRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Band band = bandRepository.findById(Integer.valueOf(id));
        req.setAttribute("band", band);
        req.getRequestDispatcher("bandPage.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToDelete = req.getParameter("id");
        bandRepository.deleteById(Integer.valueOf(idToDelete));
    }
}
