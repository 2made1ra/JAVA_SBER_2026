package lab3.tasks.task7;

import lab3.tasks.task4.Node;

public class LinkedFromTail {
    static void main() {
        //
        Node head = null;
        for (int i = 10; i >= 0; i--) {
            head = new Node(i, head);
        }

        Node ref = head;
        while (ref.next != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }
}
