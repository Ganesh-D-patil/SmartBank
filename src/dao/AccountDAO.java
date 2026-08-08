package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import util.DBConnection;

public class AccountDAO {

    // =========================================================
    // CHECK CUSTOMER EXISTS
    // =========================================================

    public boolean customerExists(int customerId) {

        String sql = "SELECT customer_id FROM customer WHERE customer_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // GENERATE ACCOUNT NUMBER
    // =========================================================

    public long generateAccountNumber() {

        String sql = "SELECT MAX(account_number) FROM account";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                long maxAccountNumber = rs.getLong(1);

                if (maxAccountNumber == 0) {
                    return 1000000001L;
                }

                return maxAccountNumber + 1;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 1000000001L;
    }


    // =========================================================
    // CREATE ACCOUNT
    // =========================================================

    public boolean createAccount(Account account) {

        String sql = "INSERT INTO account "
                + "(account_number, customer_id, account_type, balance, status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, account.getAccountNumber());
            ps.setInt(2, account.getCustomerId());
            ps.setString(3, account.getAccountType());
            ps.setDouble(4, account.getBalance());
            ps.setString(5, account.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // VIEW ALL ACCOUNTS
    // =========================================================

    public List<Account> getAllAccounts() {

        List<Account> accountList = new ArrayList<>();

        String sql = "SELECT * FROM account";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account account = new Account();

                account.setAccountId(
                        rs.getInt("account_id"));

                account.setAccountNumber(
                        rs.getLong("account_number"));

                account.setCustomerId(
                        rs.getInt("customer_id"));

                account.setAccountType(
                        rs.getString("account_type"));

                account.setBalance(
                        rs.getDouble("balance"));

                account.setStatus(
                        rs.getString("status"));

                accountList.add(account);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return accountList;
    }


    // =========================================================
    // FIND ACCOUNT BY ACCOUNT NUMBER
    // =========================================================

    public Account getAccountByNumber(long accountNumber) {

        String sql = "SELECT * FROM account WHERE account_number = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, accountNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Account account = new Account();

                account.setAccountId(
                        rs.getInt("account_id"));

                account.setAccountNumber(
                        rs.getLong("account_number"));

                account.setCustomerId(
                        rs.getInt("customer_id"));

                account.setAccountType(
                        rs.getString("account_type"));

                account.setBalance(
                        rs.getDouble("balance"));

                account.setStatus(
                        rs.getString("status"));

                return account;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // UPDATE BALANCE
    // =========================================================

    public boolean updateBalance(
            long accountNumber,
            double newBalance) {

        String sql = "UPDATE account "
                + "SET balance = ? "
                + "WHERE account_number = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, newBalance);
            ps.setLong(2, accountNumber);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
 // =========================================================
 // WITHDRAW MONEY - UPDATE BALANCE
 // =========================================================

 public boolean withdrawMoney(long accountNumber, double newBalance) {

     String sql = "UPDATE account "
             + "SET balance = ? "
             + "WHERE account_number = ?";

     try {

         Connection con = DBConnection.getConnection();

         PreparedStatement ps = con.prepareStatement(sql);

         ps.setDouble(1, newBalance);
         ps.setLong(2, accountNumber);

         int rows = ps.executeUpdate();

         return rows > 0;

     } catch (Exception e) {

         e.printStackTrace();
     }

     return false;
 }
//=========================================================
//UPDATE BALANCE USING EXISTING CONNECTION
//=========================================================

public boolean updateBalance(Connection con,
                           long accountNumber,
                           double newBalance) {

  String sql = "UPDATE account "
          + "SET balance = ? "
          + "WHERE account_number = ?";

  try {

      PreparedStatement ps = con.prepareStatement(sql);

      ps.setDouble(1, newBalance);
      ps.setLong(2, accountNumber);

      int rows = ps.executeUpdate();

      return rows > 0;

  } catch (Exception e) {

      e.printStackTrace();
  }

  return false;
}
//=========================================================
//TRANSFER MONEY
//=========================================================

public boolean transferMoney(long fromAccountNumber,
                          long toAccountNumber,
                          double amount) {

 Connection con = null;

 try {

     con = DBConnection.getConnection();

     // Start database transaction
     con.setAutoCommit(false);

     // -----------------------------------------
     // Deduct money from sender
     // -----------------------------------------

     String senderSQL =
             "UPDATE account "
             + "SET balance = balance - ? "
             + "WHERE account_number = ? "
             + "AND balance >= ? "
             + "AND status = 'ACTIVE'";

     PreparedStatement senderPS =
             con.prepareStatement(senderSQL);

     senderPS.setDouble(1, amount);
     senderPS.setLong(2, fromAccountNumber);
     senderPS.setDouble(3, amount);

     int senderRows =
             senderPS.executeUpdate();

     // Sender update failed
     if (senderRows == 0) {

         con.rollback();

         return false;
     }

     // -----------------------------------------
     // Add money to receiver
     // -----------------------------------------

     String receiverSQL =
             "UPDATE account "
             + "SET balance = balance + ? "
             + "WHERE account_number = ? "
             + "AND status = 'ACTIVE'";

     PreparedStatement receiverPS =
             con.prepareStatement(receiverSQL);

     receiverPS.setDouble(1, amount);
     receiverPS.setLong(2, toAccountNumber);

     int receiverRows =
             receiverPS.executeUpdate();

     // Receiver update failed
     if (receiverRows == 0) {

         con.rollback();

         return false;
     }

     // -----------------------------------------
     // Everything successful
     // -----------------------------------------

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

     } catch (Exception e) {

         e.printStackTrace();
     }
 }
}
}