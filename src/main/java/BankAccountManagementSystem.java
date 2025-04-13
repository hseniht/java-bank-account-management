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
                    System.out.println("Choose account type:");
                    System.out.println("1. Current account");
                    System.out.println("2. Savings account");
                    int accountType = scanner.nextInt();
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.println("Enter account holder name: ");
                    String accountHolderName = scanner.next();
                    System.out.println("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    if (accountType == 1) {
                        bankService.createCurrentAccount(accountNumber, accountHolderName, initialDeposit);
                    } else if (accountType == 2) {
                        bankService.createSavingsAccount(accountNumber, accountHolderName, initialDeposit);
                    } else {
                        System.out.println("Invalid account type");
                    }
                    break;
                case 4:
                    // check balance
                    System.out.println("Enter account number: ");
                    String checkBalanceAccountNumber = scanner.next();
                    BankAccount account = bankService.findAccount(checkBalanceAccountNumber);
                    if (account != null) {
                        System.out.println("Account balance is " + account.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    // exit program
                    System.out.println("Exiting.Goodbye!");
                    scanner.close();
                    return;

            }
        }
    }
}
