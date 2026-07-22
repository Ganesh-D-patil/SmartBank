package model;

public class Customer {

    // Instance Variables
    private int customerId;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String aadhaar;
    private String pan;
    private String password;

    // Default Constructor
    public Customer() {

    }

    // Parameterized Constructor
    public Customer(int customerId, String name, String mobile,
                    String email, String address,
                    String aadhaar, String pan, String password) {

        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.aadhaar = aadhaar;
        this.pan = pan;
        this.password = password;
    }

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Display Customer Details

    @Override
    public String toString() {
        return 
               "Customer ID : " + customerId + "\n" +
               "Name        : " + name + "\n" +
               "Mobile      : " + mobile + "\n" +
               "Email       : " + email + "\n" +
               "Address     : " + address + "\n" +
               "Aadhaar No. : " + aadhaar + "\n" +
               "PAN No.     : " + pan ;
               
    }
}