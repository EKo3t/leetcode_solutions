package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-difference-between-increasing-elements/">Task description</a>
 * Difficulty: easy
 */
public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int[] maximums = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (max < nums[i])
                max = nums[i];

            maximums[i] = max;
        }
        int maxDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxDiff < maximums[i + 1] - nums[i]) {
                maxDiff = maximums[i + 1] - nums[i];
            }
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }
}
