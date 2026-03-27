package lab3.tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Создать приложение, позволяющее ввести и вывести одномерный
 * массив целых чисел. Для ввода и вывода массива разработать рекурсивные
 * методы вместо циклов for.
 * <p>Использую перегрузку методов для методов оберток</p>
 */
public class Task3 {
    public static void enterArray(int[] numbers, Scanner in) {
        enterArray(numbers, 0, in);
    }

    private static void enterArray(int[] numbers, int i, Scanner in) {
        if (i != numbers.length) {
            System.out.println("Введите " + (i + 1) + " число");
            numbers[i] = in.nextInt();
            enterArray(numbers, i + 1, in);
        }
    }

    private static void printArray(int[] numbers) {
        printArray(numbers, 0);
    }

    private static void printArray(int[] numbers, int i) {
        if (i != numbers.length) {
            System.out.println((i + 1) + " число в массиве это " + numbers[i]);
            printArray(numbers, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = in.nextInt();
        int[] numbers = new int[length];
        enterArray(numbers, in);
        System.out.println();
        printArray(numbers);
    }
}
