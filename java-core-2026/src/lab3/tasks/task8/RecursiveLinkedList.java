package lab3.tasks.task8;

import lab3.tasks.task4.Node;

/**
 * Реализация ввода, вывода и изменения односвязного линейного списка
 * с использованием рекурсии.
 */
public class RecursiveLinkedList {
    private int length;
    private Node head;

    private RecursiveLinkedList(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Длина не может быть отрицательной");
        }
        this.length = length;
        this.head = null;
    }

    public static RecursiveLinkedList createWithHead(int length) {
        RecursiveLinkedList list = new RecursiveLinkedList(length);
        list.head = list.createHeadRec(0);
        return list;
    }

    public static RecursiveLinkedList createWithTail(int length) {
        RecursiveLinkedList list = new RecursiveLinkedList(length);

        if (length > 0) {
            list.head = new Node(0, null);
            list.createTailRec(list.head, 1);
        }

        return list;
    }

    private Node createHeadRec(int i) {
        if (i == length) {
            return null;
        }

        return new Node(i, createHeadRec(i + 1));
    }

    private void createTailRec(Node currentNode, int i) {
        if (i == length) {
            return;
        }

        currentNode.next = new Node(i, null);
        createTailRec(currentNode.next, i + 1);
    }

    private void toStringRec(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.value);

        if (node.next != null) {
            sb.append(", ");
        }

        toStringRec(node.next, sb);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toStringRec(head, stringBuilder);
        return stringBuilder.toString();
    }
}
