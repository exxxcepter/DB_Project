package model;

public class Ticket {
    public Ticket() {
    }

    public Ticket(long id, String ticketId, String name, String lastName, long flight, int price) {
        this.id = id;
        this.ticketId = ticketId;
        this.name = name;
        this.lastName = lastName;
        this.flight = flight;
        this.price = price;
    }

    long id;
    String ticketId;
    String name;
    String lastName;
    long flight;
    int price;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFlight(long flight) {
        this.flight = flight;
    }

    public long getFlight() {
        return flight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
