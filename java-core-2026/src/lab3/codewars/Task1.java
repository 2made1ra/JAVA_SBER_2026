package lab3.codewars;

import java.util.Scanner;

public class Task1 {
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        String str, ending;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        str = in.nextLine();
        System.out.println("Введите окончание: ");
        ending = in.nextLine();

        System.out.println(solution(str, ending));
    }
}
