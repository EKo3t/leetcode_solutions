package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">Task description</a>
 * Difficulty: easy
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int[] maxSums = new int[nums.length];
        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSums[i] = Integer.max(i - 2 >= 0 ? maxSums[i - 2] : 0, i - 3 >= 0 ? maxSums[i - 3] : 0) + nums[i];
            maxResult = Integer.max(maxResult, maxSums[i]);
        }
        return maxResult;
    }
}
