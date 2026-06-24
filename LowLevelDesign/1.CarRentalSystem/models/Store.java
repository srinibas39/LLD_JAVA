package CarRentalSystem.models;

public class Store {
    private int storeID;
    private String storeName;
    private String storeAddress;
    private String storeCity;
    private String storeState;
    private String storeCountry;
    private String storePincode;
    private Location location;
    private VehicleManager vehicleManager;
    private ReservationManager reservationManager;
    private BillManager billManager;

    public Store(int storeID, String storeName, String storeAddress, String storeCity, String storeState,
            String storeCountry, String storePincode) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeCity = storeCity;
        this.storeState = storeState;
        this.storeCountry = storeCountry;
        this.storePincode = storePincode;
        this.location = new Location(1, storeAddress, storeCity, storeState, storeCountry, storePincode);
        this.vehicleManager = new VehicleManager();
        this.reservationManager = new ReservationManager();
        this.billManager = new BillManager();
    }

    public int getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public String getStoreState() {
        return storeState;
    }

    public String getStoreCountry() {
        return storeCountry;
    }

    public String getStorePincode() {
        return storePincode;
    }

    public Location getLocation() {
        return location;
    }

    public VehicleManager getVehicleManager() {
        return vehicleManager;
    }

    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public BillManager getBillManager() {
        return billManager;
    }
}
