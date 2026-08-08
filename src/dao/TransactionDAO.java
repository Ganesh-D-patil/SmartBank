package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Transaction;
import util.DBConnection;

public class TransactionDAO {

    // =========================================================
    // ADD TRANSACTION
    // =========================================================

    public boolean addTransaction(Transaction transaction) {

        String sql = "INSERT INTO transaction_history "
                + "(account_id, transaction_type, amount, description) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, transaction.getAccountId());
            ps.setString(2, transaction.getTransactionType());
            ps.setDouble(3, transaction.getAmount());
            ps.setString(4, transaction.getDescription());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // =========================================================
    // ADD TRANSACTION USING EXISTING CONNECTION
    // =========================================================

    public boolean addTransaction(Connection con,
                                   Transaction transaction) {

        String sql = "INSERT INTO transaction_history "
                + "(account_id, transaction_type, amount, description) "
                + "VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, transaction.getAccountId());
            ps.setString(2, transaction.getTransactionType());
            ps.setDouble(3, transaction.getAmount());
            ps.setString(4, transaction.getDescription());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
 // =========================================================
 // GET ALL TRANSACTIONS
 // =========================================================

 public List<Transaction> getAllTransactions() {

     List<Transaction> transactionList =
             new ArrayList<>();

     String sql =
             "SELECT * FROM transaction_history "
             + "ORDER BY transaction_id DESC";

     try {

         Connection con =
                 DBConnection.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ResultSet rs =
                 ps.executeQuery();

         while (rs.next()) {

             Transaction transaction =
                     new Transaction();

             transaction.setTransactionId(
                     rs.getInt("transaction_id"));

             transaction.setAccountId(
                     rs.getInt("account_id"));

             transaction.setTransactionType(
                     rs.getString("transaction_type"));

             transaction.setAmount(
                     rs.getDouble("amount"));

             transaction.setTransactionDate(
                     rs.getString("transaction_date"));

             transaction.setDescription(
                     rs.getString("description"));

             transactionList.add(transaction);
         }

     } catch (Exception e) {

         e.printStackTrace();
     }

     return transactionList;
 }


 // =========================================================
 // GET TRANSACTIONS BY ACCOUNT ID
 // =========================================================

 public List<Transaction> getTransactionsByAccountId(
         int accountId) {

     List<Transaction> transactionList =
             new ArrayList<>();

     String sql =
             "SELECT * FROM transaction_history "
             + "WHERE account_id = ? "
             + "ORDER BY transaction_id DESC";

     try {

         Connection con =
                 DBConnection.getConnection();

         PreparedStatement ps =
                 con.prepareStatement(sql);

         ps.setInt(1, accountId);

         ResultSet rs =
                 ps.executeQuery();

         while (rs.next()) {

             Transaction transaction =
                     new Transaction();

             transaction.setTransactionId(
                     rs.getInt("transaction_id"));

             transaction.setAccountId(
                     rs.getInt("account_id"));

             transaction.setTransactionType(
                     rs.getString("transaction_type"));

             transaction.setAmount(
                     rs.getDouble("amount"));

             transaction.setTransactionDate(
                     rs.getString("transaction_date"));

             transaction.setDescription(
                     rs.getString("description"));

             transactionList.add(transaction);
         }

     } catch (Exception e) {

         e.printStackTrace();
     }

     return transactionList;
 }
}
/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Transaction;
import util.DBConnection;

public class TransactionDAO {

    // =========================================================
    // ADD TRANSACTION
    // =========================================================

    public boolean addTransaction(Transaction transaction) {

        String sql = "INSERT INTO transaction_history "
                + "(account_id, transaction_type, amount, description) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, transaction.getAccountId());

            ps.setString(2, transaction.getTransactionType());

            ps.setDouble(3, transaction.getAmount());

            ps.setString(4, transaction.getDescription());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}*/