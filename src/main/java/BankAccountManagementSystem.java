import java.util.Scanner;

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Account");
//            System.out.println("2. Deposit Money");
//            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    System.out.println("Choose account type:");
//                    System.out.println("1. Current account");
//                    System.out.println("2. Savings account");
//                    int accountType = scanner.nextInt();
                    int accountType = 0;
                    while (true) {
                        System.out.println("Choose account type:");
                        System.out.println("1. Current account");
                        System.out.println("2. Savings account");
                        System.out.print("Enter your choice: ");

                        if (scanner.hasNextInt()) {
                            accountType = scanner.nextInt();
                            if (accountType == 1 || accountType == 2) {
                                break;  // valid input, exit loop
                            } else {
                                System.out.println("Invalid account type. Please enter 1 or 2.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                        }
                    }

                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.next();
                    scanner.nextLine(); // consume leftover newline
                    if (bankService.findAccount(accountNumber) != null) {
                        System.out.println("Account with account number " + accountNumber + " already exists.");
                    } else {
                        System.out.println("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();
                        System.out.println("Enter initial deposit amount: ");
                        double initialDeposit = scanner.nextDouble();
                        if (accountType == 1) {
                            bankService.createCurrentAccount(accountNumber, accountHolderName, initialDeposit);
                        } else if (accountType == 2) {
                            bankService.createSavingsAccount(accountNumber, accountHolderName, initialDeposit);
                        } else {
                            System.out.println("Invalid account type");
                        }
                    }
                    break;
                case 4:
                    // check balance
                    System.out.println("Enter account number: ");
                    String checkBalanceAccountNumber = scanner.next();
                    BankAccount account = bankService.findAccount(checkBalanceAccountNumber);
                    if (account != null) {
                        System.out.printf("Account balance is $%.2f%n", account.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    // exit program
                    System.out.println("Exiting.Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
    }
}
