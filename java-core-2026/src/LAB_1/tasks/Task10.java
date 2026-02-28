package LAB_1.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь вводит два числа,
 * а программой вычисляется и отображается сумма и разность этих чисел.
 */
public class Task10 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum, diff, firstNum, secondNum;

        System.out.println("Enter first num: ");
        firstNum = in.nextInt();

        System.out.println("Enter second num: ");
        secondNum = in.nextInt();

        sum = firstNum + secondNum;
        diff = firstNum - secondNum;

        System.out.printf("Sum equal %d\nDifference equal %d", sum, diff);
    }
}
