package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/single-number/">Task description</a>
 * Difficulty: easy
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
