package LAB_2.leetcode.Q4;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] digits1 = {1, 2, 3};
        int[] expected1 = {1, 2, 4};
        runTest(solution, 1, digits1, expected1);

        int[] digits2 = {4, 3, 2, 1};
        int[] expected2 = {4, 3, 2, 2};
        runTest(solution, 2, digits2, expected2);

        int[] digits3 = {9};
        int[] expected3 = {1, 0};
        runTest(solution, 3, digits3, expected3);

        int[] digits4 = {9, 9, 9};
        int[] expected4 = {1, 0, 0, 0};
        runTest(solution, 4, digits4, expected4);
    }

    public static void runTest(
            Solution solution,
            int testCaseNum,
            int[] input,
            int[] expected
    ) {
        int[] inputCopy = input.clone();
        int[] result = solution.plusOne(input);
        boolean isPassed = Arrays.equals(result, expected);

        System.out.println("Test Case " + testCaseNum + ": " + (isPassed ? "PASSED" : "FAILED"));
        System.out.println("Input:    " + Arrays.toString(inputCopy));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result:   " + Arrays.toString(result));
        System.out.println("---------------------------------------------------");
    }
}

