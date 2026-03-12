package LAB_2.leetcode.Q1;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Тест 1
        int[] nums1 = {1, 2, 1};
        int[] expected1 = {1, 2, 1, 1, 2, 1};
        runTest(solution, 1, nums1, expected1);

        // Тест 2
        int[] nums2 = {1, 3, 2, 1};
        int[] expected2 = {1, 3, 2, 1, 1, 3, 2, 1};
        runTest(solution, 2, nums2, expected2);
    }

    public static void runTest(
            Solution solution,
            int testCaseNum,
            int[] input,
            int[] expected
    ) {
        int[] result = solution.getConcatenation(input);
        boolean isPassed = Arrays.equals(result, expected);

        System.out.println("Test Case " + testCaseNum + ": " + (isPassed ? "PASSED" : "FAILED"));
        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result:   " + Arrays.toString(result));
        System.out.println("---------------------------------------------------");
    }
}
