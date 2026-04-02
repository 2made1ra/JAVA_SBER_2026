package lab3.tasks.task8;

import lab3.tasks.task4.Node;

/**
 * Реализация ввода, вывода и изменения односвязного линейного списка
 * с использованием циклов.
 */
public class CycledLinkedList {
    private Node head;
    private int length;

    private CycledLinkedList (int length) {
        this.length = length;
        this.head = null;
    }

    public static CycledLinkedList createWithHead(int n) {
        CycledLinkedList list = new CycledLinkedList(n);
        list.createHead();
        return list;
    }

    public static CycledLinkedList createWithTail(int n) {
        CycledLinkedList list = new CycledLinkedList(n);
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

    public void addFirst() {

    }

    public void addLas() {

    }

    public void insert() {

    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void remove() {

    }
}
