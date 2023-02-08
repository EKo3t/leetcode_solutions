package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-ii/">Task description</a>
 * Difficulty: medium
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int[] minimumStepsForIndex = new int[nums.length];
        Arrays.fill(minimumStepsForIndex, Integer.MAX_VALUE);
        minimumStepsForIndex[0] = 0;

        for (int i = 0; i < nums.length - 1; i++)
            if (minimumStepsForIndex[i] < Integer.MAX_VALUE && nums[i] > 0)
                for (int j = 1; j <= nums[i]; j++)
                    if (i + j < nums.length)
                        minimumStepsForIndex[i + j] = Integer.min(minimumStepsForIndex[i + j], minimumStepsForIndex[i] + 1);

        return minimumStepsForIndex[nums.length - 1];
    }
}
