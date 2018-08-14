package model;

public class Company {
    public Company() {
    }

    public Company(long id, String name, String owner, String country, int planesQuantity) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.country = country;
        this.planesQuantity = planesQuantity;
    }

    long id;
    String name;
    String owner;
    String country;
    int planesQuantity;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPlanesQuantity(int planesQuantity) {
        this.planesQuantity = planesQuantity;
    }

    public int getPlanesQuantity() {
        return planesQuantity;
    }
}
