package bankapp;

import java.util.ArrayList;
import java.util.Calendar;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private ArrayList<Transaction> transactions; // stores all transactions for this account
    private double monthlyInterestRate = 0.0025; // 0.25% per month
    private Calendar lastInterestDate;

//    So the workaround is that the Account class should have a method to calculate the interest for a given number of months. The method should only calculate interest for savings accounts and add the interest to the account balance.
//    The method should also log the interest transaction in the account's transaction history.
    public Account(String accountNumber, String accountHolderName, String accountType, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>(); // initialize transaction list
        this.lastInterestDate = Calendar.getInstance(); // set current date
        logTransaction("deposit", initialDeposit); // log the initial deposit
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("deposit", amount); // log deposit transaction
            System.out.println("deposit successful. new balance: " + balance);
        } else {
            System.out.println("invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logTransaction("withdrawal", amount); // log withdrawal transaction
            System.out.println("withdrawal successful. new balance: " + balance);
        } else {
            System.out.println("insufficient balance or invalid amount");
        }
    }

    private void logTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount); // create a new transaction
        transactions.add(transaction); // add transaction to the list
    }

    public void displayTransactions() {
        System.out.println("transaction history for account: " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction); // print each transaction's details
        }
    }

    public double getBalance() {
        return balance;
    }

    public void calculateMonthlyInterest(int months) {
        if (accountType.equalsIgnoreCase("savings")) {
            double interest = balance * monthlyInterestRate * months;
            balance += interest;
            logTransaction("interest", interest); // log interest transaction
            System.out.println("interest added for " + months + " month(s). new balance: " + balance);
        } else {
            System.out.println("interest calculation only available for savings accounts");
        }
    }
}
