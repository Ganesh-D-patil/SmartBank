package ui;
import model.Account;
import service.AccountService;
import java.util.Scanner;

import model.Customer;

public class CustomerMenu {

    private Scanner sc = new Scanner(System.in);

    private Customer customer;
    private AccountService accountService =
            new AccountService();

    public CustomerMenu(Customer customer) {

        this.customer = customer;
    }

    public void showMenu() {

        while (true) {

            System.out.println(
                    "\n====================================");

            System.out.println(
                    "        CUSTOMER DASHBOARD");

            System.out.println(
                    "====================================");

            System.out.println(
                    "Welcome "
                    + customer.getFirstName()
                    + " "
                    + customer.getLastName());

            System.out.println();

            System.out.println("1. View Profile");
            System.out.println("2. View Account");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Transfer Money");
            System.out.println("7. Transaction History");
            System.out.println("8. Logout");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                viewProfile();
                break;

            case 2:
                viewAccount();
                break;

                case 3:
                    System.out.println(
                            "Check Balance - Coming Soon");
                    break;

                case 4:
                    System.out.println(
                            "Deposit Money - Coming Soon");
                    break;

                case 5:
                    System.out.println(
                            "Withdraw Money - Coming Soon");
                    break;

                case 6:
                    System.out.println(
                            "Transfer Money - Coming Soon");
                    break;

                case 7:
                    System.out.println(
                            "Transaction History - Coming Soon");
                    break;

                case 8:

                    System.out.println(
                            "\nLogged Out Successfully.");

                    return;

                default:

                    System.out.println(
                            "\nInvalid Choice!");
            }
        }
    }
 // =========================================================
 // VIEW CUSTOMER PROFILE
 // =========================================================

 private void viewProfile() {

     System.out.println(
             "\n========== CUSTOMER PROFILE ==========");

     System.out.println(
             "Customer ID : "
             + customer.getCustomerId());

     System.out.println(
             "First Name  : "
             + customer.getFirstName());

     System.out.println(
             "Last Name   : "
             + customer.getLastName());

     System.out.println(
             "Gender      : "
             + customer.getGender());

     System.out.println(
             "DOB         : "
             + customer.getDob());

     System.out.println(
             "Email       : "
             + customer.getEmail());

     System.out.println(
             "Phone       : "
             + customer.getPhone());

     System.out.println(
             "Address     : "
             + customer.getAddress());

     System.out.println(
             "Aadhaar No. : "
             + customer.getAadharNo());

     System.out.println(
             "PAN No.     : "
             + customer.getPanNo());

     System.out.println(
             "======================================");
 }
//=========================================================
//VIEW ACCOUNT
//=========================================================

private void viewAccount() {

  System.out.println(
          "\n========== ACCOUNT DETAILS ==========");

  Account account =
          accountService.getAccountByCustomerId(
                  customer.getCustomerId());

  if (account == null) {

      System.out.println(
              "\nNo Account Found!");

      return;
  }

  System.out.println(
          "Account Number : "
          + account.getAccountNumber());

  System.out.println(
          "Account Type   : "
          + account.getAccountType());

  System.out.println(
          "Balance        : "
          + account.getBalance());

  System.out.println(
          "Status         : "
          + account.getStatus());

  System.out.println(
          "=====================================");
}
}