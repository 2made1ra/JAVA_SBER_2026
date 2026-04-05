package lab3.codewars;

import java.util.Scanner;

public class Task2 {
    public static String solution(int[] numbers) {
        String phoneNumber = "(xxx) xxx-xxxx";
        for (int n : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", String.valueOf(n));
        }
        return phoneNumber;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
