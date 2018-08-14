package db;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import model.Airport;
import model.Company;
import model.Flight;
import model.Plane;
import model.Ticket;
import model.Type;

public class DbProcessor {
    Connection conn;

    public DbProcessor(String url, String user, String password) {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public long saveAirport (Airport a) {
        try {
            PreparedStatement prep;
            if (a.getId() > 0) {
                prep = conn.prepareStatement("UPDATE AIRPORTS SET AIRPORT = ?, CITY = ?, TERMINALS = ? WHERE ID = ?");
                prep.setString(1, a.getAirport());
                prep.setString(2, a.getCity());
                prep.setInt(3, a.getTerminals());
                prep.setLong(4, a.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO AIRPORTS(ID, AIRPORT, CITY, TERMINALS) VALUES (IDGEN.NEXTVAL,?,?,?)");
                prep.setString(1, a.getAirport());
                prep.setString(2, a.getCity());
                prep.setInt(3, a.getTerminals());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return a.getId();
    }

    public void deleteAirport (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM AIRPORTS WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Airport findAirport (long id) {
        Airport a = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM AIRPORTS WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                a = new Airport(rs.getLong("ID"), rs.getString("AIRPORT"), rs.getString("CITY"), rs.getInt("TERMINALS"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public List<Airport> getAirports () {
        List<Airport> airportList = new LinkedList<Airport>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM AIRPORTS ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                airportList.add(new Airport(rs.getLong("ID"), rs.getString("AIRPORT"), rs.getString("CITY"), rs.getInt("TERMINALS")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return airportList;
    }

    public long saveCompany (Company c) {
        try {
            PreparedStatement prep;
            if (c.getId() > 0) {
                prep = conn.prepareStatement("UPDATE COMPANIES SET NAME = ?, OWNER = ?, COUNTRY = ?, PLANES_QUANTITY = ? WHERE ID = ?");
                prep.setString(1, c.getName());
                prep.setString(2, c.getOwner());
                prep.setString(3, c.getCountry());
                prep.setInt(4, c.getPlanesQuantity());
                prep.setLong(5, c.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO COMPANIES(ID, NAME, OWNER, COUNTRY, PLANES_QUANTITY) VALUES (IDGEN.NEXTVAL,?,?,?,?)");
                prep.setString(1, c.getName());
                prep.setString(2, c.getOwner());
                prep.setString(3, c.getCountry());
                prep.setInt(4, c.getPlanesQuantity());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c.getId();
    }

    public void deleteCompany (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM COMPANIES WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Company findCompany (long id) {
        Company c = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM COMPANIES WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                c = new Company(rs.getLong("ID"), rs.getString("NAME"), rs.getString("OWNER"), rs.getString("COUNTRY"), rs.getInt("PLANES_QUANTITY"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<Company> getCompany () {
        List<Company> companyList = new LinkedList<Company>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM COMPANIES ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                companyList.add(new Company(rs.getLong("ID"), rs.getString("NAME"), rs.getString("OWNER"), rs.getString("COUNTRY"), rs.getInt("PLANES_QUANTITY")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }

    public long saveFlight (Flight f) {
        try {
            PreparedStatement prep;
            if (f.getId() > 0) {
                prep = conn.prepareStatement("UPDATE FLIGHTS SET AIRPORT_DEPT = ?, DEPT_ID = ?, AIRPORT_DEST = ?, DEST_ID = ?, PLANE_ID = ?, FLIGHT_DATE = ? WHERE ID = ?");
                prep.setString(1, f.getAirportDept());
                prep.setLong(2, f.getDeptId());
                prep.setString(3, f.getAirportsDest());
                prep.setLong(4, f.getDestId());
                prep.setLong(5, f.getPlaneId());
                prep.setDate(6, f.getFlightDate());
                prep.setLong(7, f.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO FLIGHTS(ID, AIRPORT_DEPT, DEPT_ID, AIRPORT_DEST, DEST_ID, PLANE_ID, FLIGHT_DATE) VALUES (IDGEN.NEXTVAL,?,?,?,?,?,?)");
                prep.setString(1, f.getAirportDept());
                prep.setLong(2, f.getDeptId());
                prep.setString(3, f.getAirportsDest());
                prep.setLong(4, f.getDestId());
                prep.setLong(5, f.getPlaneId());
                prep.setDate(6, f.getFlightDate());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f.getId();
    }

    public void deleteFlight (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM FLIGHTS WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Flight findFlight (long id) {
        Flight f = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM FLIGHTS WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                f = new Flight(rs.getLong("ID"), rs.getString("AIRPORT_DEPT"), rs.getInt("DEPT_ID"), rs.getString("AIRPORT_DEST"), rs.getInt("DEST_ID"), rs.getInt("PLANE_ID"), rs.getDate("FLIGHT_DATE"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Flight> getFlight () {
        List<Flight> flightList = new LinkedList<Flight>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM FLIGHTS ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                flightList.add(new Flight(rs.getLong("ID"), rs.getString("AIRPORT_DEPT"), rs.getLong("DEPT_ID"), rs.getString("AIRPORT_DEST"), rs.getLong("DEST_ID"), rs.getLong("PLANE_ID"), rs.getDate("FLIGHT_DATE")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public long savePlane (Plane p) {
        try {
            PreparedStatement prep;
            if (p.getId() > 0) {
                prep = conn.prepareStatement("UPDATE PLANES SET COMPANY_ID = ?, TYPE_ID = ? WHERE ID = ?");
                prep.setLong(1, p.getCompanyId());
                prep.setLong(2, p.getTypeId());
                prep.setLong(3, p.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO PLANES(ID, COMPANY_ID, TYPE_ID) VALUES (IDGEN.NEXTVAL,?,?)");
                prep.setLong(1, p.getCompanyId());
                prep.setLong(2, p.getTypeId());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return p.getId();
    }

    public void deletePlane (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM PLANES WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Plane findPlane (long id) {
        Plane p = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM PLANES WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                p = new Plane(rs.getLong("ID"), rs.getInt("COMPANY_ID"), rs.getInt("TYPE_ID"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public List<Plane> getPlane () {
        List<Plane> planeList = new LinkedList<Plane>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM PLANES ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                planeList.add(new Plane(rs.getLong("ID"), rs.getLong("COMPANY_ID"), rs.getLong("TYPE_ID")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public long saveTicket (Ticket t) {
        try {
            PreparedStatement prep;
            if (t.getId() > 0) {
                prep = conn.prepareStatement("UPDATE TICKET SET TICKET_ID = ?, NAME = ?, LAST_NAME = ?, FLIGHT = ?, PRICE = ? WHERE ID = ?");
                prep.setString(1, t.getTicketId());
                prep.setString(2, t.getName());
                prep.setString(3, t.getLastName());
                prep.setLong(4, t.getFlight());
                prep.setInt(5, t.getPrice());
                prep.setLong(6, t.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO TICKET(ID, TICKET_ID, NAME, LAST_NAME, FLIGHT, PRICE) VALUES (IDGEN.NEXTVAL,?,?,?,?,?)");
                prep.setString(1, t.getTicketId());
                prep.setString(2, t.getName());
                prep.setString(3, t.getLastName());
                prep.setLong(4, t.getFlight());
                prep.setInt(5, t.getPrice());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return t.getId();
    }

    public void deleteTicket (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM TICKET WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Ticket findTicket (long id) {
        Ticket t = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM TICKET WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                t = new Ticket(rs.getLong("ID"), rs.getString("TICKET_ID"),  rs.getString("NAME"),  rs.getString("LAST_NAME"), rs.getLong("FLIGHT"), rs.getInt("PRICE"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<Ticket> getTicket () {
        List<Ticket> ticketList = new LinkedList<Ticket>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM TICKET ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                ticketList.add(new Ticket(rs.getLong("ID"), rs.getString("TICKET_ID"),  rs.getString("NAME"),  rs.getString("LAST_NAME"), rs.getLong("FLIGHT"), rs.getInt("PRICE")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    public long saveType (Type t) {
        try {
            PreparedStatement prep;
            if (t.getId() > 0) {
                prep = conn.prepareStatement("UPDATE TYPES SET PLANE_TYPE = ?, CREW = ? WHERE ID = ?");
                prep.setString(1, t.getPlaneType());
                prep.setInt(2, t.getCrew());
                prep.setLong(3, t.getId());
                prep.executeUpdate();
            }
            else {
                prep = conn.prepareStatement("INSERT INTO TYPES(ID, PLANE_TYPE, CREW) VALUES (IDGEN.NEXTVAL,?,?)");
                prep.setString(1, t.getPlaneType());
                prep.setInt(2, t.getCrew());
                prep.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return t.getId();
    }

    public void deleteType (long id){
        try {
            PreparedStatement prep = conn.prepareStatement("DELETE FROM TYPES WHERE ID = ?");
            prep.setLong(1, id);
            prep.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Type findType (long id) {
        Type t = null;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM TYPES WHERE ID = ?");
            prep.setLong(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                t = new Type(rs.getLong("ID"), rs.getString("PLANE_TYPE"), rs.getInt("CREW"));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<Type> getType () {
        List<Type> typeList = new LinkedList<Type>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM TYPES ORDER BY ID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                typeList.add(new Type(rs.getLong("ID"), rs.getString("PLANE_TYPE"), rs.getInt("CREW")));
            }
            rs.close();
            prep.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typeList;
    }

    public List<Long> getTableIds (String tableName) {
        List<Long> list = new LinkedList<Long>();
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT ID FROM " + tableName);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                list.add(rs.getLong("ID"));
            }
        }
        catch (Exception e) {}
        return list;
    }

    public List<Object> getValues (int param) {
        List<Object> list = new LinkedList<Object>();
        try {
            if (param == 1) {
                PreparedStatement prep = conn.prepareStatement("SELECT ID FROM FLIGHTS");
                ResultSet rs = prep.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("ID"));
                }
            }
            else if (param == 2) {
                PreparedStatement prep = conn.prepareStatement("SELECT ID, AIRPORT FROM AIRPORTS");
                ResultSet rs = prep.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("ID") + '/' + rs.getString("AIRPORT"));
                    //list.add(rs.getString("ID"));
                }
            }
            else if (param == 3) {
                PreparedStatement prep = conn.prepareStatement("SELECT ID FROM PLANES");
                ResultSet rs = prep.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("ID"));
                }
            }
            else if (param == 4) {
                PreparedStatement prep = conn.prepareStatement("SELECT ID, NAME FROM COMPANIES");
                ResultSet rs = prep.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("ID") + '/' + rs.getString("NAME"));
                    //list.add(rs.getString("ID"));
                }
            }
            else if (param == 5) {
                PreparedStatement prep = conn.prepareStatement("SELECT ID, PLANE_TYPE FROM TYPES");
                ResultSet rs = prep.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("ID") + '/' + rs.getString("PLANE_TYPE"));
                    //list.add(rs.getString("ID"));
                }
            }
        }
        catch (Exception e) {}
        return list;
    }
}
