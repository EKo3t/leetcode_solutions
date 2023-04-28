package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/3sum-closest">Task description</a>
 * difficulty: medium
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                closestSum = Math.abs(currentSum - target) < Math.abs(closestSum - target) ? currentSum : closestSum;
                if (currentSum > target) {
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else return target;
            }
        }
        return closestSum;
    }
}
