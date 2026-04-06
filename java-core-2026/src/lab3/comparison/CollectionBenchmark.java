package lab3.comparison;

import java.util.*;

public class CollectionBenchmark {

    private static final int VARIANT_NUMBER = 10;
    private static final int ELEMENTS_COUNT = VARIANT_NUMBER * 1_000_000;
    private static final long GET_ITERATIONS = (long) VARIANT_NUMBER * 1_000_000_000L;

    private static final int POSITION_ACCESS_SAMPLES = 1_000;
    private static final int COLLECTIONS_COUNT = 3;
    private static final int POSITIONS_COUNT = 3;

    private static final int ARRAY_LIST_INDEX_BEGIN = 0;
    private static final int ARRAY_LIST_INDEX_MIDDLE_FACTOR = 2;
    private static final int HASH_VALUE_BEGIN = 0;
    private static final int HASH_VALUE_MIDDLE_MULTIPLIER = 1;

    private static final String[] COLLECTION_NAMES = {"HashSet", "LinkedHashMap", "ArrayList"};
    private static final String[] POSITION_NAMES = {"в начале", "в середине", "в конце"};

    private static final int POSITION_BEGIN = 0;
    private static final int POSITION_MIDDLE = 1;
    private static final int POSITION_END = 2;
    private static final int COL_HASH_SET = 0;
    private static final int COL_LINKED_HASH_MAP = 1;
    private static final int COL_ARRAY_LIST = 2;

    private ArrayList<Integer> arrayList;
    private HashSet<Integer> hashSet;
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public static void main(String[] args) {
        System.out.println("Инициализация коллекций... Пожалуйста, подождите.");
        CollectionBenchmark benchmark = new CollectionBenchmark();
        benchmark.runAllTests();
    }

    public void runAllTests() {
        System.out.println("Номер варианта: " + VARIANT_NUMBER);
        System.out.println("Количество элементов в коллекции: " + ELEMENTS_COUNT);
        System.out.println("Количество операций для скорости получения по индексу: " + GET_ITERATIONS + "\n");

        double[][] addResults = testAddByPosition();
        double[][] removeResults = testRemoveByPosition();
        double[] getByIndexResults = testGetByIndex();

        printPositionTable("Таблица 1. Добавление (мс)", addResults);
        printPositionTable("Таблица 2. Удаление (мс)", removeResults);
        printIndexTable("Таблица 3. Получение по индексу (мс)", getByIndexResults);

        System.out.println("\nПримечание:");
        System.out.println("- Для HashSet и LinkedHashMap позиции начало/середина/конец интерпретируются по диапазону ключей.");
        System.out.println("- Для получения по индексу используется экстраполяция на " + GET_ITERATIONS + " операций.");
    }

    private void printPositionTable(String title, double[][] values) {
        System.out.println(title);
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Коллекция", POSITION_NAMES[POSITION_BEGIN], POSITION_NAMES[POSITION_MIDDLE], POSITION_NAMES[POSITION_END]);
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < COLLECTIONS_COUNT; i++) {
            System.out.printf(
                    "%-15s %-15.4f %-15.4f %-15.4f%n",
                    COLLECTION_NAMES[i],
                    values[i][POSITION_BEGIN],
                    values[i][POSITION_MIDDLE],
                    values[i][POSITION_END]
            );
        }
        System.out.println();
    }

    private void printIndexTable(String title, double[] values) {
        System.out.println(title);
        System.out.printf("%-15s %-30s%n", "Коллекция", "По индексу для <n> элементов");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < COLLECTIONS_COUNT; i++) {
            System.out.printf("%-15s %-30.4f%n", COLLECTION_NAMES[i], values[i]);
        }
        System.out.println();
    }

    private void resetCollections() {
        arrayList = null;
        hashSet = null;
        linkedHashMap = null;
        System.gc();

        arrayList = new ArrayList<>(ELEMENTS_COUNT);
        hashSet = new HashSet<>(ELEMENTS_COUNT * 2);
        linkedHashMap = new LinkedHashMap<>(ELEMENTS_COUNT * 2);

        int maxValue = ELEMENTS_COUNT * 2;
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            int value = i * ARRAY_LIST_INDEX_MIDDLE_FACTOR;
            if (value >= maxValue) {
                value = maxValue - 2;
            }
            arrayList.add(value);
            hashSet.add(value);
            linkedHashMap.put(value, value);
        }
    }

    private double[][] testAddByPosition() {
        double[][] results = new double[COLLECTIONS_COUNT][POSITIONS_COUNT];
        int addBeginValue = 1;
        int addMiddleValue = ELEMENTS_COUNT + 1;
        int addEndValue = ELEMENTS_COUNT * 2 - 1;

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_BEGIN] = measureArrayListAdd(ARRAY_LIST_INDEX_BEGIN, addBeginValue);
        results[COL_HASH_SET][POSITION_BEGIN] = measureHashSetAdd(addBeginValue);
        results[COL_LINKED_HASH_MAP][POSITION_BEGIN] = measureLinkedHashMapAdd(addBeginValue);

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_MIDDLE] = measureArrayListAdd(arrayList.size() / ARRAY_LIST_INDEX_MIDDLE_FACTOR, addMiddleValue);
        results[COL_HASH_SET][POSITION_MIDDLE] = measureHashSetAdd(addMiddleValue);
        results[COL_LINKED_HASH_MAP][POSITION_MIDDLE] = measureLinkedHashMapAdd(addMiddleValue);

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_END] = measureArrayListAdd(arrayList.size(), addEndValue);
        results[COL_HASH_SET][POSITION_END] = measureHashSetAdd(addEndValue);
        results[COL_LINKED_HASH_MAP][POSITION_END] = measureLinkedHashMapAdd(addEndValue);

        return results;
    }

    private double[][] testRemoveByPosition() {
        double[][] results = new double[COLLECTIONS_COUNT][POSITIONS_COUNT];
        int removeBeginValue = HASH_VALUE_BEGIN;
        int removeMiddleValue = ELEMENTS_COUNT * HASH_VALUE_MIDDLE_MULTIPLIER;
        int removeEndValue = ELEMENTS_COUNT * 2 - 2;

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_BEGIN] = measureArrayListRemoveByIndex(ARRAY_LIST_INDEX_BEGIN);
        results[COL_HASH_SET][POSITION_BEGIN] = measureHashSetRemove(removeBeginValue);
        results[COL_LINKED_HASH_MAP][POSITION_BEGIN] = measureLinkedHashMapRemove(removeBeginValue);

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_MIDDLE] = measureArrayListRemoveByIndex(arrayList.size() / ARRAY_LIST_INDEX_MIDDLE_FACTOR);
        results[COL_HASH_SET][POSITION_MIDDLE] = measureHashSetRemove(removeMiddleValue);
        results[COL_LINKED_HASH_MAP][POSITION_MIDDLE] = measureLinkedHashMapRemove(removeMiddleValue);

        resetCollections();
        results[COL_ARRAY_LIST][POSITION_END] = measureArrayListRemoveByIndex(arrayList.size() - 1);
        results[COL_HASH_SET][POSITION_END] = measureHashSetRemove(removeEndValue);
        results[COL_LINKED_HASH_MAP][POSITION_END] = measureLinkedHashMapRemove(removeEndValue);

        return results;
    }

    private double measureArrayListAdd(int index, int value) {
        long start = System.nanoTime();
        arrayList.add(index, value);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double measureHashSetAdd(int value) {
        long start = System.nanoTime();
        hashSet.add(value);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double measureLinkedHashMapAdd(int key) {
        long start = System.nanoTime();
        linkedHashMap.put(key, key);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double measureArrayListRemoveByIndex(int index) {
        long start = System.nanoTime();
        arrayList.remove(index);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double measureHashSetRemove(int value) {
        long start = System.nanoTime();
        hashSet.remove(value);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double measureLinkedHashMapRemove(int key) {
        long start = System.nanoTime();
        linkedHashMap.remove(key);
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private double[] testGetByIndex() {
        double[] times = new double[3];
        int index = ELEMENTS_COUNT / 2;
        resetCollections();

        times[COL_ARRAY_LIST] = estimateArrayListGetTimeMs(index);
        times[COL_HASH_SET] = estimatePositionAccessTimeMs(hashSet, index);
        times[COL_LINKED_HASH_MAP] = estimatePositionAccessTimeMs(linkedHashMap.keySet(), index);

        return times;
    }

    private double estimateArrayListGetTimeMs(int index) {
        long start = System.nanoTime();
        for (int i = 0; i < POSITION_ACCESS_SAMPLES; i++) {
            arrayList.get(index);
        }
        double sampleDurationMs = (System.nanoTime() - start) / 1_000_000.0;
        return sampleDurationMs * ((double) GET_ITERATIONS / POSITION_ACCESS_SAMPLES);
    }

    private double estimatePositionAccessTimeMs(Iterable<Integer> iterable, int index) {
        long start = System.nanoTime();
        for (int i = 0; i < POSITION_ACCESS_SAMPLES; i++) {
            getValueByIndex(iterable, index);
        }
        double sampleDurationMs = (System.nanoTime() - start) / 1_000_000.0;
        return sampleDurationMs * ((double) GET_ITERATIONS / POSITION_ACCESS_SAMPLES);
    }

    private Integer getValueByIndex(Iterable<Integer> iterable, int index) {
        int current = 0;
        for (Integer value : iterable) {
            if (current == index) {
                return value;
            }
            current++;
        }
        throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
    }
}
