package srvlt;

import db.DbProcessor;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import model.Airport;
import model.Company;

public class Servlet2 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1251";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        try {
            DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
            List<Company> companyList = new LinkedList<Company>();
            companyList = db.getCompany();
            out.println("<html>");
            out.println("<head><title>Servlet2</title></head>");
            out.println("<body>");
            out.println("<div style='border:1px solid green; background-color:yellow;'>");
            out.println("<a href='airports'>Airports</a>");
            out.println("<a href='companies'>Companies</a>");
            out.println("<a href='flights'>Flights</a>");
            out.println("<a href='planes'>Planes</a>");
            out.println("<a href='tickets'>Tickets</a>");
            out.println("<a href='types'>Types</a>");
            out.println("</div>");
            out.println("<table>" +
                    "<tr><th>Name</th><th style='width:120px;'>Owner</th><th style='width:120px;'>Country</th><th style='width:100px;'>Planes quantity</th><th style='width:100px;'></th></tr>");
            for (Company comp : companyList) {
                out.println(String.format("<tr><td style='text-align:center;'>%s</td><td style='text-align:center;'>%s</td><td style='text-align:center;'>%s</td><td style='text-align:center;'>%d</td><td style='text-align:center;'><a href='editCompany?id=" + comp.getId() + "'>Редактировать</a></td></tr>", comp.getName(), comp.getOwner(), comp.getCountry(), comp.getPlanesQuantity()));
            }
            out.println("</table><br><a href='addCompany'>Добавить</a></body></html>");
            out.println("</body></html>");
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String country = request.getParameter("country");
        int planesQuantity = Integer.valueOf(request.getParameter("planesQuantity"));
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        db.saveCompany(new Company(id, name, owner, country, planesQuantity));
        doGet(request, response);
    }
}
