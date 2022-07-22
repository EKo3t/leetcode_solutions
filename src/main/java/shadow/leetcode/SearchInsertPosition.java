package shadow.leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleElement = nums[middleIndex];

            if (middleElement < target) {
                leftIndex = leftIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        if (leftIndex == nums.length - 1 && nums[leftIndex] < target)
            return leftIndex + 1;
        else
            return leftIndex;
    }
}
