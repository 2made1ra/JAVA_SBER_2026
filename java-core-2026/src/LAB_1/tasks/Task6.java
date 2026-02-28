package LAB_1.tasks;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * Напишите программу, в которой Пользователь вводит имя и год рождения,
 * а программа отображает сообщение содержащее имя пользователя и его возраст.
 */
public class Task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int currentYear = LocalDate.now().getYear();

        System.out.println("Enter your name: ");
        String name = in.nextLine();

        System.out.println("Enter your birthday year: ");
        int birthYear = in.nextInt();
        int userAge = currentYear - birthYear;

        System.out.printf("User name is %s\nUser age is %d", name, userAge);
    }
}
