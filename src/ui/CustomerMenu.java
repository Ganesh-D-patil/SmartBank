package ui;
import model.Account;

import service.AccountService;
import java.util.Scanner;

import model.Customer;
import java.util.List;
import model.Transaction;
import service.TransactionService;

public class CustomerMenu {

    private Scanner sc = new Scanner(System.in);

    private Customer customer;
    private AccountService accountService =
            new AccountService();
    
    private TransactionService transactionService =
            new TransactionService();
    

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
                checkBalance();
                break;

            case 4:
                depositMoney();
                break;

            case 5:
                withdrawMoney();
                break;

            case 6:
                transferMoney();
                break;

            case 7:
                transactionHistory();
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
//=========================================================
//CHECK BALANCE
//=========================================================

private void checkBalance() {

 System.out.println(
         "\n====================================");

 System.out.println(
         "          ACCOUNT BALANCE");

 System.out.println(
         "====================================");

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
         "Current Balance: ₹"
         + account.getBalance());

 System.out.println(
         "Status         : "
         + account.getStatus());

 System.out.println(
         "====================================");
}
//=========================================================
//CUSTOMER DEPOSIT
//=========================================================

private void depositMoney() {

 System.out.println(
         "\n========== CUSTOMER DEPOSIT ==========");

 // Find account of logged-in customer
 Account account =
         accountService.getAccountByCustomerId(
                 customer.getCustomerId());

 // Check account
 if (account == null) {

     System.out.println(
             "\nNo Account Found!");

     return;
 }

 // Display account details
 System.out.println(
         "Account Number : "
         + account.getAccountNumber());

 System.out.println(
         "Current Balance: "
         + account.getBalance());

 // Take deposit amount
 System.out.print(
         "\nEnter Deposit Amount : ");

 double amount = sc.nextDouble();
 sc.nextLine();

 // Validate amount
 if (amount <= 0) {

     System.out.println(
             "\nInvalid Deposit Amount!");

     return;
 }

 // Calculate new balance
 double previousBalance =
         account.getBalance();

 double newBalance =
         previousBalance + amount;

 // Update balance
 boolean success =
         accountService.updateBalance(
                 account.getAccountNumber(),
                 newBalance);

 // Check result
 if (success) {

	    boolean transactionAdded =
	            accountService.addDepositTransaction(
	                    account,
	                    amount);

	    if (!transactionAdded) {

	        System.out.println(
	                "\nDeposit completed, but "
	                + "transaction history was not updated.");

	        return;
	    }

	    System.out.println(
	            "\n====================================");

	    System.out.println(
	            "       DEPOSIT SUCCESSFUL");

	    System.out.println(
	            "====================================");

	    System.out.println(
	            "Account Number  : "
	            + account.getAccountNumber());

	    System.out.println(
	            "Previous Balance: "
	            + previousBalance);

	    System.out.println(
	            "Deposit Amount  : "
	            + amount);

	    System.out.println(
	            "New Balance     : "
	            + newBalance);

	    System.out.println(
	            "Transaction     : Recorded");

	    System.out.println(
	            "====================================");

	} else {

	    System.out.println(
	            "\nDeposit Failed!");
	}
}
//=========================================================
//CUSTOMER WITHDRAW
//=========================================================

private void withdrawMoney() {

 System.out.println(
         "\n========== CUSTOMER WITHDRAW ==========");

 // Find logged-in customer's account
 Account account =
         accountService.getAccountByCustomerId(
                 customer.getCustomerId());

 // Check account
 if (account == null) {

     System.out.println(
             "\nNo Account Found!");

     return;
 }

 System.out.println(
         "Account Number : "
         + account.getAccountNumber());

 System.out.println(
         "Current Balance: "
         + account.getBalance());

 // Take withdrawal amount
 System.out.print(
         "\nEnter Withdrawal Amount : ");

 double amount = sc.nextDouble();
 sc.nextLine();

 // Validate amount
 if (amount <= 0) {

     System.out.println(
             "\nInvalid Withdrawal Amount!");

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

 // Calculate new balance
 double previousBalance =
         account.getBalance();

 double newBalance =
         previousBalance - amount;

 // Update balance
 boolean success =
         accountService.withdrawMoney(
                 account.getAccountNumber(),
                 newBalance);

 if (success) {

	    boolean transactionAdded =
	            accountService.addWithdrawTransaction(
	                    account,
	                    amount);

	    if (!transactionAdded) {

	        System.out.println(
	                "\nWithdrawal completed, but "
	                + "transaction history was not updated.");

	        return;
	    }

	    System.out.println(
	            "\n====================================");

	    System.out.println(
	            "       WITHDRAWAL SUCCESSFUL");

	    System.out.println(
	            "====================================");

	    System.out.println(
	            "Account Number   : "
	            + account.getAccountNumber());

	    System.out.println(
	            "Previous Balance : "
	            + previousBalance);

	    System.out.println(
	            "Withdrawal Amount: "
	            + amount);

	    System.out.println(
	            "New Balance      : "
	            + newBalance);

	    System.out.println(
	            "Transaction      : Recorded");

	    System.out.println(
	            "====================================");

	} else {

	    System.out.println(
	            "\nWithdrawal Failed!");
	}
}
//=========================================================
//CUSTOMER TRANSFER MONEY
//=========================================================

private void transferMoney() {

 System.out.println(
         "\n========== CUSTOMER TRANSFER ==========");

 // Find logged-in customer's account
 Account sender =
         accountService.getAccountByCustomerId(
                 customer.getCustomerId());

 // Check sender account
 if (sender == null) {

     System.out.println(
             "\nYour Account Not Found!");

     return;
 }

 System.out.println(
         "Your Account Number : "
         + sender.getAccountNumber());

 System.out.println(
         "Current Balance     : "
         + sender.getBalance());

 // Receiver account
 System.out.print(
         "\nEnter Receiver Account Number : ");

 long receiverAccountNumber =
         sc.nextLong();

 // Transfer amount
 System.out.print(
         "Enter Transfer Amount : ");

 double amount =
         sc.nextDouble();

 sc.nextLine();

 // Basic validation
 if (amount <= 0) {

     System.out.println(
             "\nInvalid Transfer Amount!");

     return;
 }

 // Check same account
 if (sender.getAccountNumber()
         == receiverAccountNumber) {

     System.out.println(
             "\nYou cannot transfer money "
             + "to your own account!");

     return;
 }

 // Check balance
 if (amount > sender.getBalance()) {

     System.out.println(
             "\nInsufficient Balance!");

     System.out.println(
             "Available Balance : "
             + sender.getBalance());

     return;
 }

 // Perform transfer
 boolean success =
         accountService.transferMoney(
                 sender.getAccountNumber(),
                 receiverAccountNumber,
                 amount);

 if (success) {

     double newBalance =
             sender.getBalance() - amount;

     System.out.println(
             "\n====================================");

     System.out.println(
             "       TRANSFER SUCCESSFUL");

     System.out.println(
             "====================================");

     System.out.println(
             "From Account     : "
             + sender.getAccountNumber());

     System.out.println(
             "To Account       : "
             + receiverAccountNumber);

     System.out.println(
             "Transfer Amount   : "
             + amount);

     System.out.println(
             "Previous Balance : "
             + sender.getBalance());

     System.out.println(
             "New Balance      : "
             + newBalance);

     System.out.println(
             "Transaction      : Recorded");

     System.out.println(
             "====================================");

 } else {

     System.out.println(
             "\nTransfer Failed!");
 }
}
//=========================================================
//CUSTOMER TRANSACTION HISTORY
//=========================================================

private void transactionHistory() {

 System.out.println(
         "\n========== TRANSACTION HISTORY ==========");

 // Find logged-in customer's account
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
         "------------------------------------------");

 List<Transaction> transactions =
         transactionService.getTransactionsByAccountId(
                 account.getAccountId());

 if (transactions == null ||
         transactions.isEmpty()) {

     System.out.println(
             "No Transactions Found.");

     return;
 }

 for (Transaction transaction : transactions) {

     System.out.println(
             "Transaction ID : "
             + transaction.getTransactionId());

     System.out.println(
             "Type           : "
             + transaction.getTransactionType());

     System.out.println(
             "Amount         : "
             + transaction.getAmount());

     System.out.println(
             "Description    : "
             + transaction.getDescription());

     System.out.println(
             "------------------------------------------");
 }

 System.out.println(
         "==========================================");
}

}