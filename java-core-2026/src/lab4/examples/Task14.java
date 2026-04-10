package lab4.examples;

/**
 * Пример 14. Обработка исключения, порожденного методом m(),
 * в методе main.
 */
public class Task14 {
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
