package LAB_1.tasks;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * Напишите программу, в которой по году рождения определяется возраст пользователя.
 */
public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int currentYear = LocalDate.now().getYear();

        System.out.println("Enter your birthday year: ");
        int userBirthYear = in.nextInt();
        int userAge = currentYear - userBirthYear;

        System.out.printf("User age is %d", userAge);
    }
}
