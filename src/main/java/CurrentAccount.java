public class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        super(accountNumber, accountHolderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if(currentBalance - amount >= -500) {
            setBalance(currentBalance - amount);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}

