package LAB_2.leetcode.Q2;

/**
 * <a href="https://leetcode.com/problems/shuffle-the-array/description/">Ссылка на задачу</a>
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];

        for (int i = 0; i < 2 * n; i += 2) {
            result[i] = nums[i / 2];
            result[i + 1] = nums[i / 2 + n];
        }

        return result;
    }
}
