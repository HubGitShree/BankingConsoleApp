# Bank Management Console App

This is a simple console-based bank management application. It allows users to register, login, open accounts, deposit and withdraw money, check balances, view transaction history, and calculate interest for savings accounts.


## Classes

### User

Represents a user with a list of accounts.

- [`User(String username, String password)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/User.java )
- [`boolean checkLogin(String inputUsername, String inputPassword)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`void addAccount(Account account)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`ArrayList<Account> getAccounts()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )

### Account

Represents a bank account with transactions and interest calculation.

- [`Account(String accountNumber, String accountHolderName, String accountType, double initialDeposit)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`void deposit(double amount)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`void withdraw(double amount)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`double getBalance()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`void displayTransactions()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`void calculateMonthlyInterest(int months)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )

### Transaction

Represents a transaction with a unique ID, date, type, and amount.

- [`Transaction(String type, double amount)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Transaction.java )
- [`String toString()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Transaction.java )

### Main

Contains the main method and various static methods to handle user interactions.

- [`static void main(String[] args)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void displayMainOptions()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void displayUserOptions()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static int getChoice(Scanner input)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void register(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void login(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void openAccount(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void deposit(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`static void withdraw(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Account.java )
- [`static void checkBalance()`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void viewTransactionHistory(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static void calculateInterest(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )
- [`static Account selectAccount(Scanner scanner)`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java )

## Usage

1. Run the [`Main`](../../../../../c:/Users/HP/IdeaProjects/BankManagementConsoleApp/src/bankapp/Main.java ) class.
2. Follow the on-screen instructions to register, login, and manage your bank accounts.

## Example

```sh
javac src/bankapp/*.java
java -cp src bankapp.Main
