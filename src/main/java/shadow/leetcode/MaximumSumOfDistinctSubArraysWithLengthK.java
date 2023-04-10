package shadow.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k">Task description</a>
 * Difficulty: medium
 */
public class MaximumSumOfDistinctSubArraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> values = new HashSet<>();

        long maxSum = 0;
        long currentSum = 0;
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (values.contains(nums[i]) || (i - leftIndex > k - 1))
                while (values.contains(nums[i]) || (i - leftIndex > k - 1)) {
                    currentSum -= nums[leftIndex];
                    values.remove(nums[leftIndex++]);
                }

            values.add(nums[i]);
            currentSum += nums[i];
            if (i - leftIndex == k - 1)
                maxSum = Long.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
