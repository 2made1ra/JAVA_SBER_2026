package lab4.algo.task1;

import java.util.*;


/**
 * <a href="https://www.codewars.com/kata/550554fd08b86f84fe000a58/java">Which are in?</a>
 */
public class Solution {

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> result = new ArrayList<>();

        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s2.contains(s1)) {
                    if (!result.contains(s1)) {
                        result.add(s1);
                    }
                    break;
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
