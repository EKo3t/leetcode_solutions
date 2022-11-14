package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/move-zeroes/">Task description</a>
 * Difficulty: easy
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int amountOfZeros = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0)
                amountOfZeros++;
            else
                nums[nonZeroIndex++] = nums[i];

        for (int i = nums.length - amountOfZeros; i < nums.length; i++)
            nums[i] = 0;
    }
}
