
public class BankAccountManagementSystem {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        InputUtils inputUtils = new InputUtils();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Bank Account Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = inputUtils.readInt();
            switch (choice) {
                case 1:
                    bankService.createAccount();
                    break;
                case 2:
                    bankService.depositMoney();
                    break;
                case 3:
                    bankService.withdrawMoney();
                    break;
                case 4:
                    // check balance
                    bankService.checkBalance();
                    break;

                case 5:
                    // exit program
                    running = false;
                    System.out.println("Exiting.Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
