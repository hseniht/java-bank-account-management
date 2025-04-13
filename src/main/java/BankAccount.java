public abstract class BankAccount {
    private String accountNumber;
    private double balance = 0.0;
    private String accountHolderName;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.deposit(initialDeposit);
    }

    public void deposit(double amount) {
        balance += amount;
    }
    // so subclasses can update it
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
