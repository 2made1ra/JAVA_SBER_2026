package lab5.algo.task1;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/description/">Roman to Integer</a>
 */
public class Solution {

    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = valueOf(s.charAt(i));
            int next = i + 1 < s.length() ? valueOf(s.charAt(i + 1)) : 0;

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    private int valueOf(char romanDigit) {
        switch (romanDigit) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Unknown roman digit: " + romanDigit);
        }
    }
}
