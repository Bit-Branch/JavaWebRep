package by.epam.committiee.entity;


import java.io.Serializable;

public class Address implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return zipCode != null ? zipCode.equals(address.zipCode) : address.zipCode == null &&
                id == address.id &&
                enrolleeId == address.enrolleeId &&
                locality != null ? locality.equals(address.locality) : address.locality == null &&
                street != null ? street.equals(address.street) : address.street == null &&
                building != null ? building.equals(address.building) : address.building == null &&
                flat != null ? flat.equals(address.flat) : address.flat == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (int) (enrolleeId ^ (enrolleeId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", locality: ");
        stringBuilder.append(locality);
        stringBuilder.append(", street: ");
        stringBuilder.append(street);
        stringBuilder.append(", building: ");
        stringBuilder.append(building);
        stringBuilder.append(", flat: ");
        stringBuilder.append(flat);
        stringBuilder.append(", zipCode: ");
        stringBuilder.append(zipCode);
        stringBuilder.append(", enrolleeId: ");
        stringBuilder.append(enrolleeId);
        return stringBuilder.toString();
    }
}
