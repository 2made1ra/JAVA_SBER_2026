package LAB_1.tasks;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Напишите программу, в которой пользователь вводит число,
 * а программой отображается последовательность из четырех чисел:
 * число, на единицу меньше введённого,
 * введенное число и число, на единицу больше введенного.
 * Четвертое число должно быть квадратом суммы первых трех чисел.
 */
public class Task9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] numbers = new int[4];

        System.out.println("Enter num: ");
        numbers[1] = in.nextInt();

        numbers[0] = numbers[1] - 1;
        numbers[2] = numbers[1] + 1;
        numbers[3] = (int) Math.pow((numbers[0] + numbers[1] + numbers[2]), 2);

        System.out.println(Arrays.toString(numbers));
    }
}
