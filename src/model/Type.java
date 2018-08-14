package model;

public class Type {
    public Type() {
    }

    public Type(long id, String planeType, int crew) {
        this.id = id;
        this.planeType = planeType;
        this.crew = crew;
    }

    long id;
    String planeType;
    int crew;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getCrew() {
        return crew;
    }
}
