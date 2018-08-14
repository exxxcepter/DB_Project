package srvlt;

import db.*;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet4 extends HttpServlet {
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
            List<Plane> planeList = new LinkedList<Plane>();
            planeList = db.getPlane();
            out.println("<html>");
            out.println("<head><title>Servlet1</title></head>");
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
                    "<tr><th>Company ID</th><th style='width:120px;'>Type ID</th></tr>");
            for (Plane pl : planeList) {
                out.println(String.format("<tr><td style='text-align:center;'>%d</td><td style='text-align:center;'>%d</td></tr>", pl.getCompanyId(), pl.getTypeId()));
            }
            out.println("</table></body></html>");
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
