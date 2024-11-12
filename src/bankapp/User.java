
package bankapp;

import java.util.ArrayList;

// In this class, we do this by creating a User class that has a list of accounts associated with it.
public class User {
    private String username;
    private String password;
    private ArrayList<Account> accounts; // list of accounts for this user

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();   // this is the list of accounts
    }

    public boolean checkLogin(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);  // do not use equalsIgnoreCse coz
//        I wanted the username and pw to be case sensitive
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
