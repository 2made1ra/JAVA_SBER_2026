package lab3.tasks;

import java.util.HashMap;

/**
 * Заполнить HashMap 10 объектами <Integer, String>. Найти строки у
 * которых ключ > 5 Если ключ = 0, вывести строки через запятую.
 * Перемножить все ключи, где длина строки>5.
 */
public class Task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> myMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            myMap.put(i, "java".repeat((i % 3) + 1));
        }


    }
}
