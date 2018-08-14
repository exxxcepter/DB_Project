package srvlt;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import db.*;

public class AppStartupListener implements ServletContextListener {
    public AppStartupListener() {}

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String pass = "db_password";
        DbProcessor db = new DbProcessor(url, user, pass);
        servletContext.setAttribute("model", db);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DbProcessor db = (DbProcessor)sce.getServletContext().getAttribute("model");
        db.closeConnection();
        sce.getServletContext().removeAttribute("model");
    }
}