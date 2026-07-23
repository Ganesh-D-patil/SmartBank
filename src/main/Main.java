package main;

import model.Account;
import model.Customer;
import model.Transaction;
import model.Admin;

public class Main {

    public static void main(String[] args) {

        // Customer Object
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

        // Account Object
        Account account = new Account(
                10010001,
                101,
                "Savings",
                50000,
                "Active"
        );
        Transaction transaction = new Transaction(
        		1,
        		788750927,
        		"Deposite",
        		2234,
        		"23-07-26",
        		"5:50 AM",
        		"Success"
        		);
        
        Admin admin = new Admin(
                1,
                "Ganesh Patil",
                "MayurGhuge@gmail.com",
                "Pass123"
        );

        System.out.println(admin);

        // Print Customer Details
        System.out.println(customer);

        // Print Account Details
        System.out.println();

        // Print Account Details
        System.out.println(account);
        
        System.out.println();
        
        System.out.println(transaction);
    }
}