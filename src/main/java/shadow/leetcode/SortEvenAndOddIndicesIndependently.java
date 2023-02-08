package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/sort-even-and-odd-indices-independently">Task description</a>
 * Difficulty: easy
 */
public class SortEvenAndOddIndicesIndependently {

    public int[] sortEvenOdd(int[] nums) {
        int[] odd = new int[nums.length / 2];
        int[] even = new int[(nums.length + 1) / 2];
        for (int i = 0; i < nums.length; i++)
            if ((i & 1) == 0) even[i / 2] = nums[i]; else odd[i / 2] = nums[i];

        Arrays.sort(odd);
        reverse(odd);
        Arrays.sort(even);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            result[i * 2] = even[i];
            result[i * 2 + 1] = odd[i];
        }
        // this is strange condition because for array of 5 elements, last element is 4, so we need to take from even array
        if ((nums.length & 1) == 1) result[nums.length - 1] = even[even.length - 1];
        return result;
    }

    private void reverse(int[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int swap = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = swap;
        }
    }
}
