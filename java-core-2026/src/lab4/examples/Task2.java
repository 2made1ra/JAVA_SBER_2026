package lab4.examples;

/**
 * Пример 2. Исключение перехвачено перехватчиком предка.
 */
public class Task2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            System.out.println("1");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
