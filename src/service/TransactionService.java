package service;

import java.util.List;

import dao.TransactionDAO;
import model.Transaction;

public class TransactionService {

    private TransactionDAO transactionDAO =
            new TransactionDAO();


    // =========================================================
    // ADD TRANSACTION
    // =========================================================

    public boolean addTransaction(
            Transaction transaction) {

        return transactionDAO.addTransaction(
                transaction);
    }


    // =========================================================
    // GET ALL TRANSACTIONS
    // =========================================================

    public List<Transaction> getAllTransactions() {

        return transactionDAO.getAllTransactions();
    }


    // =========================================================
    // GET TRANSACTIONS BY ACCOUNT
    // =========================================================

    public List<Transaction> getTransactionsByAccountId(
            int accountId) {

        return transactionDAO
                .getTransactionsByAccountId(accountId);
    }
    
}