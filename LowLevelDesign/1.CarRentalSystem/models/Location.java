package CarRentalSystem.models;

public class Location {
    private int buildingNo;
    private String area;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public Location(int buildingNo, String area, String city, String state, String country, String pincode) {
        this.buildingNo = buildingNo;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }
}
