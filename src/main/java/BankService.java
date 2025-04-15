import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<BankAccount> accounts;
    private InputUtils inputUtils;

    // default/no-args constructor
    public BankService() {
        this.accounts = new ArrayList<>();
        this.inputUtils = new InputUtils();
    }

    public void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = inputUtils.readString();
        System.out.print("Enter name: ");
        String accountHolderName = inputUtils.readString();
        System.out.print("Enter initial balance: ");
        double balance = inputUtils.readDouble();

        System.out.println("Select account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int accountType = inputUtils.readInt();

        switch (accountType) {
            case 1:
                accounts.add(new SavingsAccount(accountNumber, accountHolderName, balance));
                break;
            case 2:
                System.out.print("Enter overdraft limit: ");
                double overdraftLimit = inputUtils.readDouble();
                accounts.add(new CurrentAccount(accountNumber,accountHolderName, balance, overdraftLimit));
                break;
            default:
                System.out.println("Invalid account type.");
                break;
        }

        System.out.println("Account created successfully.");
    }

    public void depositMoney() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println("Enter amount to deposit: ");
            double amount = inputUtils.readDouble();
            account.deposit(amount);
        }
    }

    public void withdrawMoney() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println("Enter amount to withdraw: ");
            double amount = inputUtils.readDouble();
            account.withdraw(amount);
        }
    }

    public void listAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Holder: " + account.getAccountHolderName() +
                    ", Balance: $" + account.getBalance());

        }
    }

    public void checkBalance() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        }
    }

    private BankAccount findAccount() {
        System.out.println("Enter account number: ");
        String accountNumber = inputUtils.readString();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }


}
