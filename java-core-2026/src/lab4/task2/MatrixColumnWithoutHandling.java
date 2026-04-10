package lab4.task2;

import java.util.Scanner;

/**
 * Задание 2.2 (без обработки исключений):
 * вывод столбца матрицы по номеру, введенному с клавиатуры.
 */
public class MatrixColumnWithoutHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Введите номер столбца (0.." + (cols - 1) + "): ");
        int columnIndex = scanner.nextInt();

        System.out.println("Значения столбца:");
        for (int i = 0; i < rows; i++) {
            // При неверном индексе будет ArrayIndexOutOfBoundsException.
            System.out.println(matrix[i][columnIndex]);
        }
    }
}
