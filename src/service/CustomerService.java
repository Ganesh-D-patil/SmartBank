
package service;

import java.util.List;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();


    // =========================================================
    // ADD CUSTOMER
    // =========================================================

    public boolean addCustomer(Customer customer) {

        return customerDAO.addCustomer(customer);
    }


    // =========================================================
    // VIEW ALL CUSTOMERS
    // =========================================================

    public List<Customer> getAllCustomers() {

        return customerDAO.getAllCustomers();
    }


    // =========================================================
    // SEARCH CUSTOMER BY ID
    // =========================================================

    public Customer getCustomerById(int customerId) {

        return customerDAO.getCustomerById(customerId);
    }
 // =========================================================
 // UPDATE CUSTOMER
 // =========================================================

 public boolean updateCustomer(Customer customer) {

     return customerDAO.updateCustomer(customer);
 }
//=========================================================
//DELETE CUSTOMER
//=========================================================

public boolean deleteCustomer(int customerId) {

  return customerDAO.deleteCustomer(customerId);
}
//=========================================================
//CUSTOMER LOGIN
//=========================================================

public Customer customerLogin(String email, String password) {

 return customerDAO.customerLogin(email, password);
}
}
/*package service;

import java.util.List;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();


    // Add Customer
    public boolean addCustomer(Customer customer) {

        return customerDAO.addCustomer(customer);
    }


    // View All Customers
    public List<Customer> getAllCustomers() {

        return customerDAO.getAllCustomers();
    }
}
*/