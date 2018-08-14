package srvlt;

import db.*;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet5 extends HttpServlet {
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
            List<Ticket> ticketList = new LinkedList<Ticket>();
            ticketList = db.getTicket();
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
                    "<tr><th>Ticket ID</th><th style='width:120px;'>Name</th><th style='width:100px;'>Last name</th><th style='width:100px;'>FLight ID</th><th style='width:100px;'>Price</th></tr>");
            for (Ticket t : ticketList) {
                out.println(String.format("<tr><td style='text-align:center;'>%s</td><td style='text-align:center;'>%s</td><td style='text-align:center;'>%s</td><td style='text-align:center;'>%d</td><td style='text-align:center;'>%d</td></tr>", t.getTicketId(), t.getName(), t.getLastName(), t.getFlight(), t.getPrice()));
            }
            out.println("</table></body></html>");
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
