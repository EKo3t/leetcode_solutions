package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/running-sum-of-1d-array/">Task description</a>
 * Difficulty: easy
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            result[i] = (i > 0 ? result[i - 1] : 0) + nums[i];

        return result;
    }
}
