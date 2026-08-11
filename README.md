
# 🏦 SmartBank – Bank Management System

## 📌 Project Summary

**SmartBank** is a Java-based Bank Management System developed to manage basic banking activities in a simple, organized, and reliable way.
The system provides separate access for **Admin and Customer**, where each user can perform operations according to their role.
SmartBank uses **Core Java, JDBC, and MySQL** and follows a simple **layered architecture** using Model, DAO, Service, and UI layers.
The project demonstrates how a real-world banking application can be developed using Java, Object-Oriented Programming, database connectivity, CRUD operations, business logic, and transaction management.

---

# 🎯 Problem Statement

Traditional manual banking processes for managing customers, accounts, balances, and transactions can be time-consuming and may lead to errors.

The main problem is to develop a system that can:

- Manage customer information
- Create and manage bank accounts
- Maintain account balances
- Perform deposits and withdrawals
- Transfer money between accounts
- Maintain transaction history
- Provide separate Admin and Customer access
- Store banking information in a centralized database
- Reduce manual work and improve data management

**SmartBank solves these problems by providing a computerized banking system where important banking operations are handled through Java and stored in a MySQL database.**

---

# 🎯 Project Objectives

The main objectives of SmartBank are:

- To develop a simple banking management system using Java.
- To manage customer and account information.
- To perform basic banking operations.
- To maintain accurate account balances.
- To record banking transactions.
- To implement Admin and Customer role-based access.
- To connect a Java application with MySQL using JDBC.
- To understand layered architecture and database relationships.
- To gain practical experience with CRUD operations and business logic.

---

# 👨‍💼 Admin Features

The Admin can:

- Login
- Add new customers
- View all customers
- Search customers
- Update customer information
- Delete customers
- Open bank accounts
- View accounts
- Deposit money
- Withdraw money
- Transfer money
- View transaction history
- Logout

---

# 👤 Customer Features

After successful login, customers can:

- View their profile
- View account details
- Check current balance
- Deposit money
- Withdraw money
- Transfer money to another account
- View transaction history
- Logout

---

# 💰 Banking Operations

## Deposit Money

When a customer deposits money:

```text
Enter Amount
     ↓
Validate Amount
     ↓
Update Account Balance
     ↓
Record Transaction
````

The deposit amount is added to the account balance and the transaction is recorded in the database.

---

## Withdraw Money

When a customer withdraws money:

```text
Enter Amount
     ↓
Validate Amount
     ↓
Check Available Balance
     ↓
Update Account Balance
     ↓
Record Transaction
```

If the available balance is insufficient, the withdrawal is rejected.

---

## Transfer Money

For a money transfer:

```text
Sender Account
      ↓
Receiver Account
      ↓
Validate Accounts
      ↓
Check Sender Balance
      ↓
Deduct Money from Sender
      ↓
Add Money to Receiver
      ↓
Record Transaction
```

The system verifies both accounts, checks the sender's balance, updates both accounts, and records the transaction.

---

# 🔐 Login and Access Control

SmartBank provides separate login systems for:

```text
Admin
  ↓
Admin Dashboard
```

and

```text
Customer
  ↓
Customer Dashboard
```

Customers log in using their registered email and password.

Admin and Customer users have different permissions and menu options.

> **Security Note:** Actual database passwords, MySQL credentials, Aadhaar numbers, PAN numbers, phone numbers, and other personal information should not be stored in this public README or committed to GitHub.

---

# 🏗️ Project Architecture

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

## Model Layer

The Model layer represents the application's data.

Main model classes include:

```text
Admin
Customer
Account
Transaction
```

---

## UI Layer

The UI layer handles user input and displays menus and results.

Main UI classes include:

```text
MainMenu
AdminMenu
CustomerMenu
```

---

## Service Layer

The Service layer contains the main business logic of the application.

It handles operations such as:

* Customer management
* Account management
* Balance checking
* Deposit processing
* Withdrawal processing
* Money transfer
* Transaction management
* Validation

---

## DAO Layer

DAO stands for **Data Access Object**.

The DAO layer communicates with the MySQL database using JDBC.

Main DAO classes include:

```text
AdminDAO
CustomerDAO
AccountDAO
TransactionDAO
```

The DAO layer performs operations such as:

* Insert
* Select
* Update
* Delete
* Search

---

## Utility Layer

The utility layer contains common utility classes.

For example:

```text
DBConnection.java
```

`DBConnection.java` is responsible for creating the connection between the Java application and MySQL.

---

# 🗄️ Database

SmartBank uses **MySQL** as its database.

Database name:

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

The database maintains relationships between customers, accounts, and transactions.

---

## Customer Table

The customer table stores customer information such as:

* Customer ID
* Name
* Gender
* Date of Birth
* Email
* Phone
* Address
* Aadhaar Number
* PAN Number
* Password

---

## Account Table

The account table stores:

* Account ID
* Account Number
* Customer ID
* Account Type
* Balance
* Account Status
* Account Creation Date

---

## Transaction History Table

The transaction history table stores:

* Transaction ID
* Account ID
* Transaction Type
* Amount
* Transaction Date
* Description

---

## Admin Table

The admin table stores administrator login and related information required for Admin access.

---

# 🔄 Application Flow

## Admin Flow

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

## Customer Flow

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

# 🛠️ Technologies Used

| Technology          | Purpose                                                      |
| ------------------- | ------------------------------------------------------------ |
| **Java**            | Main programming language                                    |
| **Core Java**       | OOP, business logic, collections and application development |
| **JDBC**            | Connects Java application with MySQL                         |
| **MySQL**           | Stores customers, accounts and transaction data              |
| **Eclipse IDE**     | Development and testing                                      |
| **Git**             | Version control                                              |
| **GitHub**          | Source code hosting and project management                   |
| **MySQL Workbench** | Database development and management                          |

---

# 📂 Project Structure

```text
SmartBank
│
├── src
│   │
│   ├── dao
│   │   ├── AdminDAO.java
│   │   ├── CustomerDAO.java
│   │   ├── AccountDAO.java
│   │   └── TransactionDAO.java
│   │
│   ├── model
│   │   ├── Admin.java
│   │   ├── Customer.java
│   │   ├── Account.java
│   │   └── Transaction.java
│   │
│   ├── service
│   │   ├── CustomerService.java
│   │   ├── AccountService.java
│   │   └── TransactionService.java
│   │
│   ├── ui
│   │   ├── MainMenu.java
│   │   ├── AdminMenu.java
│   │   └── CustomerMenu.java
│   │
│   ├── util
│   │   └── DBConnection.java
│   │
│   └── main
│       └── Main.java
│
├── database
│   └── smartbank.sql
│
├── README.md
├── .gitignore
├── .classpath
└── .project
```

---

# 🔐 Security and Validation

The project includes basic validation and security checks such as:

* Admin authentication
* Customer authentication
* Unique customer email
* Unique customer phone
* Unique Aadhaar number
* Unique PAN number
* Account existence validation
* Account status validation
* Transaction amount validation
* Insufficient balance checking
* Receiver account validation
* Prevention of transfer to the same account
* Database-level constraints where applicable

> **Note:** The current project uses basic authentication. Password hashing/encryption and advanced authentication can be added in future versions.

---

# ⭐ Key Benefits

SmartBank provides:

* Simple and organized banking operations
* Separate Admin and Customer access
* Centralized database management
* Automatic balance updates
* Transaction history management
* CRUD operations for customer and account management
* Validation for important banking operations
* Layered architecture for easier maintenance
* Easy database setup using the included SQL file
* Easy source-code management using Git and GitHub

---

# 🚀 Future Improvements

The project can be extended with:

* Modern graphical user interface
* Dynamic Admin Dashboard
* Dynamic Customer Dashboard
* Password hashing and encryption
* OTP authentication
* Email and SMS notifications
* PDF bank statements
* Charts and financial reports
* Spring Boot REST API
* Web application
* Mobile application
* Role-based security using Spring Security
* Automated testing

---

# 📊 Current Project Status

The core SmartBank banking functionality has been implemented and tested.

| Module                  | Status      |
| ----------------------- | ----------- |
| Admin Login             | ✅ Completed |
| Customer Login          | ✅ Completed |
| Customer Management     | ✅ Completed |
| Account Management      | ✅ Completed |
| View Profile            | ✅ Completed |
| View Account            | ✅ Completed |
| Check Balance           | ✅ Completed |
| Deposit Money           | ✅ Completed |
| Withdraw Money          | ✅ Completed |
| Transfer Money          | ✅ Completed |
| Transaction History     | ✅ Completed |
| Database Integration    | ✅ Completed |
| Admin Module            | ✅ Completed |
| Customer Module         | ✅ Completed |
| Core Testing            | ✅ Completed |
| Database SQL Setup File | ✅ Added     |
| README Documentation    | ✅ Completed |

---

# 🚀 Project Setup

Follow these steps to run SmartBank on another computer.

## 1. Install Required Software

Install the following:

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

# 2. Clone the Project

Open Command Prompt or Terminal:

```bash
git clone https://github.com/Ganesh-D-patil/SmartBank.git
```

Move into the project:

```bash
cd SmartBank
```

---

# 3. Import the Project into Eclipse

Open Eclipse.

Go to:

```text
File
→ Import
→ Existing Projects into Workspace
→ Select SmartBank folder
→ Finish
```

Make sure you select the complete project folder, not only the `src` folder.

---

# 4. Create the MySQL Database

Open **MySQL Workbench**.

Create the database:

```sql
CREATE DATABASE smartbank;
```

Then select it:

```sql
USE smartbank;
```

---

# 5. Run the SQL File

The project contains:

```text
database/
└── smartbank.sql
```

Open:

```text
database/smartbank.sql
```

in MySQL Workbench and execute the SQL script.

The script creates the required database tables and may contain safe sample/demo data.

After execution, verify the tables:

```sql
USE smartbank;

SHOW TABLES;
```

Expected tables:

```text
admin
customer
account
transaction_history
```

---

# 6. Configure Database Connection

Open:

```text
src
└── util
    └── DBConnection.java
```

Configure the database connection according to the local MySQL installation:

```java
String url = "jdbc:mysql://localhost:3306/smartbank";
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
```

Replace:

```text
YOUR_MYSQL_PASSWORD
```

with the MySQL password of the local computer.

### Important Security Rule

**Never commit your actual MySQL password to GitHub.**

For a public repository, use a local configuration method or environment variable instead of storing the password directly in source code.

---

# 7. Add MySQL JDBC Driver

SmartBank uses JDBC to connect Java with MySQL.

Make sure **MySQL Connector/J** is available in the Eclipse project.

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

# 8. Run the Project

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

The application should display the main menu.

For example:

```text
1. Admin Login
2. Customer Login
3. Exit
```

---

# 🔑 Demo Login

The SQL file can contain safe demo users for testing.

Use the credentials provided in the SQL file or create your own user through the application.

**Do not use real personal information or real passwords in the demo database.**

---

# ⚠️ Common Problems and Solutions

## Problem 1 — `java is not recognized`

### Solution

Install the JDK and configure the Java PATH.

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
✓ MySQL port is correct
✓ JDBC driver is available
```

Also check:

```text
DBConnection.java
```

---

## Problem 3 — `Unknown database 'smartbank'`

Create the database:

```sql
CREATE DATABASE smartbank;
```

Then execute:

```text
database/smartbank.sql
```

---

## Problem 4 — `Table doesn't exist`

For example:

```text
Table 'smartbank.customer' doesn't exist
```

### Solution

Execute:

```text
database/smartbank.sql
```

again in MySQL Workbench.

Then check:

```sql
USE smartbank;

SHOW TABLES;
```

---

## Problem 5 — `Access denied for user 'root'`

This means the MySQL username or password is incorrect.

Update the local values in:

```text
DBConnection.java
```

---

## Problem 6 — `ClassNotFoundException: com.mysql.cj.jdbc.Driver`

### Solution

The MySQL JDBC driver is missing.

Add the **MySQL Connector/J** `.jar` file to the Eclipse Build Path.

---

## Problem 7 — `Communications link failure`

Usually this means that MySQL Server is not running or the connection settings are incorrect.

### Solution

1. Start MySQL Server.
2. Check the username.
3. Check the password.
4. Check the database name.
5. Check the MySQL port.

---

## Problem 8 — MySQL Port Problem

The default MySQL port is usually:

```text
3306
```

If MySQL is running on another port, update the JDBC URL.

For example:

```java
jdbc:mysql://localhost:3307/smartbank
```

---

## Problem 9 — Project Does Not Import Correctly

Make sure you import the complete:

```text
SmartBank
```

project folder.

Do not import only:

```text
src
```

Use:

```text
File
→ Import
→ Existing Projects into Workspace
```

---

## Problem 10 — Admin or Customer Login Does Not Work

Check whether the required data exists:

```sql
USE smartbank;

SELECT * FROM admin;

SELECT * FROM customer;
```

If the tables are empty, check the sample data in:

```text
database/smartbank.sql
```

---

# 🧪 Basic Testing

The following major operations should be tested:

### Admin

* Admin login
* Add customer
* View customers
* Search customer
* Update customer
* Delete customer
* Create account
* View account
* Deposit
* Withdraw
* Transfer
* Transaction history
* Logout

### Customer

* Customer login
* View profile
* View account
* Check balance
* Deposit
* Withdraw
* Transfer
* Transaction history
* Logout

### Validation

Test cases should include:

* Invalid login
* Invalid amount
* Insufficient balance
* Invalid account number
* Invalid receiver account
* Transfer to same account
* Invalid customer information
* Database connection failure

---

# 📦 Database Setup for Another System

The project includes:

```text
database/smartbank.sql
```

This file makes database setup easier for anyone who clones the project.

The basic process is:

```text
Clone Project
      ↓
Install MySQL
      ↓
Create smartbank Database
      ↓
Execute smartbank.sql
      ↓
Tables Created
      ↓
Configure DBConnection.java
      ↓
Run Main.java
```

The SQL file is a **database setup script**. It does not connect the remote computer to the developer's local MySQL database. Each user runs the SQL file on their own MySQL installation.

---

# 📌 One-Line Resume Description

> **SmartBank is a Java-based Bank Management System that manages customers, accounts, balances, deposits, withdrawals, transfers, and transaction history using Core Java, JDBC, and MySQL.**

---

# 🎓 Project Learning

Through this project, we gained practical experience in:

```text
Core Java
     +
OOP Concepts
     +
JDBC
     +
MySQL
     +
CRUD Operations
     +
Database Relationships
     +
Business Logic
     +
Validation
     +
Layered Architecture
     +
Git & GitHub
```

---

# 👨‍💻 Project Information

**Project Name:** SmartBank – Bank Management System

**Type:** Java Console-Based Banking Application

**Backend:** Core Java + JDBC

**Database:** MySQL

**IDE:** Eclipse

**Version Control:** Git

**Repository:** GitHub

---

# ⭐ Conclusion

SmartBank is a simple banking application developed to understand the design and implementation of a real-world banking system.

The project combines **Java, OOP, JDBC, MySQL, CRUD operations, business logic, validation, layered architecture, and Git/GitHub** into one practical application.

The current system provides separate Admin and Customer functionality and supports the major banking operations required for a basic Bank Management System.

The architecture also provides a foundation for future improvements such as a graphical interface, web application, REST APIs, stronger security, notifications, and reporting.

````

