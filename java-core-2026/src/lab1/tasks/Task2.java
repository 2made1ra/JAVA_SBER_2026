package lab1.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь вводит имя и возраст.
 * Программа отображает сообщение об имени и возрасте пользователя.
 */
public class Task2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = in.nextLine();

        System.out.println("Enter your age: ");
        int age = in.nextInt();

        System.out.printf("User data: \nName - %s\nAge - %d", name, age);
    }
}
