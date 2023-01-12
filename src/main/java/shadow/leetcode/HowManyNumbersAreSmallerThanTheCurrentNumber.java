package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number">Task description</a>
 * Difficulty: easy
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;

                if (nums[j] < nums[i]) counter++;
            }
            result[i] = counter;
        }

        return result;
    }
}
