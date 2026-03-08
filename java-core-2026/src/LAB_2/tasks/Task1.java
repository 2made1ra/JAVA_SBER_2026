package LAB_2.tasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

/**
 * Напишите программу, в которой создается массив и заполняется
 * случайными числами. Массив отображается в консольном окне. В этом
 * массиве необходимо определить элемент с минимальным значением. В
 * частности, программа должна вывести значение элемента с минимальным
 * значением и индекс этого элемента. Если элементов с минимальным
 * значением несколько, должны быть выведены индексы всех этих элементов.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] randomArray;
        randomArray = new int[10];

        // Для получения рандомных чисел я буду использовать класс Random. Можно было бы
        // использовать Math.random(), но как я понял, это более устаревший способ
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(11);
        }

        // Выводим строку в терминал, пользуясь методом класса Arrays
        // для преобразования массива в строку
        String outResult = Arrays.toString(randomArray);
        System.out.println("Our array is: " + outResult);

        int minElement = randomArray[0];
        for (int i = 1; i < randomArray.length; i++) {
            if (randomArray[i] < minElement) {
                minElement = randomArray[i];
            }
        }

        System.out.printf("Minimal element of array is %d\n", minElement);
        System.out.print("Indices of minimal elements: ");
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == minElement) {
                System.out.print(i + " ");
            }
            if (i == randomArray.length - 1) {
                System.out.println();
            }
        }
    }
}
