package lab6.tasks;

/**
 * Задание 3.
 * Напишите программу, которая создает два потока, которые выводят на экран числа
 * от 1 до 10. Первый поток должен выводить только четные числа, а второй поток
 * должен выводить только нечетные числа.
 */
public class Task3 {

    public static void printEvenAndOddNumbers(int maxNumber) throws InterruptedException {
        Object lock = new Object();
        int[] currentNumber = {1};

        Thread oddThread = new Thread(createNumberPrinter(lock, currentNumber, maxNumber, 1), "Odd thread");
        Thread evenThread = new Thread(createNumberPrinter(lock, currentNumber, maxNumber, 0), "Even thread");

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        printEvenAndOddNumbers(10);
    }

    private static Runnable createNumberPrinter(Object lock, int[] currentNumber, int maxNumber, int remainder) {
        return () -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (currentNumber[0] <= maxNumber && currentNumber[0] % 2 != remainder) {
                            lock.wait();
                        }

                        if (currentNumber[0] > maxNumber) {
                            lock.notifyAll();
                            return;
                        }

                        System.out.println(Thread.currentThread().getName() + ": " + currentNumber[0]);
                        currentNumber[0]++;
                        lock.notifyAll();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        lock.notifyAll();
                        return;
                    }
                }
            }
        };
    }
}
