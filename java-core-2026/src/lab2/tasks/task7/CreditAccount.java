package lab2.tasks.task7;

public class CreditAccount implements BankAccount{
    private double balance;

    public CreditAccount() {
        this.balance = 30000;
    }

    @Override
    public void deposit(double amount) {
        if (getCurrentBalance() + amount > 30000 || amount <= 0) {
            throw new IllegalArgumentException("Некорректная сумма пополнения");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (getCurrentBalance() - amount < -1500) {
            throw new IllegalArgumentException("Недостаточно средств для снятия");
        }
        this.balance -= amount;
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }
}
