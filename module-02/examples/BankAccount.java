public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // returns false instead of letting the balance go negative
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return owner + ": " + balance;
    }

    public static void main(String[] args) {
        BankAccount riya = new BankAccount("Riya");
        BankAccount karan = new BankAccount("Karan");

        riya.deposit(500);
        karan.deposit(200);

        System.out.println("Withdraw 300 from Karan: " + karan.withdraw(300));
        System.out.println("Withdraw 150 from Karan: " + karan.withdraw(150));

        System.out.println(riya);
        System.out.println(karan);

        // two variables, one object
        BankAccount sameAsRiya = riya;
        sameAsRiya.deposit(100);
        System.out.println("Riya after deposit through other reference: " + riya.getBalance());
    }
}
