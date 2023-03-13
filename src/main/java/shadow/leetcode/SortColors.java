package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/sort-colors">Task description</a>
 * Difficulty: medium
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) counts[num]++;

        int sum = Arrays.stream(counts).sum();
        for (int i = 0; i < sum; i++)
            nums[i] = i < counts[0] ? 0 : i < counts[1] ? 1 : 2;
    }
}
