package lab2.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой создается двумерный числовой
 * массив и этот массив заполняется «змейкой»: сначала первая строка (слева
 * направо), затем последний столбец (сверху вниз), вторая строка (справа
 * налево) и так далее.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows, cols;
        int value = 1;

        // Напишу отдельную функцию для проверки четности числа

        System.out.println("You need to enter number of rows and cols for matrix.\nEnter number of rows: ");
        rows = in.nextInt();
        System.out.println("Enter number of cols: ");
        cols = in.nextInt();

        int [][] matrix = new int[rows][cols];

        // заполнение змейкой - в основе логики лежит проверка четности номера строки
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = value;
                    value++;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = value;
                    value++;
                }
            }
        }

        // теперь нужно распечатать в терминале
        System.out.println("Result: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
