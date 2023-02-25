package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array">Task description</a>
 * Difficulty: medium
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums[0] > nums[nums.length - 1]) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int middle = (l + r) / 2;
                if (nums[middle] > nums[r])
                    l = middle + 1;
                else if (nums[l] > nums[middle])
                    r = middle;
                else break;
            }
            int index1 = findIndexOf(target, nums, 0, l - 1);
            int index2 = findIndexOf(target, nums, l, nums.length - 1);
            return index1 != -1 ? index1 : index2;
        } else
            return findIndexOf(target, nums, 0, nums.length - 1);
    }

    private int findIndexOf(int number, int[] nums, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            int middle = (l + r) / 2;
            if (nums[middle] > number)
                r = middle - 1;

            if (nums[middle] < number)
                l = middle + 1;

            if (nums[middle] == number)
                return middle;
        }

        return nums[l] == number ? l : -1 ;
    }
}
