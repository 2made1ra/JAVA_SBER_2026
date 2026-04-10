package lab4.task2;

import java.util.Scanner;

/**
 * Задание 2.3 (без обработки исключений):
 * вычисление суммы элементов массива byte.
 */
public class ByteArraySumWithoutHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        byte[] numbers = new byte[size];
        System.out.println("Введите элементы массива типа byte:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextByte();
        }

        byte sum = 0;
        for (byte number : numbers) {
            int current = sum + number;
            // При выходе за диапазон byte будет ArithmeticException.
            if (current < Byte.MIN_VALUE || current > Byte.MAX_VALUE) {
                throw new ArithmeticException("Сумма вышла за границы типа byte.");
            }
            sum = (byte) current;
        }

        System.out.println("Сумма элементов: " + sum);
    }
}
