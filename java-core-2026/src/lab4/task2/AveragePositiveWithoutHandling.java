package lab4.task2;

import java.util.Scanner;

/**
 * Задание 2.1 (без обработки исключений):
 * вычисление среднего значения среди положительных элементов массива int.
 */
public class AveragePositiveWithoutHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        int count = 0;
        for (int number : numbers) {
            if (number > 0) {
                sum += number;
                count++;
            }
        }

        // При отсутствии положительных элементов будет ArithmeticException.
        int average = sum / count;
        System.out.println("Среднее значение положительных элементов: " + average);
    }
}
