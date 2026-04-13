package lab4.algo.task2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java">Directions Reduction</a>
 */
public class Solution {

    public static String[] dirReduc(String[] arr) {
        Deque<String> stack = new ArrayDeque<>();

        for (String dir : arr) {
            if (!stack.isEmpty() && isOpposite(stack.peekLast(), dir)) {
                stack.removeLast();
            } else {
                stack.addLast(dir);
            }
        }

        return stack.toArray(new String[0]);
    }

    private static boolean isOpposite(String a, String b) {
        return (a.equals("NORTH") && b.equals("SOUTH"))
                || (a.equals("SOUTH") && b.equals("NORTH"))
                || (a.equals("EAST") && b.equals("WEST"))
                || (a.equals("WEST") && b.equals("EAST"));
    }
}
