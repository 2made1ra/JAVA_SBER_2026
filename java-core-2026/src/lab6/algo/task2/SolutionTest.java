package lab6.algo.task2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void mergesLeetcodeExample() {
        ListNode result = solution.mergeTwoLists(
                list(1, 2, 4),
                list(1, 3, 4));

        assertArrayEquals(new int[] {1, 1, 2, 3, 4, 4}, values(result));
    }

    @Test
    public void returnsNullForTwoEmptyLists() {
        assertNull(solution.mergeTwoLists(null, null));
    }

    @Test
    public void returnsNonEmptyListWhenOtherListIsEmpty() {
        ListNode result = solution.mergeTwoLists(null, list(0));

        assertArrayEquals(new int[] {0}, values(result));
    }

    @Test
    public void mergesListsWithNegativeValues() {
        ListNode result = solution.mergeTwoLists(
                list(-10, -3, 5),
                list(-4, -1, 6));

        assertArrayEquals(new int[] {-10, -4, -3, -1, 5, 6}, values(result));
    }

    private ListNode list(int... values) {
        ListNode head = null;
        ListNode tail = null;

        for (int value : values) {
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }

    private int[] values(ListNode node) {
        int length = 0;
        for (ListNode current = node; current != null; current = current.next) {
            length++;
        }

        int[] result = new int[length];
        int index = 0;
        for (ListNode current = node; current != null; current = current.next) {
            result[index] = current.val;
            index++;
        }

        return result;
    }
}
