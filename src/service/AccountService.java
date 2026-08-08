package service;

import java.sql.Connection;
import java.util.List;

import dao.AccountDAO;
import dao.TransactionDAO;
import model.Account;
import model.Transaction;
import util.DBConnection;

public class AccountService {

    private AccountDAO accountDAO =
            new AccountDAO();

    private TransactionDAO transactionDAO =
            new TransactionDAO();


    // =========================================================
    // CHECK CUSTOMER
    // =========================================================

    public boolean customerExists(int customerId) {

        return accountDAO.customerExists(customerId);
    }


    // =========================================================
    // GENERATE ACCOUNT NUMBER
    // =========================================================

    public long generateAccountNumber() {

        return accountDAO.generateAccountNumber();
    }


    // =========================================================
    // CREATE ACCOUNT
    // =========================================================

    public boolean createAccount(Account account) {

        return accountDAO.createAccount(account);
    }


    // =========================================================
    // VIEW ALL ACCOUNTS
    // =========================================================

    public List<Account> getAllAccounts() {

        return accountDAO.getAllAccounts();
    }


    // =========================================================
    // FIND ACCOUNT
    // =========================================================

    public Account getAccountByNumber(
            long accountNumber) {

        return accountDAO.getAccountByNumber(
                accountNumber);
    }


    // =========================================================
    // UPDATE BALANCE
    // =========================================================

    public boolean updateBalance(
            long accountNumber,
            double newBalance) {

        return accountDAO.updateBalance(
                accountNumber,
                newBalance);
    }


    // =========================================================
    // WITHDRAW MONEY
    // =========================================================

    public boolean withdrawMoney(
            long accountNumber,
            double newBalance) {

        return accountDAO.withdrawMoney(
                accountNumber,
                newBalance);
    }
    


    // =========================================================
    // TRANSFER MONEY
    // =========================================================

    public boolean transferMoney(
            long fromAccountNumber,
            long toAccountNumber,
            double amount) {

        Connection con = null;

        try {

            // Get one connection
            con = DBConnection.getConnection();

            // Start transaction
            con.setAutoCommit(false);


            // Find sender
            Account sender =
                    accountDAO.getAccountByNumber(
                            fromAccountNumber);


            // Find receiver
            Account receiver =
                    accountDAO.getAccountByNumber(
                            toAccountNumber);


            // Check sender
            if (sender == null) {

                System.out.println(
                        "Sender Account Not Found!");

                con.rollback();

                return false;
            }


            // Check receiver
            if (receiver == null) {

                System.out.println(
                        "Receiver Account Not Found!");

                con.rollback();

                return false;
            }


            // Check sender status
            if (!sender.getStatus()
                    .equalsIgnoreCase("ACTIVE")) {

                System.out.println(
                        "Sender Account is not ACTIVE!");

                con.rollback();

                return false;
            }


            // Check receiver status
            if (!receiver.getStatus()
                    .equalsIgnoreCase("ACTIVE")) {

                System.out.println(
                        "Receiver Account is not ACTIVE!");

                con.rollback();

                return false;
            }


            // Check same account
            if (fromAccountNumber ==
                    toAccountNumber) {

                System.out.println(
                        "Sender and Receiver "
                        + "accounts cannot be same!");

                con.rollback();

                return false;
            }


            // Check amount
            if (amount <= 0) {

                System.out.println(
                        "Transfer amount must "
                        + "be greater than 0!");

                con.rollback();

                return false;
            }


            // Check balance
            if (amount > sender.getBalance()) {

                System.out.println(
                        "Insufficient Balance!");

                System.out.println(
                        "Available Balance : "
                        + sender.getBalance());

                con.rollback();

                return false;
            }


            // Calculate balances

            double senderNewBalance =
                    sender.getBalance() - amount;

            double receiverNewBalance =
                    receiver.getBalance() + amount;


            // Update sender balance

            boolean senderUpdated =
                    accountDAO.updateBalance(
                            con,
                            fromAccountNumber,
                            senderNewBalance);


            if (!senderUpdated) {

                con.rollback();

                return false;
            }


            // Update receiver balance

            boolean receiverUpdated =
                    accountDAO.updateBalance(
                            con,
                            toAccountNumber,
                            receiverNewBalance);


            if (!receiverUpdated) {

                con.rollback();

                return false;
            }


            // Sender transaction

            Transaction senderTransaction =
                    new Transaction(
                            0,
                            sender.getAccountId(),
                            "TRANSFER",
                            amount,
                            null,
                            "Transfer to Account "
                            + toAccountNumber
                    );


            boolean senderTransactionAdded =
                    transactionDAO.addTransaction(
                            con,
                            senderTransaction);


            if (!senderTransactionAdded) {

                con.rollback();

                return false;
            }


            // Receiver transaction

            Transaction receiverTransaction =
                    new Transaction(
                            0,
                            receiver.getAccountId(),
                            "TRANSFER",
                            amount,
                            null,
                            "Transfer from Account "
                            + fromAccountNumber
                    );


            boolean receiverTransactionAdded =
                    transactionDAO.addTransaction(
                            con,
                            receiverTransaction);


            if (!receiverTransactionAdded) {

                con.rollback();

                return false;
            }


            // Everything successful
            con.commit();

            return true;

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (Exception rollbackException) {

                rollbackException.printStackTrace();
            }

            e.printStackTrace();

            return false;

        } finally {

            try {

                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }

            } catch (Exception closeException) {

                closeException.printStackTrace();
            }
        }
    }
    
    
}
/*package service;

import java.util.List;

import dao.AccountDAO;
import model.Account;

public class AccountService {

    private AccountDAO accountDAO =
            new AccountDAO();


    // =========================================================
    // CHECK CUSTOMER
    // =========================================================

    public boolean customerExists(int customerId) {

        return accountDAO.customerExists(customerId);
    }


    // =========================================================
    // GENERATE ACCOUNT NUMBER
    // =========================================================

    public long generateAccountNumber() {

        return accountDAO.generateAccountNumber();
    }


    // =========================================================
    // CREATE ACCOUNT
    // =========================================================

    public boolean createAccount(Account account) {

        return accountDAO.createAccount(account);
    }


    // =========================================================
    // VIEW ALL ACCOUNTS
    // =========================================================

    public List<Account> getAllAccounts() {

        return accountDAO.getAllAccounts();
    }


    // =========================================================
    // FIND ACCOUNT
    // =========================================================

    public Account getAccountByNumber(
            long accountNumber) {

        return accountDAO.getAccountByNumber(
                accountNumber);
    }


    // =========================================================
    // UPDATE BALANCE
    // =========================================================

    public boolean updateBalance(
            long accountNumber,
            double newBalance) {

        return accountDAO.updateBalance(
                accountNumber,
                newBalance);
    }
 // =========================================================
 // WITHDRAW MONEY
 // =========================================================

 public boolean withdrawMoney(long accountNumber, double newBalance) {

     return accountDAO.withdrawMoney(accountNumber, newBalance);
 }
}*/