package CarRentalSystem.models;

public class User {

    private int userId;
    private String userName;
    private String drivingLicenseNo;

    public User(int userId, String userName, String drivingLicenseNo) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", drivingLicenseNo=" + drivingLicenseNo + "]";
    }
}
