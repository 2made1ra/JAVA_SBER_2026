package lab1.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой пользователю предлагается ввести название месяца и количество дней в этом месяце.
 * Программа выводит сообщение о том, что соответствующий месяц содержит указанное количество дней.
 */
public class Task4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter month name: ");
        String month = in.nextLine();

        System.out.println("Enter num of days in this month: ");
        int monthDayNum = in.nextInt();

        System.out.printf("Month %s contain %d days.", month, monthDayNum);
    }
}
