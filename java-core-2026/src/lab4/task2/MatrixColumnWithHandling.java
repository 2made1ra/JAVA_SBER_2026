package lab4.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задание 2.2 (с обработкой исключений):
 * вывод столбца матрицы по номеру, введенному с клавиатуры.
 */
public class MatrixColumnWithHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество строк: ");
            int rows = scanner.nextInt();
            System.out.print("Введите количество столбцов: ");
            int cols = scanner.nextInt();
            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными.");
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Введите номер столбца (0.." + (cols - 1) + "): ");
            int columnIndex = scanner.nextInt();

            if (columnIndex < 0 || columnIndex >= cols) {
                throw new ArrayIndexOutOfBoundsException("Нет столбца с номером " + columnIndex + ".");
            }

            System.out.println("Значения столбца:");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][columnIndex]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
