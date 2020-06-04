package by.epam.committiee.entity;


public class Address implements Entity{
    private long id;
    private String locality;
    private String street;
    private String building;
    private String flat;
    private String zipCode;
    private long enrolleeId;

    public Address() {
    }

    public Address(long id, String locality, String street, String building, String flat, String zipCode, long enrolleeId) {
        this.id = id;
        this.locality = locality;
        this.street = street;
        this.building = building;
        this.flat = flat;
        this.zipCode = zipCode;
        this.enrolleeId = enrolleeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(long enrolleeId) {
        this.enrolleeId = enrolleeId;
    }
}
