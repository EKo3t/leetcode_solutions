package shadow.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">Task description</a>
 * Difficulty: hard
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> numsAsSet = new HashSet<>(Arrays
            .stream(nums)
            .boxed()
            .toList()
        );
        for (int i = 1; i <= nums.length + 1; i++)
            if (!numsAsSet.contains(i))
                return i;

        return -1;
    }
}
