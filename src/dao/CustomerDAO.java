package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.DBConnection;

public class CustomerDAO {

    // =========================================================
    // ADD CUSTOMER
    // =========================================================

    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customer "
                + "(first_name, last_name, gender, dob, email, phone, "
                + "address, aadhar_no, pan_no, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getGender());
            ps.setString(4, customer.getDob());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getAddress());
            ps.setString(8, customer.getAadharNo());
            ps.setString(9, customer.getPanNo());
            ps.setString(10, customer.getPassword());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // VIEW ALL CUSTOMERS
    // =========================================================

    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(
                        rs.getInt("customer_id"));

                customer.setFirstName(
                        rs.getString("first_name"));

                customer.setLastName(
                        rs.getString("last_name"));

                customer.setGender(
                        rs.getString("gender"));

                customer.setDob(
                        rs.getString("dob"));

                customer.setEmail(
                        rs.getString("email"));

                customer.setPhone(
                        rs.getString("phone"));

                customer.setAddress(
                        rs.getString("address"));

                customer.setAadharNo(
                        rs.getString("aadhar_no"));

                customer.setPanNo(
                        rs.getString("pan_no"));

                customer.setPassword(
                        rs.getString("password"));

                customerList.add(customer);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return customerList;
    }


    // =========================================================
    // SEARCH CUSTOMER BY ID
    // =========================================================

    public Customer getCustomerById(int customerId) {

        String sql = "SELECT * FROM customer WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(
                        rs.getInt("customer_id"));

                customer.setFirstName(
                        rs.getString("first_name"));

                customer.setLastName(
                        rs.getString("last_name"));

                customer.setGender(
                        rs.getString("gender"));

                customer.setDob(
                        rs.getString("dob"));

                customer.setEmail(
                        rs.getString("email"));

                customer.setPhone(
                        rs.getString("phone"));

                customer.setAddress(
                        rs.getString("address"));

                customer.setAadharNo(
                        rs.getString("aadhar_no"));

                customer.setPanNo(
                        rs.getString("pan_no"));

                customer.setPassword(
                        rs.getString("password"));

                return customer;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
 // =========================================================
 // UPDATE CUSTOMER
 // =========================================================

 public boolean updateCustomer(Customer customer) {

     String sql = "UPDATE customer SET "
             + "first_name = ?, "
             + "last_name = ?, "
             + "gender = ?, "
             + "dob = ?, "
             + "email = ?, "
             + "phone = ?, "
             + "address = ?, "
             + "aadhar_no = ?, "
             + "pan_no = ?, "
             + "password = ? "
             + "WHERE customer_id = ?";

     try {

         Connection con = DBConnection.getConnection();

         PreparedStatement ps = con.prepareStatement(sql);

         ps.setString(1, customer.getFirstName());
         ps.setString(2, customer.getLastName());
         ps.setString(3, customer.getGender());
         ps.setString(4, customer.getDob());
         ps.setString(5, customer.getEmail());
         ps.setString(6, customer.getPhone());
         ps.setString(7, customer.getAddress());
         ps.setString(8, customer.getAadharNo());
         ps.setString(9, customer.getPanNo());
         ps.setString(10, customer.getPassword());

         ps.setInt(11, customer.getCustomerId());

         int rows = ps.executeUpdate();

         return rows > 0;

     } catch (Exception e) {

         e.printStackTrace();
     }

     return false;
 }
//=========================================================
//DELETE CUSTOMER
//=========================================================

public boolean deleteCustomer(int customerId) {

  String sql = "DELETE FROM customer WHERE customer_id = ?";

  try {

      Connection con = DBConnection.getConnection();

      PreparedStatement ps = con.prepareStatement(sql);

      ps.setInt(1, customerId);

      int rows = ps.executeUpdate();

      return rows > 0;

  } catch (Exception e) {

      e.printStackTrace();
  }

  return false;
}
//=========================================================
//CUSTOMER LOGIN
//=========================================================

public Customer customerLogin(String email, String password) {

 String sql = "SELECT * FROM customer "
            + "WHERE email = ? AND password = ?";

 try {

     Connection con = DBConnection.getConnection();

     PreparedStatement ps = con.prepareStatement(sql);

     ps.setString(1, email);
     ps.setString(2, password);

     ResultSet rs = ps.executeQuery();

     if (rs.next()) {

         Customer customer = new Customer();

         customer.setCustomerId(
                 rs.getInt("customer_id"));

         customer.setFirstName(
                 rs.getString("first_name"));

         customer.setLastName(
                 rs.getString("last_name"));

         customer.setGender(
                 rs.getString("gender"));

         customer.setDob(
                 rs.getString("dob"));

         customer.setEmail(
                 rs.getString("email"));

         customer.setPhone(
                 rs.getString("phone"));

         customer.setAddress(
                 rs.getString("address"));

         customer.setAadharNo(
                 rs.getString("aadhar_no"));

         customer.setPanNo(
                 rs.getString("pan_no"));

         customer.setPassword(
                 rs.getString("password"));

         return customer;
     }

 } catch (Exception e) {

     e.printStackTrace();
 }

 return null;
}

}
/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.DBConnection;

public class CustomerDAO {

    // Add Customer
    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customer "
                + "(first_name, last_name, gender, dob, email, phone, "
                + "address, aadhar_no, pan_no, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getGender());
            ps.setString(4, customer.getDob());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getAddress());
            ps.setString(8, customer.getAadharNo());
            ps.setString(9, customer.getPanNo());
            ps.setString(10, customer.getPassword());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // View All Customers
    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(
                        rs.getInt("customer_id"));

                customer.setFirstName(
                        rs.getString("first_name"));

                customer.setLastName(
                        rs.getString("last_name"));

                customer.setGender(
                        rs.getString("gender"));

                customer.setDob(
                        rs.getString("dob"));

                customer.setEmail(
                        rs.getString("email"));

                customer.setPhone(
                        rs.getString("phone"));

                customer.setAddress(
                        rs.getString("address"));

                customer.setAadharNo(
                        rs.getString("aadhar_no"));

                customer.setPanNo(
                        rs.getString("pan_no"));

                customer.setPassword(
                        rs.getString("password"));

                customerList.add(customer);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return customerList;
    }
}
*/