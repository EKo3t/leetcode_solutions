package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/rearrange-array-elements-by-sign/">Task description</a>
 * Difficulty: medium
 */
public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int negativeIndex = 1;
        int positiveIndex = 0;

        for (int num : nums) {
            if (num < 0) {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
            if (num > 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            }
        }
        return result;
    }
}
