package bankapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//    since this is not a persistent application requiring db, we can use a static ArrayList variable to store the data.
    private static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        menu driven approach to display the options to the user
        while (true) {
            if (loggedInUser == null) {
                displayMainOptions();
                int choice = getChoice(input);

                switch (choice) {
                    case 1 -> register(input);
                    case 2 -> login(input);
                    case 3 -> {
                        System.out.println(
                                "     🙏🙏\n");


                        System.out.println("thank you for using bank application");
                        return;
                    }
                    default -> System.out.println("invalid choice, please try again");
                }
            } else {
                displayUserOptions();
                int choice = getChoice(input);


//                new syntax as explained by Elan Sir.
                switch (choice) {
                    case 1 -> openAccount(input);
                    case 2 -> deposit(input);
                    case 3 -> withdraw(input);
                    case 4 -> checkBalance();
                    case 5 -> viewTransactionHistory(input);
                    case 6 -> calculateInterest(input);
                    case 7 -> {
                        loggedInUser = null;
                        System.out.println("logged out successfully");
                    }
                    default -> System.out.println("invalid choice, please try again");
                }
            }
        }
    }

//    display the main options
    private static void displayMainOptions() {
        System.out.println("############################### Welcome to bank application #####################################");
        System.out.println();
        System.out.println("please select an option:");
        System.out.println("1. register");
        System.out.println("2. login");
        System.out.println("3. exit");
    }

//    method to display the user options once logged in
    private static void displayUserOptions() {
        System.out.println("1. open account");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("4. check balance");
        System.out.println("5. view transaction history");
        System.out.println("6. calculate interest (savings only)");
        System.out.println("7. logout");
    }

//    method to get the choice from the user
//    error handling inputmismatch exception
    private static int getChoice(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("please enter a valid number");
            input.nextLine();
            return -1;
        }
    }
//    method to register the user -> username and password
//    notice that the method takes a scanner object as an argument ( IMPORTANT)
    private static void register(Scanner scanner) {
        System.out.print("enter username: ");
        String username = scanner.next();
        System.out.print("enter password: ");
        String password = scanner.next();

        users.add(new User(username, password));
        System.out.println("registration successful");
    }


    private static void login(Scanner scanner) {
        System.out.print("enter username: ");
        String username = scanner.next();
        System.out.print("enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.checkLogin(username, password)) {
                loggedInUser = user;
                System.out.println("login successful");
                return;
            }
        }
        System.out.println("invalid username or password");
    }

//    method to open an account
    private static void openAccount(Scanner scanner) {
        System.out.print("enter account holder name: ");
        scanner.nextLine(); // clear buffer | also known as buffer flush
        String accountHolderName = scanner.nextLine();
        System.out.print("enter account type (savings/checking): ");
        String accountType = scanner.nextLine();

        if (!accountType.equalsIgnoreCase("savings") && !accountType.equalsIgnoreCase("checking")) {
            System.out.println("invalid account type. please enter 'savings' or 'checking'.");
            return;
        }

        try {
            System.out.print("enter initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            if (initialDeposit <= 0) {
                System.out.println("initial deposit must be greater than zero");
                return;
            }

            Account newAccount = new Account(String.valueOf(loggedInUser.getAccounts().size() + 1), accountHolderName, accountType, initialDeposit);
            loggedInUser.addAccount(newAccount);
            System.out.println("account opened successfully");
        } catch (InputMismatchException e) {
            System.out.println("please enter a valid number for the initial deposit");
            scanner.nextLine(); // clear invalid input
        }
    }

//    method to deposit the amount
    private static void deposit(Scanner scanner) {
        Account account = selectAccount(scanner);
        if (account != null) {
            try {
                System.out.print("enter deposit amount: ");
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("deposit amount must be greater than zero");
                } else {
                    account.deposit(amount);
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number for deposit");
                scanner.nextLine();
            }
        }
    }

//    method to withdraw the amount
    private static void withdraw(Scanner scanner) {
        Account account = selectAccount(scanner);
        if (account != null) {
            try {
                System.out.print("enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("withdrawal amount must be greater than zero");
                } else {
                    account.withdraw(amount);
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number for withdrawal");
                scanner.nextLine();
            }
        }
    }

//    methid to check balance
    private static void checkBalance() {
        for (Account account : loggedInUser.getAccounts()) {
            System.out.println("account balance: " + account.getBalance());
        }
    }

//    method to view the transaction history
    private static void viewTransactionHistory(Scanner scanner) {
        Account account = selectAccount(scanner);
        if (account != null) {
            account.displayTransactions();
        }
    }

    private static void calculateInterest(Scanner scanner) {
        Account account = selectAccount(scanner);
        if (account != null) {
            System.out.println(" how many months of interest to calculate?");
            int months = getChoice(scanner);
            account.calculateMonthlyInterest(months);
        }
    }

    private static Account selectAccount(Scanner scanner) {
        ArrayList<Account> accounts = loggedInUser.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("no accounts available");
            return null;
        }

        System.out.println("select an account:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". account balance: " + accounts.get(i).getBalance());
        }

        int choice = getChoice(scanner);
        if (choice < 1 || choice > accounts.size()) {
            System.out.println("invalid choice");
            return null;
        }
        return accounts.get(choice - 1);
    }
}
