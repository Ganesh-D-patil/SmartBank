package model;

public class Account {

    private long accountNumber;
    private int customerId;
    private String accountType;
    private double balance;
    private String status;

    // Default Constructor
    public Account() {
    }

    // Parameterized Constructor
    public Account(long accountNumber, 
    		int customerId, 
    		String accountType,
            double balance,
            String status) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber +"\n"+
               ", customerId=" + customerId +"\n"+
               ", accountType=" + accountType +"\n"+
               ", balance=" + balance +"\n"+
               ", status=" + status + "]";
    }
}