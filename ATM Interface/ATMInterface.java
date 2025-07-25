import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 5 user accounts
        BankAccount[] users = {
            new BankAccount("Ajay", 5000.0, 1111),
            new BankAccount("Sneha", 6000.0, 2222),
            new BankAccount("Ravi", 4500.0, 3333),
            new BankAccount("Divya", 7000.0, 4444),
            new BankAccount("Kiran", 3000.0, 5555)
        };

        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();
        BankAccount currentUser = null;

        // Find the user with the matching PIN
        for (BankAccount user : users) {
            if (user.verifyPin(enteredPin)) {
                currentUser = user;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        System.out.println("Welcome " + currentUser.getName() + "!");

        int choice;
        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: ₹" + currentUser.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    currentUser.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    currentUser.withdraw(withdraw);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();
                    currentUser.changePin(newPin);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. visit again!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}