public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        super(accountNumber, accountHolderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if (currentBalance - amount >= 100) {
            setBalance(currentBalance - amount);
        } else {
            System.out.println("Insufficient funds. Minimum balance of $100 required.");
        }
    }
}
