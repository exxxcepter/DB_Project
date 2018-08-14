package srvlt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Silence on 24.12.13.
 */
public class Servlet11 extends HttpServlet {
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
                "<tr><td><label for='name'>Name</label></td><td><input type='text' name='name'/></td></tr>" +
                "<tr><td><label for='owner'>Owner</label></td><td><input type='text' name='owner'/></td></tr>" +
                "<tr><td><label for='country'>Country</label></td><td><input type='text' name='country'/></td></tr>" +
                "<tr><td><label for='planesQuantity'>Planes quantity</label></td><td><input type='text' name='planesQuantity'/></tr>" +
                "</table>" +
                "<input type='submit'/>" +
                "</form>");
        out.println("</body></html>");
        out.close();
    }
}
