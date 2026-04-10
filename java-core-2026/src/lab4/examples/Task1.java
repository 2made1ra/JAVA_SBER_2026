package lab4.examples;

/**
 * Пример 1. Сгенерировано и перехвачено RuntimeException.
 */
public class Task1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) { // исключение перехвачено
            System.out.println("1 "+ e); // исключение обработано
        }
        System.out.println("2");
    }
}
