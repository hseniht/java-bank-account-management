import java.util.ArrayList;

public class BankService {
    private ArrayList<BankAccount> accounts;

    public BankService() {
        accounts = new ArrayList<>();
    }

    public void createSavingsAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolderName, initialDeposit);
        accounts.add(savingsAccount);
        System.out.println("Savings account created successfully for " + accountHolderName);
    }

    public void createCurrentAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        CurrentAccount currentAccount = new CurrentAccount(accountNumber, accountHolderName, initialDeposit);
        accounts.add(currentAccount);
        System.out.println("Current account created successfully for " + accountHolderName);
    }

    public void listAccounts() {
        for(BankAccount account: accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Holder: " + account.getAccountHolderName() +
                    ", Balance: $" + account.getBalance());

        }
    }

    public BankAccount findAccount(String accountNumber) {
        for(BankAccount account: accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
