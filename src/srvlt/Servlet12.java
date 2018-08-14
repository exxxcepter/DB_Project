package srvlt;

import db.DbProcessor;
import model.Airport;
import model.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Silence on 24.12.13.
 */
public class Servlet12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        PrintWriter out = response.getWriter();
        Long companyId = Long.valueOf(request.getParameter("id"));
        Company company = db.findCompany(companyId);
        request.setAttribute("company", company);
        getServletContext().getRequestDispatcher("/editCompany.jsp").forward(request,response);
    }
}
