package lab2.leetcode.q3;

/**
 * <a href="https://leetcode.com/problems/remove-element/description/">Ссылка на задачу</a>
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
