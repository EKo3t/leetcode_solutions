package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">Task description</a>
 * Difficulty: medium
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static final int[] NO_RESULT = {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return NO_RESULT;
        int targetIndexLeft = find(nums, target, 0, nums.length - 1, false);
        if (targetIndexLeft == -1)
            return NO_RESULT;
        int targetIndexRight = find(nums, target, targetIndexLeft, nums.length - 1, true);
        return new int[] {targetIndexLeft, targetIndexRight};
    }

    private int find(int[] nums, int target, int l, int r, boolean findLastOccurrence) {
        while (r - l > 1) {
            int mid = (l + r + 1) / 2;
            if (findLastOccurrence && nums[mid] <= target || !findLastOccurrence && nums[mid] < target)
                l = mid;
            if (findLastOccurrence && nums[mid] > target || !findLastOccurrence && nums[mid] >= target)
                r = mid;
        }
        if (findLastOccurrence && nums[r] == target) return r;
        if (!findLastOccurrence && nums[l] == target) return l;
        return nums[l] == target ? l : nums[r] == target ? r : -1;
    }
}
