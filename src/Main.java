import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account account = new Account("John Doe", 10000, "123456789");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome John Doe");

            System.out.println("");

            System.out.println("1. Make a Transfer");

            System.out.println("2. Check Balance");

            System.out.println("3. Exit");

            System.out.print("Select an option from the Menu: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    makeTransfer(account, scanner);

                    break;

                case 2:

                    System.out.println("Current balance: $" + account.getBalance());

                    break;

                case 3:

                    System.out.println("Thank you and GoodBye!");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Option not availlable. Please select an option from the Menu.");
            }
        }
    }

    private static void makeTransfer(Account account, Scanner scanner) {

        System.out.print("Enter the amount you would like to transfer: ");

        int amount = scanner.nextInt();

        try {

            account.transfer(amount);

            System.out.println("Transfer sent successfully. Your new account balance is: $" + account.getBalance());

        } catch (NotEnoughMoneyException e) {

            System.err.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.err.println("Error, Please restart the Program: " + e.getMessage());
        }
    }
}