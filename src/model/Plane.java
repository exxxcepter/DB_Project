package model;

public class Plane {
    public Plane() {
    }

    public Plane(long id, long companyId, long typeId) {
        this.id = id;
        this.companyId = companyId;
        this.typeId = typeId;
    }

    long id;
    long companyId;
    long typeId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getTypeId() {
        return typeId;
    }
}
