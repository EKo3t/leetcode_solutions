package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Task description</a>
 */
class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                uniqueIndex++;
                if (i > uniqueIndex) {
                    nums[uniqueIndex] = nums[i];
                }
            }
        }
        return uniqueIndex + 1;
    }
}
