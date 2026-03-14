package lab1.tasks;

import java.util.Scanner;
import java.time.LocalDate;
/**
 * Напишите программу, в которой по возрасту определяется год рождения.
 */
public class Task7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int currentYear = LocalDate.now().getYear();

        System.out.println("Enter your age: ");
        int userAge = in.nextInt();
        int userBirthYear = currentYear - userAge;

        System.out.printf("User birth year is %d", userBirthYear);
    }
}
