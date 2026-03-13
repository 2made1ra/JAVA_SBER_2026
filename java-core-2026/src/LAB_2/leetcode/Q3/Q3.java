package LAB_2.leetcode.Q3;

import static java.util.Arrays.sort;

public class Q3 {
    public static void main(String[] args) {
        int[] nums1, nums2;
        int val1, val2;
        int[] expectedNums1, expectedNums2;
        Solution solution = new Solution();

        // Тест 1
        nums1 = new int[] {3, 2, 2, 3};
        val1 = 3;
        expectedNums1 = new int[] {2, 2};
        runTest(solution, nums1, val1, expectedNums1);

        // Тест 2
        nums2 = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        val2 = 2;
        expectedNums2 = new int[] {0, 1, 3, 0, 4};
        runTest(solution, nums2, val2, expectedNums2);
    }

    public static void runTest(
            Solution sol,
            int[] nums,
            int val,
            int[] expected
    ) {
        int k = sol.removeElement(nums, val);

        if (k != expected.length) {
            System.out.printf("Ошибка! Ожидали длину k = %d, а получили %d%n", expected.length, k);
        } else {
            System.out.printf("Успех: длина k совпадает (%d)%n", k);
        }

        sort(nums, 0, k);
        sort(expected);
        for (int i = 0; i < expected.length; i++) {
            if (nums[i] != expected[i]) {
                throw new RuntimeException(
                        String.format("Ошибка на индексе %d! Ожидали %d, но получили %d",
                                i, expected[i], nums[i])
                );
            }
            System.out.printf("Элемент %d проверен: PASSED%n", i);
        }
    }
}
