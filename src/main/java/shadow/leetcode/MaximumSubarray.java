package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray">Task description</a>
 * Difficulty: medium
 */
public class MaximumSubarray {

    // Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currentSum += num;

            if (maxSum < currentSum) maxSum = currentSum;
            if (currentSum < 0) currentSum = 0;
        }
        return maxSum;
    }
}
