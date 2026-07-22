package main;

import model.Account;
import model.Customer;

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

        // Print Customer Details
        System.out.println(customer);

        // Print Account Details
        System.out.println();

        // Print Account Details
        System.out.println(account);
    }
}