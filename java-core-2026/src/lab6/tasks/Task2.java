package lab6.tasks;

/**
 * Задание 2.
 * Напишите программу, которая запускает поток и выводит на экран числа от 1 до 10
 * с задержкой в 1 секунду между выводами.
 */
public class Task2 {
    private static final long DELAY_MILLIS = 1_000;

    public static Thread createNumberPrinter(int from, int to, long delayMillis) {
        return new Thread(() -> printNumbers(from, to, delayMillis));
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = createNumberPrinter(1, 10, DELAY_MILLIS);

        thread.start();
        thread.join();
    }

    private static void printNumbers(int from, int to, long delayMillis) {
        for (int number = from; number <= to; number++) {
            System.out.println(number);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
