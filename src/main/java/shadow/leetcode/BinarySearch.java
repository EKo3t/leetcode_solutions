package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/binary-search/">Task description</a>
 * Difficulty: medium
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = (l + r) / 2;
            if (nums[middle] > target)
                r = middle - 1;
            if (nums[middle] < target)
                l = middle + 1;
            if (nums[middle] == target)
                return middle;
        }
        return nums[l] == target ? l : -1;
    }
}
