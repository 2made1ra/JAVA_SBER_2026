package lab3.tasks.task4;

public class Test {
    public static void main(String[] args) {
        Node firstNode = new Node(0, null);
        Node secondNode = new Node(1, null);
        Node thirdNode = new Node(2, null);

        Node ref = firstNode; // ссылка на голову
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        while (ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
