package main;

import java.sql.Connection;

import model.Account;
import model.Admin;
import model.Customer;
import model.Transaction;
import util.DBConnection;

public class Main {

    public static void main(String[] args) {

        // ---------------- Database Connection ----------------
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Database Connected Successfully\n");
        } else {
            System.out.println("Database Connection Failed\n");
        }

        // ---------------- Customer ----------------
        Customer customer = new Customer(
                101,
                "Ganesh Patil",
                "7887509277",
                "ganesh@gmail.com",
                "Pune",
                "123456789012",
                "ABCDE1234F",
                "ganesh123"
        );

        // ---------------- Account ----------------
        Account account = new Account(
                10010001,
                101,
                "Savings",
                50000,
                "Active"
        );

        // ---------------- Transaction ----------------
        Transaction transaction = new Transaction(
                1,
                10010001,
                "Deposit",
                2234,
                "23-07-2026",
                "05:50 AM",
                "Success"
        );

        // ---------------- Admin ----------------
        Admin admin = new Admin(
                1,
                "Ganesh",
                "Ganesh123",
                "Pass@123",
                "ganesh@gmail.com",
                "8432630780"
        );

        

        // ---------------- Print ----------------
        System.out.println(admin);
        System.out.println();

        System.out.println(customer);
        System.out.println();

        System.out.println(account);
        System.out.println();

        System.out.println(transaction);
    }

	
}