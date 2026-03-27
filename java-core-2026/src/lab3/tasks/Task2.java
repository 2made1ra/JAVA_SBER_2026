package lab3.tasks;

import java.util.Scanner;

/**
 * Класс с использованием рекурсии для перевода
 * целого числа, введенного с клавиатуры, в двоичную систему счисления.
 */
public class Task2 {
    private static void translateToBinary(int num) {
        if (num / 2 != 0) {
            translateToBinary(num / 2);
        }
        System.out.print(num % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        translateToBinary(num);
    }
}
