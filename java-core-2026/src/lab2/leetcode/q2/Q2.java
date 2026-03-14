package lab2.leetcode.q2;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1, nums2, nums3;
        int n1, n2, n3;

        // Тест 1
        nums1 = new int[] {2, 5, 1, 3, 4, 7};
        n1 = 3;
        int[] expected1 = {2, 3, 5, 4, 1, 7};
        runTest(solution, 1, n1, nums1, expected1);

        // Тест 2
        nums2 = new int[] {1, 2, 3, 4, 4, 3, 2, 1};
        n2 = 4;
        int[] expected2 = {1, 4, 2, 3, 3, 2, 4, 1};
        runTest(solution, 2, n2, nums2, expected2);

        // Тест 3
        nums3 = new int[] {1, 1, 2, 2};
        n3 = 2;
        int[] expected3 = {1, 2, 1, 2};
        runTest(solution, 3, n3, nums3, expected3);
    }

    public static void runTest(
            Solution sol,
            int testCaseNum,
            int n,
            int[] input,
            int[] expected
    ) {
        int[] result = sol.shuffle(input, n);
        boolean isPassed = Arrays.equals(result, expected);

        System.out.println("Test Case " + testCaseNum + ": " + (isPassed ? "PASSED" : "FAILED"));
        System.out.println("Input:    nums = " + Arrays.toString(input) + ", n = " + n);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + Arrays.toString(result));
        System.out.println("---------------------------------------------------");
    }
}
