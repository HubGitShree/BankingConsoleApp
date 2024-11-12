package bankapp;

import java.util.Date;
import java.util.UUID;

//the transaction class should have the following attributes:
//transactionId: a unique identifier for the transaction
//date: the date and time when the transaction occurred


public class Transaction {
    private String transactionId;
    private Date date;
    private String type; // "deposit" or "withdrawal"
    private double amount;

    public Transaction(String type, double amount) {
        this.transactionId = UUID.randomUUID().toString(); // generate unique ID
        this.date = new Date(); // set current date
        this.type = type;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Date: " + date + ", Type: " + type + ", Amount: " + amount;
    }
}
