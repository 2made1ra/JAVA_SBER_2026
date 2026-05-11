package lab6.algo.task1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/description/">Valid Parentheses</a>
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> openedBrackets = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                openedBrackets.push(current);
            } else {
                if (openedBrackets.isEmpty() || !matches(openedBrackets.pop(), current)) {
                    return false;
                }
            }
        }

        return openedBrackets.isEmpty();
    }

    private boolean matches(char opened, char closed) {
        return opened == '(' && closed == ')'
                || opened == '[' && closed == ']'
                || opened == '{' && closed == '}';
    }
}
