package lab1.tasks;

import java.util.Scanner;

/**
 * Напишите программу для вычисления суммы двух чисел.
 * Оба числа вводятся пользователем.
 * Для вычисления суммы используйте оператор +.
 */
public class Task8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum;

        System.out.println("Enter first num: ");
        int firstNum = in.nextInt();

        System.out.println("Enter second num: ");
        int secondNum = in.nextInt();

        sum = firstNum + secondNum;
        System.out.printf("Sum of your nums is %d", sum);
    }
}
