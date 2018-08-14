package model;

public class Airport {
    public Airport() {
    }

    public Airport(long id, String airport, String city, int terminals) {
        this.id = id;
        this.airport = airport;
        this.city = city;
        this.terminals = terminals;
    }

    long id;
    String airport;
    String city;
    int terminals;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }
}
