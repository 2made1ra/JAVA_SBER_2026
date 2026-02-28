package LAB_1.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь вводит сначала фамилию, затем имя, затем отчество.
 * После ввода программа выводит сообщение «Hello <фамилия, имя, отчество>».
 */
public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String surName = in.nextLine();

        System.out.println("Введите имя: ");
        String firstName = in.nextLine();

        System.out.println("Введите отчество: ");
        String secondName = in.nextLine();

        System.out.printf("Приветствую %s %s %s!",surName, firstName, secondName);
    }
}
