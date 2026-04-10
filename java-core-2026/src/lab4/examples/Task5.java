package lab4.examples;

/**
 * Пример 5. Исключение не перехвачено.
 */
public class Task5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }
}
