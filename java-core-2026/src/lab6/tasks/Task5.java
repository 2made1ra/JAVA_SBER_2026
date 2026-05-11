package lab6.tasks;

import java.util.Arrays;

/**
 * Задание 5.
 * Напишите функцию, которая находит максимальный элемент в массиве целых чисел
 * при помощи многопоточности. Количество потоков должно быть равно количеству
 * ядер процессора.
 */
public class Task5 {

    public static int findMax(int[] numbers) throws InterruptedException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int threadCount = Runtime.getRuntime().availableProcessors();
        int[] partialMaxValues = new int[threadCount];
        Arrays.fill(partialMaxValues, Integer.MIN_VALUE);

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * numbers.length / threadCount;
            int end = (i + 1) * numbers.length / threadCount;

            threads[i] = new Thread(() -> partialMaxValues[threadIndex] = findMax(numbers, start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return findMax(partialMaxValues, 0, partialMaxValues.length);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {12, 4, 18, 7, 31, 9, 2, 26};

        System.out.println("Max value: " + findMax(numbers));
    }

    private static int findMax(int[] numbers, int start, int end) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }
}
