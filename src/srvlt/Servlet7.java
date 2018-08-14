package srvlt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Страница добавления записи в AIRPORTS
 */
public class Servlet7 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1251";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Servlet1</title></head>");
            out.println("<body>");
            out.println("<form action='companies' method='post'>" +
                        "<table>" +
                        "<tr><th style='width: 12px;'><th style='width: 12px;'></tr>" +
                        "<tr><td><input type='hidden' value='0' name='id'/></td></tr>" +
                        "<tr><td><label for='airport'>Airport</label></td><td><input type='text' name='airport'/></td></tr>" +
                        "<tr><td><label for='city'>City</label></td><td><input type='text' name='city'/></td></tr>" +
                        "<tr><td><label for='terminal'>Terminal</label></td><td><input type='text' name='terminal'/></tr>" +
                        "</table>" +
                        "<input type='submit'/>" +
                        "</form>");
            out.println("</body></html>");
            out.close();
    }
}
