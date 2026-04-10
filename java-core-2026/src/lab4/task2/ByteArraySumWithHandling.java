package lab4.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 2.3 (с обработкой исключений):
 * вычисление суммы элементов массива byte.
 */
public class ByteArraySumWithHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            byte[] numbers = new byte[size];
            System.out.println("Введите элементы массива типа byte:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextByte();
            }

            byte sum = 0;
            for (byte number : numbers) {
                int current = sum + number;
                if (current < Byte.MIN_VALUE || current > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Сумма вышла за границы типа byte.");
                }
                sum = (byte) current;
            }

            System.out.println("Сумма элементов: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число типа byte.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
