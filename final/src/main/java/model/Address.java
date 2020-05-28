package model;


public class Address {
    private Integer id;
    private String locality;
    private String street;
    private String building;
    private String flat;
    private String zipCode;
    private Integer enrolleeId;

    public Address(Integer id, String locality, String street, String building, String flat, String zipCode, Integer enrolleeId) {
        this.id = id;
        this.locality = locality;
        this.street = street;
        this.building = building;
        this.flat = flat;
        this.zipCode = zipCode;
        this.enrolleeId = enrolleeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(Integer enrolleeId) {
        this.enrolleeId = enrolleeId;
    }
}
