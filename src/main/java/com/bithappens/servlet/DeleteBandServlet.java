package com.bithappens.servlet;

import com.bithappens.repository.BandRepository;
import com.bithappens.repository.JdbcBandRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/band")
public class DeleteBandServlet extends HttpServlet {

    BandRepository bandRepository = new JdbcBandRepository();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToDelete = req.getParameter("id");
        bandRepository.deleteById(Integer.valueOf(idToDelete));
    }
}
