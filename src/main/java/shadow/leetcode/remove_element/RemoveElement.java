package shadow.leetcode.remove_element;

/**
 * @see <a href="https://leetcode.com/problems/remove-element/">Task description</a>
 */
class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int leftElementsIndex = -1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val && i > ++leftElementsIndex)
                    nums[leftElementsIndex] = nums[i];
        // we need count, not index. Count starts from 1, index from 0. We add 1
        return ++leftElementsIndex;
    }
}
