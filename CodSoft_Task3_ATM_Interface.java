import java.util.Scanner;
public class CodSoft_Task3_ATM_Interface {
    static class BankAccount {
        private double balance;
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }
        public double checkBalance() {
            return balance;
        }
    }
    static class ATM {
        private BankAccount account;
        public ATM(BankAccount account) {
            this.account = account;
        }
        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the ATM");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            while (true) {

                System.out.print("Please select an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
        private void deposit() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            if (account.deposit(amount)) {
                System.out.println("Deposit successful. Your new balance is: " + account.checkBalance());
            } else {
                System.out.println("Deposit failed. Please enter a valid amount.");
            }
        }
        private void withdraw() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Your new balance is: " + account.checkBalance());
            } else {
                System.out.println("Withdrawal failed. Please ensure you have sufficient balance and enter a valid amount.");
            }
        }
        private void checkBalance() {
            System.out.println("Your current balance is: " + account.checkBalance());
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}


