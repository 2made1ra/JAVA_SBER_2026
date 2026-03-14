package lab1.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь последовательно вводит название текущего дня недели,
 * название месяца и дату (номер дня в месяце).
 * Программа выводит сообщение о сегодняшней дате (день недели, дата, месяц).
 */
public class Task3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter current day name: ");
        String currWeekDay = in.nextLine();

        System.out.println("Enter current month: ");
        String currMonth = in.nextLine();

        System.out.println("Enter current day number: ");
        int currDayNum = in.nextInt();

        System.out.printf("Today is %s %d %s", currWeekDay, currDayNum, currMonth);
    }
}
