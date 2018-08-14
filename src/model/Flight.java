package model;

import java.sql.Date;

public class Flight {
    public Flight() {
    }

    public Flight(long id, String airportDept, long deptId, String airportDest, long destId, long planeId, Date flightDate) {
        this.id = id;
        this.airportDept = airportDept;
        this.airportsDest = airportDest;
        this.planeId = planeId;
        this.flightDate = flightDate;
        this.deptId = deptId;
        this.destId = destId;
    }
    long id;
    String airportDept;
    String airportsDest;
    long planeId;
    Date flightDate;
    long deptId;
    long destId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setAirportDept(String airportDept) {
        this.airportDept = airportDept;
    }

    public String getAirportDept() {
        return airportDept;
    }

    public void setAirportsDest(String airportsDest) {
        this.airportsDest = airportsDest;
    }

    public String getAirportsDest() {
        return airportsDest;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    public long getPlaneId() {
        return planeId;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDestId(long destId) {
        this.destId = destId;
    }

    public long getDestId() {
        return destId;
    }
}
