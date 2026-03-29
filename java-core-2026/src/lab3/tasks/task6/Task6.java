package lab3.tasks.task6;

import java.util.Scanner;

/**
 * В кругу стоят N человек, пронумерованных от 1 до N. При ведении
 * счета по кругу вычеркивается каждый второй человек, пока не останется
 * один. Составить две программы, моделирующие процесс. Одна из программ
 * должна использовать класс ArrayList, а вторая — LinkedList. Какая из двух
 * программ работает быстрее? Почему?
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N: ");
        int n = in.nextInt();

        ArraySolution myArrayList = new ArraySolution(n);
        LinkedSolution myLinkedList = new LinkedSolution(n);

        myArrayList.calculateWorkTime();
        myLinkedList.calculateWorkTime();
    }
}
