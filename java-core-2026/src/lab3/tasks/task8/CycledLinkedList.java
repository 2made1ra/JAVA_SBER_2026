package lab3.tasks.task8;

import lab3.tasks.task4.Node;

/**
 * Реализация ввода, вывода и изменения односвязного линейного списка
 * с использованием циклов.
 */
public class CycledLinkedList {
    private Node head;
    private final int length;

    private CycledLinkedList (int length) {
        this.length = length;
        this.head = null;
    }

    public static CycledLinkedList createWithHead(int length) {
        CycledLinkedList list = new CycledLinkedList(length);
        list.createHead();
        return list;
    }

    public static CycledLinkedList createWithTail(int length) {
        CycledLinkedList list = new CycledLinkedList(length);
        list.createTail();
        return list;
    }

    // Ввод с головы - LIFO?
    private void createHead() {
        for (int i = length - 1; i >= 0; i--) {
            head = new Node(i, head);
        }
    }

    // Ввод с хвоста - создание новых хвостов FIFO?
    private void createTail() {
        Node currentNode = null;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                head = new Node(i, null);
                currentNode = head;
                continue;
            }
            currentNode.next = new Node(i, null);
            currentNode = currentNode.next;
        }
    }

    @Override
    public String toString() {
        Node ref = head;
        StringBuilder stringList = new StringBuilder();
        while (ref != null) {
            stringList.append(ref.value);

            if (ref.next == null) {
                break;
            }

            stringList.append(", ");
            ref = ref.next;
        }
        return stringList.toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node newNode = new Node(value, null);
        Node ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = newNode;
    }

    public void insert(int insertIndex, int value) {
        if (insertIndex == 0) {
            this.addFirst(value);
            return;
        }

        Node newNode = new Node(value, null);
        Node ref = head;
        int index = 0;

        while (index < insertIndex - 1) {
            ref = ref.next;
            index++;
        }

        newNode.next = ref.next;
        ref.next = newNode;
    }

    public void removeFirst() {
        Node ref = head;
        head = ref.next;
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public void remove(int deleteIndex) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        } else if (deleteIndex == 0) {
            head = head.next;
            return;
        } else if (deleteIndex > length - 1) {
            System.out.println("Некорректный индекс");
            return;
        }

        int index = 0;
        Node ref = head;

        while (index < deleteIndex - 1) {
            ref = ref.next;
            index++;
        }

        ref.next = ref.next.next;
    }
}
