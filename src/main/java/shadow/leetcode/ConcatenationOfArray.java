package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/concatenation-of-array">Task description</a>
 * Difficulty: easy
 */
public class ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length * 2; i++) {
            result[i] = nums[i];
            result[nums.length + i] = nums[i];
        }
        return result;
    }
}
