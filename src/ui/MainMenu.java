package ui;
import model.Customer;
import service.CustomerService;
import java.util.Scanner;

import dao.AdminDAO;

public class MainMenu {
	private CustomerService customerService =
	        new CustomerService();

    Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      SMART BANK SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                adminLogin();
                break;

            case 2:
                customerLogin();
                break;

            case 3:
                System.out.println("Thank You for using SmartBank!");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }

    private void adminLogin() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        AdminDAO adminDAO = new AdminDAO();

        if (adminDAO.login(username, password)) {

            System.out.println("\nLogin Successful!");

            AdminMenu adminMenu = new AdminMenu();
            adminMenu.showMenu();

        } else {

            System.out.println("\nInvalid Username or Password!");
        }
    }
    private void customerLogin() {

        System.out.println(
                "\n========== CUSTOMER LOGIN ==========");

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        Customer customer =
                customerService.customerLogin(
                        email,
                        password);

        if (customer != null) {

            System.out.println(
                    "\n====================================");

            System.out.println(
                    "       CUSTOMER LOGIN SUCCESSFUL");

            System.out.println(
                    "====================================");

            System.out.println(
                    "Welcome "
                    + customer.getFirstName()
                    + " "
                    + customer.getLastName());

            System.out.println(
                    "Customer ID : "
                    + customer.getCustomerId());
            CustomerMenu customerMenu =
                    new CustomerMenu(customer);

            customerMenu.showMenu();

        } else {

            System.out.println(
                    "\nInvalid Email or Password!");
        }
    }
}