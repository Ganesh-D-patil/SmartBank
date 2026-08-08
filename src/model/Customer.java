package model;

public class Customer {

    // Instance Variables
    private int customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String address;
    private String aadharNo;
    private String panNo;
    private String password;

    // Default Constructor
    public Customer() {

    }

    // Parameterized Constructor
    public Customer(int customerId, String firstName, String lastName,
                    String gender, String dob, String email,
                    String phone, String address,
                    String aadharNo, String panNo, String password) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
        this.password = password;
    }

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "\nCustomer Details\n" +
               "------------------------------\n" +
               "Customer ID : " + customerId + "\n" +
               "First Name  : " + firstName + "\n" +
               "Last Name   : " + lastName + "\n" +
               "Gender      : " + gender + "\n" +
               "DOB         : " + dob + "\n" +
               "Email       : " + email + "\n" +
               "Phone       : " + phone + "\n" +
               "Address     : " + address + "\n" +
               "Aadhaar No. : " + aadharNo + "\n" +
               "PAN No.     : " + panNo;
    }
}