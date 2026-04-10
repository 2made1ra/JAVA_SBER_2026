package lab4.examples;

/**
 * Пример 8. Генерация исключения в методе.
 */
public class Task8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
