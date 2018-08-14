package srvlt;

import db.DbProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * _Непосредственное_ удаление записи из AIRPORTS
 */
public class Servlet9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("id"));
        db.deleteAirport(id);
        response.sendRedirect("airports");
    }
}
