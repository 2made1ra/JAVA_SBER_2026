package lab3.comparison;

import java.util.*;

public class CollectionBenchmark {

    // 11 вариант * 1 000 000
    private static final int ELEMENTS_COUNT = 11_000_000;

    // 11 вариант * 1 000 000
    private static final long GET_ITERATIONS = 11_000_000L;

    private ArrayList<Integer> arrayList;
    private ArrayDeque<Integer> arrayDeque;
    private TreeMap<Integer, Integer> treeMap;

    public static void main(String[] args) {
        System.out.println("Инициализация коллекций... Пожалуйста, подождите.");
        CollectionBenchmark benchmark = new CollectionBenchmark();
        benchmark.runAllTests();
    }

    public void runAllTests() {
        System.out.println("Количество элементов в коллекции: " + ELEMENTS_COUNT);
        System.out.println("Итераций для получения по индексу: " + GET_ITERATIONS + "\n");
        // Обновлен заголовок таблицы
        System.out.printf("%-35s %-15s %-15s %-15s%n", "Операция (время в мс)", "ArrayList", "ArrayDeque", "TreeMap");
        System.out.println("----------------------------------------------------------------------------------");

        printResult("1. Добавление в начало", testAddFirst());
        printResult("2. Добавление в конец", testAddLast());
        printResult("3. Добавление в середину", testAddMiddle());
        printResult("4. Удаление из начала", testRemoveFirst());
        printResult("5. Удаление из конца", testRemoveLast());
        printResult("6. Удаление из середины", testRemoveMiddle());

        System.out.println("\nВнимание: Выполнение 7 пункта займет время (от нескольких секунд до минут)...");
        printResult("7. Получение по индексу", testGetByIndex());
    }

    // Формат вывода изменен для поддержки дробных чисел (до 4 знаков после запятой)
    private void printResult(String operationName, double[] times) {
        System.out.printf("%-35s %-15.4f %-15.4f %-15.4f%n", operationName, times[0], times[1], times[2]);
    }

    private void resetCollections() {
        arrayList = null;
        arrayDeque = null;
        treeMap = null;
        System.gc();

        arrayList = new ArrayList<>(ELEMENTS_COUNT);
        arrayDeque = new ArrayDeque<>(ELEMENTS_COUNT);
        treeMap = new TreeMap<>();

        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            arrayList.add(i);
            arrayDeque.addLast(i);
            treeMap.put(i, i);
        }
    }

    private double[] testAddFirst() {
        double[] times = new double[3];
        resetCollections();

        long start = System.nanoTime();
        arrayList.add(0, -1);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        arrayDeque.addFirst(-1);
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.put(-1, -1);
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testAddLast() {
        double[] times = new double[3];
        resetCollections();

        long start = System.nanoTime();
        arrayList.add(-1);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        arrayDeque.addLast(-1);
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.put(ELEMENTS_COUNT + 1, -1);
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testAddMiddle() {
        double[] times = new double[3];
        int mid = ELEMENTS_COUNT / 2;
        resetCollections();

        long start = System.nanoTime();
        arrayList.add(mid, -1);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < mid; i++) temp.push(arrayDeque.pollFirst());
        arrayDeque.addFirst(-1);
        while (!temp.isEmpty()) arrayDeque.addFirst(temp.pop());
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.put(mid, -1);
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testRemoveFirst() {
        double[] times = new double[3];
        resetCollections();

        long start = System.nanoTime();
        arrayList.remove(0);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        arrayDeque.removeFirst();
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.remove(treeMap.firstKey());
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testRemoveLast() {
        double[] times = new double[3];
        resetCollections();

        long start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        arrayDeque.removeLast();
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.remove(treeMap.lastKey());
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testRemoveMiddle() {
        double[] times = new double[3];
        int mid = ELEMENTS_COUNT / 2;
        resetCollections();

        long start = System.nanoTime();
        arrayList.remove(mid);
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < mid; i++) temp.push(arrayDeque.pollFirst());
        arrayDeque.pollFirst();
        while (!temp.isEmpty()) arrayDeque.addFirst(temp.pop());
        times[1] = (System.nanoTime() - start) / 1_000_000.0;

        start = System.nanoTime();
        treeMap.remove(mid);
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }

    private double[] testGetByIndex() {
        double[] times = new double[3];
        int mid = ELEMENTS_COUNT / 2;
        resetCollections();

        // 1. ArrayList
        long start = System.nanoTime();
        for (long i = 0; i < GET_ITERATIONS; i++) {
            arrayList.get(mid);
        }
        times[0] = (System.nanoTime() - start) / 1_000_000.0;

        // 2. ArrayDeque: Математическая экстраполяция, иначе пришлось ы считать бесконечно долго
        start = System.nanoTime();
        Iterator<Integer> iterator = arrayDeque.iterator();
        Integer val = null;
        for (int i = 0; i <= mid; i++) {
            val = iterator.next();
        }
        double singleIterationTimeMs = (System.nanoTime() - start) / 1_000_000.0;
        times[1] = singleIterationTimeMs * GET_ITERATIONS;

        // 3. TreeMap
        start = System.nanoTime();
        for (long i = 0; i < GET_ITERATIONS; i++) {
            treeMap.get(mid);
        }
        times[2] = (System.nanoTime() - start) / 1_000_000.0;

        return times;
    }
}
