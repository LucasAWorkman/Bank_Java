public class SavingsAccount extends CheckingAccount {
    double interestRate = 0.0;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1000.0, 0.05);
        savings.calcInterest();
        System.out.println("New balance after interest: " + savings.getBalance());
    }

    private void calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    public void setInterestRate(float interest) {
        this.interestRate = interest;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
}
