import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;

    public CheckingAccount() {
        this.balance = 0.0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();
        account.start();
    }

    @Override
    public String menu() {
        return "Checking Account Menu:\n" + "1) Check Balance\n" +  "2) Make Deposit\n" +"3) Make Withdrawal\n" + "0) Exit\n" + "Choose an action:";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(menu());
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                case 0:
                    System.out.println("Exiting Checking Account.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Getters and Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    private double getDouble() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        while (!scanner.hasNextDouble()) { 
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }
    

    public void checkBalance() {
        System.out.println("Your current balance is: " + getBalanceString());
    }

    public void makeDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = getDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + getBalanceString());
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    public void makeWithdrawal() {
        System.out.print("Enter withdrawal amount: ");
        double amount = getDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + getBalanceString());
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid amount. Withdrawal must be positive.");
        }
    }
}
