package model;

public class Transaction {

	private int transactionId;
	private long accountNumber;
	private String transactionType;
	private double amount;
	private String transactionDate;
	private String transactionTime;
	private String status;
	
	public Transaction() {
		
	} 
public Transaction(int tansactionId, long accountNumber, String transactionType, double amount, String transactionDate, String transactionTime, 
		String status) {
	
	this.transactionId = transactionId;
	this.accountNumber = accountNumber;
	this.transactionType = transactionType;
	this.amount = amount;
	this.transactionDate = transactionDate;
	this.transactionTime = transactionTime;
	this.status = status;
		
	} 

public int gettransactionId() {
	return transactionId;
}
public void settransactionId(int transactionId) {
	this.transactionId = transactionId;
}

public long getaccountNumber() {
	return accountNumber;
}

public void setaccountNumber(long accountNumber) {
	this.accountNumber=accountNumber;
}

public String gettransactionType() {
	return transactionType;
}
public void settransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public double getamount() {
	return amount;
}
public void setamount(double amount) {
	this.amount=amount;
}
public String gettransactionDate() {
	return transactionDate;
}
public void settransactionDate(String transactionDate) {
	this.transactionDate = transactionDate;
}
public String gettransactionTime() {
	return transactionTime ;
}
public void settransactionTime(String transactionTime) {
	this.transactionTime = transactionTime ;
}
public String getstatus() {
	return status ;
}

public void setstatus(String status) {
	this.status = status;
	
}
@Override
public String toString() {
	return "Transaction [transactionId=" + transactionId + "\n"+
", accountNumber=" + accountNumber + "\n"+
			", transactionType="
			+ transactionType + "\n"+
			", amount=" + amount + "\n"+
			", transactionDate=" + transactionDate + "\n"+
			", transactionTime="
			+ transactionTime + "\n"+
			", status=" + status + "]";
}
}
