package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Task description</a>
 * Difficulty: medium
 */
public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = findWithBinarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != - 1) {
                return new int[] {i + 1, index + 1};
            }
        }
        throw new IllegalStateException("Unreachable state exception");
    }

    public int findWithBinarySearch(int[] nums, int l, int r, int target) {
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
