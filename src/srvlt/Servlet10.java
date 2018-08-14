package srvlt;

import db.DbProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Silence on 24.12.13.
 */
public class Servlet10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("id"));
        db.deleteCompany(id);
        response.sendRedirect("companies");
    }
}
