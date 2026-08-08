package ui;

import java.util.List;
import java.util.Scanner;

import model.Customer;
import service.CustomerService;

import model.Account;
import service.AccountService;

import model.Transaction;
import service.TransactionService;

public class AdminMenu {

    private Scanner sc = new Scanner(System.in);

    private CustomerService customerService =
            new CustomerService();

    private AccountService accountService =
            new AccountService();
    
    private TransactionService transactionService =
            new TransactionService();

    // =========================================================
    // ADMIN MENU
    // =========================================================

    public void showMenu() {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("         ADMIN DASHBOARD");
            System.out.println("====================================");

            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Open Account");
            System.out.println("7. View Accounts");
            System.out.println("8. Deposit Money");
            System.out.println("9. Withdraw Money");
            System.out.println("10. Transfer Money");
            System.out.println("11. Transaction History");
            System.out.println("12. Logout");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

            case 1:

                addCustomer();

                break;


            case 2:

                viewAllCustomers();

                break;


            case 3:

                searchCustomer();

                break;


            case 4:

                updateCustomer();

                break;

            case 5:
                deleteCustomer();
                break;


            case 6:

                openAccount();

                break;


            case 7:

                viewAllAccounts();

                break;


            case 8:

                depositMoney();

                break;


            case 9:

                withdrawMoney();

                break;


            case 10:

                transferMoney();

                break;


            case 11:

                transactionHistory();

                break;


            case 12:

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
    // ADD CUSTOMER
    // =========================================================

    private void addCustomer() {

        System.out.println(
                "\n========== ADD CUSTOMER ==========");

        System.out.print("Enter First Name : ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name : ");
        String lastName = sc.nextLine();

        System.out.print("Enter Gender : ");
        String gender = sc.nextLine();

        System.out.print(
                "Enter DOB (YYYY-MM-DD) : ");
        String dob = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Phone : ");
        String phone = sc.nextLine();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        System.out.print(
                "Enter Aadhaar Number : ");
        String aadhar = sc.nextLine();

        System.out.print(
                "Enter PAN Number : ");
        String pan = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();


        Customer customer = new Customer(
                0,
                firstName,
                lastName,
                gender,
                dob,
                email,
                phone,
                address,
                aadhar,
                pan,
                password
        );


        boolean result =
                customerService.addCustomer(customer);


        if (result) {

            System.out.println(
                    "\nCustomer Added Successfully!");

        } else {

            System.out.println(
                    "\nFailed to Add Customer.");
        }
    }


    // =========================================================
    // VIEW ALL CUSTOMERS
    // =========================================================

    private void viewAllCustomers() {

        System.out.println(
                "\n========== ALL CUSTOMERS ==========");

        List<Customer> customers =
                customerService.getAllCustomers();


        if (customers.isEmpty()) {

            System.out.println(
                    "\nNo Customers Found.");

            return;
        }


        for (Customer customer : customers) {

            System.out.println(customer);

            System.out.println(
                    "------------------------------------");
        }


        System.out.println(
                "Total Customers : "
                + customers.size());
    }


    // =========================================================
    // SEARCH CUSTOMER
    // =========================================================

    private void searchCustomer() {

        System.out.println(
                "\n========== SEARCH CUSTOMER ==========");

        System.out.print(
                "Enter Customer ID : ");

        int customerId = sc.nextInt();

        sc.nextLine();


        Customer customer =
                customerService.getCustomerById(
                        customerId);


        if (customer != null) {

            System.out.println(
                    "\n========== CUSTOMER FOUND ==========");

            System.out.println(customer);

        } else {

            System.out.println(
                    "\nCustomer Not Found!");
        }
    }
 // =========================================================
 // UPDATE CUSTOMER
 // =========================================================

 private void updateCustomer() {

     System.out.println(
             "\n========== UPDATE CUSTOMER ==========");

     System.out.print("Enter Customer ID : ");

     int customerId = sc.nextInt();

     sc.nextLine();


     // First check whether customer exists

     Customer existingCustomer =
             customerService.getCustomerById(customerId);


     if (existingCustomer == null) {

         System.out.println(
                 "\nCustomer Not Found!");

         return;
     }


     System.out.println(
             "\nCustomer Found!");

     System.out.println(existingCustomer);


     System.out.println(
             "\nEnter New Customer Details");


     System.out.print("Enter First Name : ");
     String firstName = sc.nextLine();


     System.out.print("Enter Last Name : ");
     String lastName = sc.nextLine();


     System.out.print("Enter Gender : ");
     String gender = sc.nextLine();


     System.out.print(
             "Enter DOB (YYYY-MM-DD) : ");

     String dob = sc.nextLine();


     System.out.print("Enter Email : ");
     String email = sc.nextLine();


     System.out.print("Enter Phone : ");
     String phone = sc.nextLine();


     System.out.print("Enter Address : ");
     String address = sc.nextLine();


     System.out.print(
             "Enter Aadhaar Number : ");

     String aadhar = sc.nextLine();


     System.out.print(
             "Enter PAN Number : ");

     String pan = sc.nextLine();


     System.out.print("Enter Password : ");
     String password = sc.nextLine();


     Customer customer = new Customer(
             customerId,
             firstName,
             lastName,
             gender,
             dob,
             email,
             phone,
             address,
             aadhar,
             pan,
             password
     );


     boolean result =
             customerService.updateCustomer(customer);


     if (result) {

         System.out.println(
                 "\nCustomer Updated Successfully!");

     } else {

         System.out.println(
                 "\nFailed to Update Customer.");
     }
 }
//=========================================================
//DELETE CUSTOMER
//=========================================================

private void deleteCustomer() {

  System.out.println("\n========== DELETE CUSTOMER ==========");

  System.out.print("Enter Customer ID : ");

  int customerId = sc.nextInt();
  sc.nextLine();

  // Check whether customer exists
  Customer customer =
          customerService.getCustomerById(customerId);

  if (customer == null) {

      System.out.println("\nCustomer Not Found!");

      return;
  }

  // Display customer before deletion
  System.out.println("\nCustomer Found:");
  System.out.println(customer);

  System.out.println("\nWARNING: Deleting this customer may");
  System.out.println("also delete their account and transaction history.");

  System.out.print("\nAre you sure you want to delete this customer? (Y/N): ");

  String confirmation = sc.nextLine();

  if (!confirmation.equalsIgnoreCase("Y")) {

      System.out.println("\nDeletion Cancelled.");

      return;
  }

  boolean result =
          customerService.deleteCustomer(customerId);

  if (result) {

      System.out.println("\nCustomer Deleted Successfully!");

  } else {

      System.out.println("\nFailed to Delete Customer.");
  }
}
//=========================================================
//OPEN ACCOUNT
//=========================================================

private void openAccount() {

 System.out.println(
         "\n========== OPEN ACCOUNT ==========");

 System.out.print("Enter Customer ID : ");

 int customerId = sc.nextInt();
 sc.nextLine();


 // Check customer exists

 Customer customer =
         customerService.getCustomerById(customerId);


 if (customer == null) {

     System.out.println(
             "\nCustomer Not Found!");

     return;
 }


 // Display customer

 System.out.println("\nCustomer Found:");

 System.out.println(
         "Name : "
         + customer.getFirstName()
         + " "
         + customer.getLastName());

 System.out.println(
         "Phone : "
         + customer.getPhone());


 // Account Type

 System.out.println("\nSelect Account Type:");

 System.out.println("1. Savings");

 System.out.println("2. Current");

 System.out.print("\nEnter Choice : ");

 int choice = sc.nextInt();
 sc.nextLine();


 String accountType;


 if (choice == 1) {

     accountType = "SAVINGS";

 } else if (choice == 2) {

     accountType = "CURRENT";

 } else {

     System.out.println(
             "\nInvalid Account Type!");

     return;
 }


 // Initial Balance

 System.out.print(
         "\nEnter Initial Balance : ");

 double balance = sc.nextDouble();
 sc.nextLine();


 // Validate balance

 if (balance < 0) {

     System.out.println(
             "\nBalance cannot be negative!");

     return;
 }


 // Generate Account Number

 long accountNumber =
         accountService.generateAccountNumber();


 // Create Account Object

 Account account = new Account(
         0,
         accountNumber,
         customerId,
         accountType,
         balance,
         "ACTIVE"
 );


 // Save Account

 boolean result =
         accountService.createAccount(account);


 if (result) {

     System.out.println(
             "\n====================================");

     System.out.println(
             "     ACCOUNT CREATED SUCCESSFULLY");

     System.out.println(
             "====================================");

     System.out.println(
             "Account Number : "
             + accountNumber);

     System.out.println(
             "Customer ID    : "
             + customerId);

     System.out.println(
             "Account Type   : "
             + accountType);

     System.out.println(
             "Balance        : "
             + balance);

     System.out.println(
             "Status         : ACTIVE");

 } else {

     System.out.println(
             "\nFailed to Create Account.");
 }
}
//=========================================================
//VIEW ALL ACCOUNTS
//=========================================================

private void viewAllAccounts() {

 System.out.println(
         "\n========== ALL ACCOUNTS ==========");

 List<Account> accounts =
         accountService.getAllAccounts();


 if (accounts.isEmpty()) {

     System.out.println(
             "\nNo Accounts Found.");

     return;
 }


 for (Account account : accounts) {

     System.out.println(
             "\nAccount ID     : "
             + account.getAccountId());

     System.out.println(
             "Account Number : "
             + account.getAccountNumber());

     System.out.println(
             "Customer ID    : "
             + account.getCustomerId());

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
             "------------------------------------");
 }


 System.out.println(
         "Total Accounts : "
         + accounts.size());
}
//=========================================================
//DEPOSIT MONEY
//=========================================================

private void depositMoney() {

 System.out.println(
         "\n========== DEPOSIT MONEY ==========");


 System.out.print(
         "Enter Account Number : ");

 long accountNumber = sc.nextLong();

 sc.nextLine();


 // Find account

 Account account =
         accountService.getAccountByNumber(
                 accountNumber);


 if (account == null) {

     System.out.println(
             "\nAccount Not Found!");

     return;
 }


 // Check account status

 if (!account.getStatus()
         .equalsIgnoreCase("ACTIVE")) {

     System.out.println(
             "\nAccount is not ACTIVE.");

     return;
 }


 System.out.println(
         "\nAccount Found!");

 System.out.println(
         "Current Balance : "
         + account.getBalance());


 // Enter amount

 System.out.print(
         "\nEnter Deposit Amount : ");

 double amount = sc.nextDouble();

 sc.nextLine();


 // Validate amount

 if (amount <= 0) {

     System.out.println(
             "\nDeposit amount must be greater than 0.");

     return;
 }


 // Calculate new balance

 double oldBalance =
         account.getBalance();

 double newBalance =
         oldBalance + amount;


 // Update account balance

 boolean balanceUpdated =
         accountService.updateBalance(
                 accountNumber,
                 newBalance);


 if (!balanceUpdated) {

     System.out.println(
             "\nFailed to update account balance.");

     return;
 }


 // Create transaction

 Transaction transaction =
         new Transaction(
                 0,
                 account.getAccountId(),
                 "DEPOSIT",
                 amount,
                 null,
                 "Cash Deposit"
         );


 boolean transactionAdded =
         transactionService.addTransaction(
                 transaction);


 if (transactionAdded) {

     System.out.println(
             "\n====================================");

     System.out.println(
             "       DEPOSIT SUCCESSFUL");

     System.out.println(
             "====================================");

     System.out.println(
             "Account Number  : "
             + accountNumber);

     System.out.println(
             "Previous Balance: "
             + oldBalance);

     System.out.println(
             "Deposit Amount  : "
             + amount);

     System.out.println(
             "New Balance     : "
             + newBalance);

 } else {

     System.out.println(
             "\nWarning: Balance updated, "
             + "but transaction record failed.");
 }
}
//=========================================================
//WITHDRAW MONEY
//=========================================================

private void withdrawMoney() {

 System.out.println(
         "\n========== WITHDRAW MONEY ==========");

 System.out.print(
         "Enter Account Number : ");

 long accountNumber = sc.nextLong();

 sc.nextLine();


 // Find Account

 Account account =
         accountService.getAccountByNumber(
                 accountNumber);


 if (account == null) {

     System.out.println(
             "\nAccount Not Found!");

     return;
 }


 // Check Account Status

 if (!account.getStatus()
         .equalsIgnoreCase("ACTIVE")) {

     System.out.println(
             "\nAccount is not ACTIVE.");

     return;
 }


 System.out.println(
         "\nAccount Found!");

 System.out.println(
         "Current Balance : "
         + account.getBalance());


 // Enter Withdrawal Amount

 System.out.print(
         "\nEnter Withdrawal Amount : ");

 double amount = sc.nextDouble();

 sc.nextLine();


 // Check amount

 if (amount <= 0) {

     System.out.println(
             "\nWithdrawal amount must be greater than 0.");

     return;
 }


 // Check sufficient balance

 if (amount > account.getBalance()) {

     System.out.println(
             "\nInsufficient Balance!");

     System.out.println(
             "Available Balance : "
             + account.getBalance());

     return;
 }


 // Calculate New Balance

 double oldBalance =
         account.getBalance();

 double newBalance =
         oldBalance - amount;


 // Update Balance

 boolean balanceUpdated =
         accountService.withdrawMoney(
                 accountNumber,
                 newBalance);


 if (!balanceUpdated) {

     System.out.println(
             "\nFailed to update account balance.");

     return;
 }


 // Create Transaction

 Transaction transaction =
         new Transaction(
                 0,
                 account.getAccountId(),
                 "WITHDRAW",
                 amount,
                 null,
                 "Cash Withdrawal"
         );


 boolean transactionAdded =
         transactionService.addTransaction(
                 transaction);


 if (transactionAdded) {

     System.out.println(
             "\n====================================");

     System.out.println(
             "     WITHDRAWAL SUCCESSFUL");

     System.out.println(
             "====================================");

     System.out.println(
             "Account Number   : "
             + accountNumber);

     System.out.println(
             "Previous Balance : "
             + oldBalance);

     System.out.println(
             "Withdraw Amount   : "
             + amount);

     System.out.println(
             "New Balance       : "
             + newBalance);

 } else {

     System.out.println(
             "\nWarning: Balance updated, "
             + "but transaction record failed.");
 }
}
//=========================================================
//TRANSFER MONEY
//=========================================================

private void transferMoney() {

 System.out.println(
         "\n========== TRANSFER MONEY ==========");

 // -----------------------------------------
 // Sender Account
 // -----------------------------------------

 System.out.print(
         "Enter Sender Account Number : ");

 long fromAccountNumber =
         sc.nextLong();

 sc.nextLine();


 // -----------------------------------------
 // Receiver Account
 // -----------------------------------------

 System.out.print(
         "Enter Receiver Account Number : ");

 long toAccountNumber =
         sc.nextLong();

 sc.nextLine();


 // -----------------------------------------
 // Amount
 // -----------------------------------------

 System.out.print(
         "Enter Transfer Amount : ");

 double amount =
         sc.nextDouble();

 sc.nextLine();


 // -----------------------------------------
 // Same Account Check
 // -----------------------------------------

 if (fromAccountNumber == toAccountNumber) {

     System.out.println(
             "\nSender and Receiver "
             + "account cannot be same!");

     return;
 }


 // -----------------------------------------
 // Amount Check
 // -----------------------------------------

 if (amount <= 0) {

     System.out.println(
             "\nTransfer amount must "
             + "be greater than 0!");

     return;
 }


 // -----------------------------------------
 // Check Sender Account
 // -----------------------------------------

 Account sender =
         accountService.getAccountByNumber(
                 fromAccountNumber);


 if (sender == null) {

     System.out.println(
             "\nSender Account Not Found!");

     return;
 }


 // -----------------------------------------
 // Check Receiver Account
 // -----------------------------------------

 Account receiver =
         accountService.getAccountByNumber(
                 toAccountNumber);


 if (receiver == null) {

     System.out.println(
             "\nReceiver Account Not Found!");

     return;
 }


 // -----------------------------------------
 // Check Sender Status
 // -----------------------------------------

 if (!sender.getStatus()
         .equalsIgnoreCase("ACTIVE")) {

     System.out.println(
             "\nSender Account is not ACTIVE!");

     return;
 }


 // -----------------------------------------
 // Check Receiver Status
 // -----------------------------------------

 if (!receiver.getStatus()
         .equalsIgnoreCase("ACTIVE")) {

     System.out.println(
             "\nReceiver Account is not ACTIVE!");

     return;
 }


 // -----------------------------------------
 // Check Balance
 // -----------------------------------------

 if (amount > sender.getBalance()) {

     System.out.println(
             "\nInsufficient Balance!");

     System.out.println(
             "Available Balance : "
             + sender.getBalance());

     return;
 }


 // -----------------------------------------
 // Show Transfer Details
 // -----------------------------------------

 System.out.println(
         "\n========== TRANSFER DETAILS ==========");

 System.out.println(
         "Sender Account   : "
         + fromAccountNumber);

 System.out.println(
         "Receiver Account : "
         + toAccountNumber);

 System.out.println(
         "Amount           : "
         + amount);


 System.out.print(
         "\nConfirm Transfer? (Y/N): ");

 String confirmation =
         sc.nextLine();


 if (!confirmation.equalsIgnoreCase("Y")) {

     System.out.println(
             "\nTransfer Cancelled.");

     return;
 }


 // -----------------------------------------
 // Perform Transfer
 // -----------------------------------------

 boolean result =
         accountService.transferMoney(
                 fromAccountNumber,
                 toAccountNumber,
                 amount
         );


 // -----------------------------------------
 // Result
 // -----------------------------------------

 if (result) {

     System.out.println(
             "\n====================================");

     System.out.println(
             "       TRANSFER SUCCESSFUL");

     System.out.println(
             "====================================");

     System.out.println(
             "From Account : "
             + fromAccountNumber);

     System.out.println(
             "To Account   : "
             + toAccountNumber);

     System.out.println(
             "Amount       : "
             + amount);

     System.out.println(
             "------------------------------------");

     System.out.println(
             "Transfer completed successfully.");

 } else {

     System.out.println(
             "\n====================================");

     System.out.println(
             "         TRANSFER FAILED");

     System.out.println(
             "====================================");

     System.out.println(
             "Money was not transferred.");
 }
}
//=========================================================
//TRANSACTION HISTORY MENU
//=========================================================

private void transactionHistory() {

 System.out.println(
         "\n========== TRANSACTION HISTORY ==========");

 System.out.println(
         "1. View All Transactions");

 System.out.println(
         "2. View Transactions by Account");

 System.out.println(
         "3. Back");

 System.out.print(
         "\nEnter Choice : ");

 int choice = sc.nextInt();

 sc.nextLine();


 switch (choice) {

     case 1:

         viewAllTransactions();

         break;


     case 2:

         viewAccountTransactions();

         break;


     case 3:

         System.out.println(
                 "\nReturning to Admin Dashboard...");

         break;


     default:

         System.out.println(
                 "\nInvalid Choice!");
 }
}
private void viewAllTransactions() {

    System.out.println(
            "\n========== ALL TRANSACTIONS ==========");

    List<Transaction> transactions =
            transactionService.getAllTransactions();

    if (transactions.isEmpty()) {

        System.out.println(
                "\nNo Transactions Found.");

        return;
    }

    for (Transaction transaction : transactions) {

        System.out.println(
                "\nTransaction ID : "
                + transaction.getTransactionId());

        System.out.println(
                "Account ID     : "
                + transaction.getAccountId());

        System.out.println(
                "Type           : "
                + transaction.getTransactionType());

        System.out.println(
                "Amount         : "
                + transaction.getAmount());

        System.out.println(
                "Date           : "
                + transaction.getTransactionDate());

        System.out.println(
                "Description    : "
                + transaction.getDescription());

        System.out.println(
                "----------------------------------------");
    }

    System.out.println(
            "Total Transactions : "
            + transactions.size());
}
private void viewAccountTransactions() {

    System.out.println(
            "\n====== ACCOUNT TRANSACTION HISTORY ======");

    System.out.print(
            "Enter Account Number : ");

    long accountNumber = sc.nextLong();

    sc.nextLine();

    Account account =
            accountService.getAccountByNumber(
                    accountNumber);

    if (account == null) {

        System.out.println(
                "\nAccount Not Found!");

        return;
    }

    List<Transaction> transactions =
            transactionService
                    .getTransactionsByAccountId(
                            account.getAccountId());

    if (transactions.isEmpty()) {

        System.out.println(
                "\nNo Transactions Found "
                + "for this Account.");

        return;
    }

    System.out.println(
            "\nAccount Number : "
            + accountNumber);

    System.out.println(
            "Current Balance : "
            + account.getBalance());

    System.out.println(
            "\n----------------------------------------");

    for (Transaction transaction : transactions) {

        System.out.println(
                "\nTransaction ID : "
                + transaction.getTransactionId());

        System.out.println(
                "Type           : "
                + transaction.getTransactionType());

        System.out.println(
                "Amount         : "
                + transaction.getAmount());

        System.out.println(
                "Date           : "
                + transaction.getTransactionDate());

        System.out.println(
                "Description    : "
                + transaction.getDescription());

        System.out.println(
                "----------------------------------------");
    }
}
}
/*package ui;

import java.util.List;
import java.util.Scanner;

import model.Customer;
import service.CustomerService;

public class AdminMenu {

    Scanner sc = new Scanner(System.in);

    CustomerService customerService = new CustomerService();


    public void showMenu() {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("         ADMIN DASHBOARD");
            System.out.println("====================================");

            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Open Account");
            System.out.println("7. View Accounts");
            System.out.println("8. Deposit Money");
            System.out.println("9. Withdraw Money");
            System.out.println("10. Transfer Money");
            System.out.println("11. Transaction History");
            System.out.println("12. Logout");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

            case 1:
                addCustomer();
                break;


            case 2:
                viewAllCustomers();
                break;


            case 3:
                System.out.println("Search Customer - Coming Soon");
                break;


            case 4:
                System.out.println("Update Customer - Coming Soon");
                break;


            case 5:
                System.out.println("Delete Customer - Coming Soon");
                break;


            case 6:
                System.out.println("Open Account - Coming Soon");
                break;


            case 7:
                System.out.println("View Accounts - Coming Soon");
                break;


            case 8:
                System.out.println("Deposit Money - Coming Soon");
                break;


            case 9:
                System.out.println("Withdraw Money - Coming Soon");
                break;


            case 10:
                System.out.println("Transfer Money - Coming Soon");
                break;


            case 11:
                System.out.println("Transaction History - Coming Soon");
                break;


            case 12:
                System.out.println("\nLogged Out Successfully.");
                return;


            default:
                System.out.println("\nInvalid Choice!");
            }
        }
    }


    // ================= ADD CUSTOMER =================

    private void addCustomer() {

        System.out.println("\n========== Add Customer ==========");

        System.out.print("Enter First Name : ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name : ");
        String lastName = sc.nextLine();

        System.out.print("Enter Gender : ");
        String gender = sc.nextLine();

        System.out.print("Enter DOB (YYYY-MM-DD) : ");
        String dob = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Phone : ");
        String phone = sc.nextLine();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        System.out.print("Enter Aadhaar Number : ");
        String aadhar = sc.nextLine();

        System.out.print("Enter PAN Number : ");
        String pan = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();


        Customer customer = new Customer(
                0,
                firstName,
                lastName,
                gender,
                dob,
                email,
                phone,
                address,
                aadhar,
                pan,
                password
        );


        if (customerService.addCustomer(customer)) {

            System.out.println("\nCustomer Added Successfully!");

        } else {

            System.out.println("\nFailed to Add Customer.");
        }
    }


    // ================= VIEW ALL CUSTOMERS =================

    private void viewAllCustomers() {

        System.out.println("\n========== ALL CUSTOMERS ==========");

        List<Customer> customers =
                customerService.getAllCustomers();


        if (customers.isEmpty()) {

            System.out.println("\nNo Customers Found.");

            return;
        }


        for (Customer customer : customers) {

            System.out.println(customer);

            System.out.println("------------------------------------");
        }


        System.out.println("Total Customers : " + customers.size());
    }
}
*/