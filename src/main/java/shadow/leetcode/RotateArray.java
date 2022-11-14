package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Task description</a>
 * Difficulty: medium
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        // rotate first part before k
        rotateSubArray(nums, 0, nums.length - k);
        // rotate second part after k
        rotateSubArray(nums, nums.length - k, nums.length);
        // rotate whole array
        rotateSubArray(nums, 0, nums.length);
    }

    // rotates sub array. R is exclusive
    private void rotateSubArray(int[] elements, int l, int r) {
        for (int i = l; i < (r + l) / 2; i++) {
            int temp = elements[i];
            elements[i] = elements[r - i + l - 1];
            elements[r - i + l - 1] = temp;
        }
    }
}
