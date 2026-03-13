package LAB_2.tasks.Task7;

/**
 * <h3>Создание классов и интерфейсов для работы с банковскими счетами.</h3>
 * <p>Создайте класс, который представляет банковский счет, и добавьте методы для депозита и снятия денег,
 * а также для получения текущего баланса.</p>
 * <p>Создайте интерфейс, который определяет методы, которые должны быть реализованы для каждого класса,
 * чтобы создать новый банковский счет, совершить транзакции и получить текущий баланс.</p>
 * Реализуйте методы интерфейса в классе банковского счета и создайте объекты для работы с ними в своем приложении.
 */
public class Task7 {
    public static void main(String[] args) {
        System.out.println("--- Дебетовый счет ---");
        BankAccount debit = new DebitAccount();
        System.out.println("Начальный баланс: " + debit.getCurrentBalance());

        debit.deposit(5000);
        System.out.println("Баланс после пополнения на 5000: " + debit.getCurrentBalance());

        debit.withdraw(1500);
        System.out.println("Баланс после снятия 1500: " + debit.getCurrentBalance());


        System.out.println("\n--- Кредитный счет ---");
        BankAccount credit = new CreditAccount();
        System.out.println("Начальный баланс: " + credit.getCurrentBalance());

        // Снимаем деньги, уходя в минус (разрешено до -1500)
        credit.withdraw(31000);
        System.out.println("Баланс после снятия 31000: " + credit.getCurrentBalance());

        credit.deposit(500);
        System.out.println("Баланс после пополнения на 500: " + credit.getCurrentBalance());


        System.out.println("\n--- Обработка ошибок ---");

        // Попытка снять больше, чем есть на дебетовом счете
        try {
            debit.withdraw(10000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (Дебетовый счет): " + e.getMessage());
        }

        // Попытка превысить лимит кредитного счета (30000)
        try {
            BankAccount credit2 = new CreditAccount(); // баланс 30000
            credit2.deposit(100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка (Кредитный счет): " + e.getMessage());
        }
    }
}
