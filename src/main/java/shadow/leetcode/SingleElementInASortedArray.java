package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array">Task description</a>
 * Difficulty: medium
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 2;
        while (l < r) {
            int middle = (l + r) / 2;
            if (middle % 2 == 0) {
                if (nums[middle] != nums[middle + 1])
                    r = middle;
                else
                    l = middle + 1;
            } else {
                if (nums[middle] != nums[middle + 1])
                    l = middle + 1;
                else
                    r = middle;
            }
        }
        if (l == nums.length - 2)
            return nums[nums.length - 1];
        else
            return nums[l];
    }

}
