public class CurrentAccount extends BankAccount{
    public double overDraftLimit;
    public CurrentAccount(String accountNumber, String accountHolderName, double initialDeposit, double overDraftLimit) {
        super(accountNumber, accountHolderName, initialDeposit);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if (currentBalance + overDraftLimit >= amount) {
            System.out.println("Withdrawing: " + amount);
            deposit(-amount);  // Reusing deposit method to subtract amount
        } else {
            System.out.println("Exceeds overdraft limit.");
        }
    }
}

