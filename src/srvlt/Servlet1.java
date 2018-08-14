package srvlt;

import db.*;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1251";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /*
     * Вывод денных из таблицы AIRPORTS
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        try {
            DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
            List<Airport> airportList = new LinkedList<Airport>();
            airportList = db.getAirports();
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
                    "<tr><th>Airport</th><th style='width:120px;'>City</th><th style='width:100px;'>Terminals</th><th style='width:100px;'></th></tr>");
            for (Airport air : airportList) {
                out.println(String.format("<tr><td style='text-align:center;'>%s</td><td style='text-align:center;'>%s</td><td style='text-align:center;'>%d</td><td style='text-align:center;'><a href='editAirport?id=" + air.getId() + "'>Редактировать</a></td></tr>", air.getAirport(), air.getCity(), air.getTerminals()));
            }
            out.println("</table><br><a href='addAirport'>Добавить</a></body></html>");
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Прием данных для создания записи в AIRPORTS
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long id = Long.valueOf(request.getParameter("id"));
        String airport = request.getParameter("airport");
        String city = request.getParameter("city");
        int terminal = Integer.valueOf(request.getParameter("terminal"));
        DbProcessor db = (DbProcessor)this.getServletContext().getAttribute("model");
        db.saveAirport(new Airport(id, airport, city, terminal));
        doGet(request, response);
    }
}
