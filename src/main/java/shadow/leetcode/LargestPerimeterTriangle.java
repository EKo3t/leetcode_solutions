package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Task description</a>
 * Difficulty: easy
 */
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
