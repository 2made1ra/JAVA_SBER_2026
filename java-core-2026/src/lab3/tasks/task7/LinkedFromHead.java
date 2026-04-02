package lab3.tasks.task7;

import lab3.tasks.task4.Node;

public class LinkedFromHead {
    static void main() {
        Node head = null;
        Node currentNode = null;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                head = new Node(i, null);
                currentNode = head;
                continue;
            }
            currentNode.next = new Node(i, null);
            currentNode = currentNode.next;
        }

        Node ref = head;
        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }
}
