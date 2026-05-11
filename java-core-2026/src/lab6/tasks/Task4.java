package lab6.tasks;

/**
 * Задание 4.
 * Напишите программу, которая создает 10 потоков и каждый поток выводит на экран
 * свой номер.
 */
public class Task4 {
    private static final int THREAD_COUNT = 10;

    public static void startNumberedThreads(int threadCount) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(
                    () -> System.out.println("Thread number: " + threadNumber),
                    "Thread-" + threadNumber);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        startNumberedThreads(THREAD_COUNT);
    }
}
