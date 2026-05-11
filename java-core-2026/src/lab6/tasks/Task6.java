package lab6.tasks;

/**
 * Задание 6.
 * Напишите функцию, которая суммирует элементы в массиве целых чисел при помощи
 * многопоточности. Количество потоков должно быть равно количеству ядер процессора.
 */
public class Task6 {

    public static long sum(int[] numbers) throws InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        long[] partialSums = new long[threadCount];

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * numbers.length / threadCount;
            int end = (i + 1) * numbers.length / threadCount;

            threads[i] = new Thread(() -> partialSums[threadIndex] = sum(numbers, start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long result = 0;
        for (long partialSum : partialSums) {
            result += partialSum;
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println("Sum: " + sum(numbers));
    }

    private static long sum(int[] numbers, int start, int end) {
        long result = 0;

        for (int i = start; i < end; i++) {
            result += numbers[i];
        }

        return result;
    }
}
