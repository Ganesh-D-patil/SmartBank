
# 🏦 SmartBank – Bank Management System

### Project Summary

**SmartBank** is a Java-based Bank Management System developed to manage basic banking activities in a simple, organized, and secure way. The system provides separate access for **Admin and Customer**, where each user can perform operations according to their role.

The project uses **Core Java, JDBC, and MySQL** to build a complete banking application. It follows a simple **layered architecture** using Model, DAO, Service, and UI layers. This makes the project easy to understand, maintain, and extend.

### 🎯 Problem Statement

In a traditional banking system, managing customers, accounts, money transactions, and transaction records manually can be time-consuming and may lead to errors.

The main problem is to create a system that can:

* Manage customer information
* Create and manage bank accounts
* Maintain account balances
* Perform deposits and withdrawals
* Transfer money between accounts
* Store transaction history
* Provide different access for Admin and Customer
* Keep banking data organized in a database

**SmartBank solves these problems by providing a simple computerized banking system where all important banking operations are managed through Java and stored in MySQL.**

---

## 👨‍💼 Admin Features

The Admin can:

* Login securely
* Add new customers
* View all customers
* Search customers
* Update customer information
* Delete customers
* Open bank accounts
* View accounts
* Deposit money
* Withdraw money
* Transfer money
* View transaction history
* Logout

---

## 👤 Customer Features

After successful login, customers can:

* View their profile
* View account details
* Check current balance
* Deposit money
* Withdraw money
* Transfer money to another account
* View their transaction history
* Logout

---

## 💰 Banking Operations

The system handles the main banking operations:

### Deposit

The amount is added to the customer's account balance and the transaction is recorded.

### Withdraw

The system checks the available balance before withdrawing money. If the balance is insufficient, the transaction is rejected.

### Transfer

The system verifies the sender and receiver accounts, checks the sender's balance, updates both accounts, and records the transaction.

---

## 🛠️ Technologies Used

| Technology    | Use                                             |
| ------------- | ----------------------------------------------- |
| **Java**      | Main programming language                       |
| **Core Java** | OOP, business logic and application development |
| **JDBC**      | Connecting Java application with MySQL          |
| **MySQL**     | Storing customers, accounts and transactions    |
| **Eclipse**   | Development and testing                         |
| **Git**       | Version control                                 |
| **GitHub**    | Project hosting and collaboration               |

---

## 🏗️ Project Architecture

SmartBank follows a simple layered architecture:

```text
User
 ↓
UI Layer
 ↓
Service Layer
 ↓
DAO Layer
 ↓
MySQL Database
```

### Model Layer

Contains classes such as:

```text
Customer
Account
Transaction
Admin
```

### UI Layer

Handles user input and displays the application menus.

### Service Layer

Contains the main business logic.

### DAO Layer

Handles database operations using JDBC.

### Database

MySQL stores all important banking data.

---

## 🗄️ Database

The project uses a MySQL database named:

```text
smartbank
```

Main tables:

```text
admin
customer
account
transaction_history
```

The database maintains relationships between customers, their accounts, and their transactions.

---

## 🔐 Security and Validation

The project includes basic validation such as:

* Login authentication
* Unique customer email and phone
* Unique Aadhaar and PAN
* Checking whether an account exists
* Checking account status
* Preventing withdrawal when balance is insufficient
* Preventing transfer to the same account
* Checking receiver account before transfer
* Validating transaction amounts

---

## 🔄 Basic Application Flow

```text
                SmartBank
                   │
          ┌────────┴────────┐
          ↓                 ↓
       Admin              Customer
          ↓                 ↓
 Admin Dashboard     Customer Dashboard
          │                 │
          └────────┬────────┘
                   ↓
              Service Layer
                   ↓
                DAO Layer
                   ↓
              MySQL Database
```

---

## ⭐ Key Benefits

* Simple and easy-to-use banking system
* Separate Admin and Customer access
* Centralized database management
* Automatic balance updates
* Transaction records are maintained
* Reduces manual work
* Easy to maintain because of layered architecture
* Can be extended with a graphical or web interface in the future

---

## 🚀 Future Improvements

The project can be improved further by adding:

* Modern graphical user interface
* Dynamic Admin Dashboard
* Dynamic Customer Dashboard
* Password encryption
* OTP authentication
* Email/SMS notifications
* PDF bank statements
* Charts and reports
* Spring Boot REST API
* Web or mobile application

---

## 🎓 Project Objective

The main objective of SmartBank is to understand how a real-world banking application can be developed using **Java, JDBC, database management, OOP concepts, and layered architecture**.

It provides practical experience in:

**Java + OOP + JDBC + MySQL + CRUD Operations + Database Relationships + Business Logic + Git/GitHub**

### One-line summary for your resume

> **SmartBank is a Java-based Bank Management System that manages customers, accounts, balances, deposits, withdrawals, transfers, and transaction history using Core Java, JDBC, and MySQL.**

---

## 🎯 Main Objective

The main objective of SmartBank is to create a simple banking system where:

* Customer information can be managed easily.
* Bank accounts can be created and managed.
* Money can be deposited and withdrawn.
* Money can be transferred between accounts.
* Every important transaction can be stored in the database.
* Admin and Customer have different access and features.

---


### Admin Flow

```text
Admin Login
     ↓
Admin Dashboard
     ↓
Manage Customers
     ↓
Manage Accounts
     ↓
Perform Banking Operations
     ↓
View Transactions
     ↓
Logout
```

---


### Customer Flow

```text
Customer Login
       ↓
Customer Dashboard
       ↓
View Profile / Account
       ↓
Check Balance
       ↓
Deposit / Withdraw / Transfer
       ↓
View Transaction History
       ↓
Logout
```

---

# 💰 Banking Operations

### Deposit Money

When a customer deposits money:

```text
Enter Amount
     ↓
Validate Amount
     ↓
Update Account Balance
     ↓
Save Transaction
```

### Withdraw Money

When a customer withdraws money:

```text
Enter Amount
     ↓
Check Available Balance
     ↓
Update Account Balance
     ↓
Save Transaction
```

If the customer does not have enough money, the withdrawal is rejected.

### Transfer Money

For money transfer:

```text
Sender Account
      ↓
Receiver Account
      ↓
Check Accounts
      ↓
Check Sender Balance
      ↓
Deduct Money from Sender
      ↓
Add Money to Receiver
      ↓
Save Transaction
```

This makes the transfer process safer and keeps the account balances updated.

---

# 🗄️ Database

SmartBank uses **MySQL** to store and manage data.

### Main Tables

```text
admin
customer
account
transaction_history
```

### Customer Table

Stores information such as:

* Customer ID
* First Name
* Last Name
* Gender
* Date of Birth
* Email
* Phone
* Address
* Aadhaar Number
* PAN Number
* Password

### Account Table

Stores:

* Account ID
* Account Number
* Customer ID
* Account Type
* Balance
* Account Status
* Account Creation Date

### Transaction History

Stores:

* Transaction ID
* Account ID
* Transaction Type
* Amount
* Transaction Date
* Description

---

# 🏗️ Project Architecture

We use a simple **layered architecture**:

```text
        User
          ↓
         UI
          ↓
       Service
          ↓
         DAO
          ↓
       MySQL
```

### UI Layer

The UI takes input from the user and displays the output.

Examples:

```text
MainMenu
AdminMenu
CustomerMenu
```

### Service Layer

The Service layer contains the **main business logic**.

For example:

* Checking balance
* Validating transactions
* Processing transfers
* Managing customer operations

### DAO Layer

DAO stands for **Data Access Object**.

The DAO layer communicates with MySQL.

Examples:

```text
AdminDAO
CustomerDAO
AccountDAO
TransactionDAO
```

### Model Layer

The Model classes represent our data.

```text
Admin
Customer
Account
Transaction
```

### Utility Layer

`DBConnection.java` is responsible for creating the connection between Java and MySQL.

---

# 🛠️ Technologies Used

| Technology | Purpose                        |
| ---------- | ------------------------------ |
| Java       | Main programming language      |
| Core Java  | Application logic              |
| JDBC       | Connect Java with MySQL        |
| MySQL      | Store application data         |
| Eclipse    | Development environment        |
| Git        | Version control                |
| GitHub     | Code storage and collaboration |

---

# 📂 Project Structure

```text
SmartBank
│
├── dao
│   ├── AdminDAO.java
│   ├── CustomerDAO.java
│   ├── AccountDAO.java
│   └── TransactionDAO.java
│
├── model
│   ├── Admin.java
│   ├── Customer.java
│   ├── Account.java
│   └── Transaction.java
│
├── service
│   ├── CustomerService.java
│   ├── AccountService.java
│   └── TransactionService.java
│
├── ui
│   ├── MainMenu.java
│   ├── AdminMenu.java
│   └── CustomerMenu.java
│
├── util
│   └── DBConnection.java
│
├── main
│   └── Main.java
│
└── README.md
```

---

# 🔐 Login System

SmartBank provides separate login systems for Admin and Customer.

### Admin Login

```text
Username: Ganesh
Password: Ganesh123
```

### Customer Login

Customer uses the email and password stored in the database.

Example:

```text
Email: gp0834603@gmail.com
Password: Ganesh123
```

> These are demo credentials. Use dummy credentials when sharing the project publicly.

---

# 🔄 How the System Works

The complete application works like this:

```text
                    SmartBank
                       │
              ┌────────┴────────┐
              ↓                 ↓
           Admin              Customer
              │                 │
              ↓                 ↓
        Admin Dashboard   Customer Dashboard
              │                 │
              └────────┬────────┘
                       ↓
                   Service
                       ↓
                     DAO
                       ↓
                    MySQL
```

This structure keeps the project organized and makes it easier to maintain and extend.

---

# ✅ Current Project Status

The main banking features are completed and tested.

### Admin Module

**100% Complete ✅**

### Customer Module

**100% Complete ✅**

### Database Integration

**100% Complete ✅**

### Banking Operations

**100% Complete ✅**

### Testing

**Completed ✅**

---


# 🚀 SmartBank Project Setup

Follow these steps to run SmartBank on a new computer.

## 1. Install Required Software

Install:

* **JDK 17 or above**
* **Eclipse IDE**
* **MySQL Server**
* **MySQL Workbench**
* **Git**

Check Java:

```bash
java -version
```

Check Git:

```bash
git --version
```

Make sure MySQL Server is running.

---

## 2. Clone the Project

Open Command Prompt or Terminal:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Then open the cloned project in Eclipse.

In Eclipse:

```text
File
→ Import
→ Existing Projects into Workspace
→ Select SmartBank folder
→ Finish
```

---

## 3. Create the MySQL Database

Open **MySQL Workbench**.

Run:

```sql
CREATE DATABASE smartbank;
```

Then:

```sql
USE smartbank;
```

---

## 4. Create the Tables

The project should contain:

```text
database/
└── smartbank.sql
```

Open `smartbank.sql` in MySQL Workbench and execute it.

It will create:

```text
admin
customer
account
transaction_history
```

It should also contain some **sample/demo data**.

---

## 5. Configure Database Connection

Open:

```text
src
└── util
    └── DBConnection.java
```

Update the MySQL details:

```java
String url = "jdbc:mysql://localhost:3306/smartbank";
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
```

Replace:

```text
YOUR_MYSQL_PASSWORD
```

with the MySQL password of that computer.

### Important

Do **not** upload your actual MySQL password to GitHub.

---

## 6. Add MySQL JDBC Driver

SmartBank uses JDBC to connect Java with MySQL.

Make sure **MySQL Connector/J** is added to the Eclipse project's Build Path.

In Eclipse:

```text
Right-click Project
→ Build Path
→ Configure Build Path
→ Libraries
→ Add External JARs
```

Select the MySQL Connector/J `.jar` file.

---

## 7. Run the Project

Open:

```text
src
└── main
    └── Main.java
```

Right-click:

```text
Main.java
→ Run As
→ Java Application
```

You should see:

```text
1. Admin Login
2. Customer Login
3. Exit
```

---

# 🔐 Demo Login

### Admin

```text
Username : Ganesh
Password : Ganesh123
```

### Customer

Use the customer account created in the SQL file.

Example:

```text
Email    : gp0834603@gmail.com
Password : Ganesh123
```

---

# ⚠️ Common Problems and Solutions

## Problem 1 — `java is not recognized`

### Solution

Install JDK and add Java to the system PATH.

Check:

```bash
java -version
```

---

## Problem 2 — `Database Connection Failed`

Check:

```text
✓ MySQL Server is running
✓ Database name is smartbank
✓ Username is correct
✓ Password is correct
✓ Port is 3306
```

Also check `DBConnection.java`.

---

## Problem 3 — `Unknown database 'smartbank'`

Run:

```sql
CREATE DATABASE smartbank;
```

Then execute:

```text
database/smartbank.sql
```

---

## Problem 4 — `Table doesn't exist`

Example:

```text
Table 'smartbank.customer' doesn't exist
```

### Solution

Open `smartbank.sql` in MySQL Workbench and execute it again.

Then check:

```sql
USE smartbank;

SHOW TABLES;
```

You should see:

```text
admin
customer
account
transaction_history
```

---

## Problem 5 — `Access denied for user 'root'`

This means the MySQL username/password is wrong.

Update:

```java
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
```

in `DBConnection.java`.

---

## Problem 6 — `ClassNotFoundException: com.mysql.cj.jdbc.Driver`

### Solution

MySQL Connector/J is missing.

Add the MySQL Connector/J `.jar` to the Eclipse **Build Path**.

---

## Problem 7 — `Communications link failure`

Usually MySQL Server is not running.

### Solution

Start **MySQL Server** and run the project again.

---

## Problem 8 — Port 3306 problem

Your MySQL server may be running on another port.

Check the MySQL port in Workbench.

If it is different, change:

```java
jdbc:mysql://localhost:3306/smartbank
```

For example, if the port is `3307`:

```java
jdbc:mysql://localhost:3307/smartbank
```

---

## Problem 9 — Project does not appear correctly in Eclipse

Make sure you import the **whole SmartBank project folder**, not only the `src` folder.

Use:

```text
File
→ Import
→ Existing Projects into Workspace
```

---

## Problem 10 — Customer/Admin login doesn't work

First check whether the data exists:

```sql
USE smartbank;

SELECT * FROM admin;

SELECT * FROM customer;
```

If the tables are empty, execute the sample data section of:

```text
database/smartbank.sql
```

---

# ✅ Quick Setup Summary

For someone who wants the shortest version:

```text
1. Install JDK
        ↓
2. Install Eclipse
        ↓
3. Install MySQL + Workbench
        ↓
4. Clone SmartBank from GitHub
        ↓
5. Open project in Eclipse
        ↓
6. Create smartbank database
        ↓
7. Run database/smartbank.sql
        ↓
8. Configure DBConnection.java
        ↓
9. Add MySQL Connector/J
        ↓
10. Run Main.java
        ↓
11. Login and use SmartBank
```

