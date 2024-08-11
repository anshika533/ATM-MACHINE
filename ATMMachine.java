import java.util.ArrayList;
import java.util.Scanner;

public class ATMMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000, deposit, withdraw, pin = 1234;
        ArrayList<String> transactionHistory = new ArrayList<>();

        System.out.println("Welcome to the ATM Machine!");

        // PIN validation
        System.out.println("Please enter your PIN:");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Exiting...");
            System.exit(0);
        }

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. PIN Change");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount you want to deposit:");
                    deposit = sc.nextInt();
                    balance = balance + deposit;
                    transactionHistory.add("Deposited: " + deposit);
                    System.out.println("Your updated balance is: " + balance);
                    break;

                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        transactionHistory.add("Withdrew: " + withdraw);
                        System.out.println("Please collect your cash.");
                        System.out.println("Your updated balance is: " + balance);
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;

                case 3:
                    System.out.println("Your account balance is: " + balance);
                    break;

                case 4:
                    System.out.println("Enter your current PIN:");
                    enteredPin = sc.nextInt();
                    if (enteredPin == pin) {
                        System.out.println("Enter your new PIN:");
                        int newPin = sc.nextInt();
                        pin = newPin;
                        System.out.println("PIN successfully changed.");
                        transactionHistory.add("PIN changed.");
                    } else {
                        System.out.println("Incorrect current PIN!");
                    }
                    break;

                case 5:
                    System.out.println("Transaction History:");
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions available.");
                    } else {
                        for (String transaction : transactionHistory) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
