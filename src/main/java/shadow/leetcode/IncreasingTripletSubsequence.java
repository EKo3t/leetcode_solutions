package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Task description</a>
 * Difficulty: medium
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int[] minFrom1ToIndex = new int[nums.length];
        int[] maxFromIndexToEnd = new int[nums.length];

        // filling minFrom1ToIndex
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            minFrom1ToIndex[i] = min;
        }

        // filling maxFromIndexToEnd
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
            }
            maxFromIndexToEnd[i] = max;
        }

        // iterating middle element
        for (int i = 1; i < nums.length - 1; i++) {
            if (minFrom1ToIndex[i - 1] < nums[i] && nums[i] < maxFromIndexToEnd[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
