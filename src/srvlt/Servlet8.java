package srvlt;

import db.DbProcessor;
import model.Airport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Редактирование и удаление (_передача_ на удаление) записи в AIRPORTS
 */
public class Servlet8 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        PrintWriter out = response.getWriter();
        Long airportId = Long.valueOf(request.getParameter("id"));
        Airport airport = db.findAirport(airportId);
        request.setAttribute("airport", airport);
        getServletContext().getRequestDispatcher("/editAirport.jsp").forward(request,response);
    }
}
