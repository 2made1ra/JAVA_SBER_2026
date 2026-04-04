package lab3.tasks.task8;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация Итеративного Списка (IterativeLinkedList) ===");

        // 1. Создание списка
        IterativeLinkedList iterList = IterativeLinkedList.createWithTail(3);
        System.out.println("Создан список с хвоста (длина 3): " + iterList); // Неявно вызывается toString()
        System.out.println("Текущая длина: " + iterList.getLength());

        // 2. Добавление элементов
        System.out.println("\n--- Добавление элементов ---");
        iterList.addFirst(-1);
        System.out.println("Добавлен -1 в начало (addFirst):     " + iterList);

        iterList.addLast(3);
        System.out.println("Добавлен 3 в конец (addLast):        " + iterList);

        iterList.insert(2, 99);
        System.out.println("Вставка 99 по индексу 2 (insert):    " + iterList);
        System.out.println("Текущая длина: " + iterList.getLength());

        // 3. Удаление элементов
        System.out.println("\n--- Удаление элементов ---");
        iterList.removeFirst();
        System.out.println("Удален первый элемент (removeFirst): " + iterList);

        iterList.removeLast();
        System.out.println("Удален последний элемент (removeLast): " + iterList);

        iterList.remove(1); // Удаляем элемент с индексом 1 (это будет 99)
        System.out.println("Удален элемент по индексу 1 (remove):  " + iterList);
        System.out.println("Итоговая длина: " + iterList.getLength());


        System.out.println("\n\n=== Демонстрация Рекурсивного Списка (RecursiveLinkedList) ===");

        // 1. Создание списка с головы (справа налево)
        RecursiveLinkedList recListHead = RecursiveLinkedList.createWithHead(4);
        System.out.println("Создан рекурсивный список с головы (длина 4): " + recListHead);

        // 2. Создание списка с хвоста (слева направо)
        RecursiveLinkedList recListTail = RecursiveLinkedList.createWithTail(5);
        System.out.println("Создан рекурсивный список с хвоста (длина 5): " + recListTail);

        // 3. Краевой случай (пустой список)
        System.out.println("\n--- Краевые случаи (Рекурсивный список) ---");
        RecursiveLinkedList emptyRecList = RecursiveLinkedList.createWithTail(0);
        System.out.println("Создан пустой список (длина 0): [" + emptyRecList + "]");
    }
}