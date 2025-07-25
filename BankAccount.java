public class BankAccount {
    private String accountHolderName;
    private double balance;
    private int pin;

    public BankAccount(String name, double initialBalance, int pin) {
        this.accountHolderName = name;
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public String getName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    public int getPin() {
        return pin;
    }
}