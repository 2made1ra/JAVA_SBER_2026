package lab4.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 2.1 (с обработкой исключений):
 * вычисление среднего значения среди положительных элементов массива int.
 */
public class AveragePositiveWithHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

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

            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют.");
            }

            int average = sum / count;
            System.out.println("Среднее значение положительных элементов: " + average);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число типа int.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
