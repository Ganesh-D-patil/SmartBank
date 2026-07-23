

	package model;

	public class Admin {

	    // Instance Variables
	    private int adminId;
	    private String name;
	    private String email;
	    private String password;

	    // Default Constructor
	    public Admin() {

	    }

	    // Parameterized Constructor
	    public Admin(int adminId, String name, String email, String password) {
	        this.adminId = adminId;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    // Getters

	    public int getAdminId() {
	        return adminId;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    // Setters

	    public void setAdminId(int adminId) {
	        this.adminId = adminId;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public String toString() {
	        return "\n========== ADMIN DETAILS ==========\n" +
	               "Admin ID : " + adminId + "\n" +
	               "Name     : " + name + "\n" +
	               "Email    : " + email + "\n" +
	               "===================================";
	    }
	}


