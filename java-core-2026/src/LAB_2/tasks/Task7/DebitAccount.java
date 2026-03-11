package LAB_2.tasks.Task7;

public class DebitAccount implements BankAccount{
    private double balance;

    public DebitAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Для пополнения требуется положительное значение");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > this.getCurrentBalance()) {
            throw new IllegalArgumentException("Недостаточно средств для снятия");
        }
        this.balance -= amount;
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }
}
