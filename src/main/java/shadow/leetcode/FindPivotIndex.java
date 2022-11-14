package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/find-pivot-index/">Task description</a>
 * Difficulty: easy
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            leftSum += i > 0 ? nums[i - 1] : 0;
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
