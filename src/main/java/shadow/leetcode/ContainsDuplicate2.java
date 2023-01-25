package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">Task description</a>
 * Difficulty: easy
 */
public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, TreeSet<Integer>> window = new HashMap<>();
        if (nums.length < 2) {
            return false;
        }
        if (k > nums.length) {
            k = nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            int indexToRemove = i - k - 1;
            if (indexToRemove >= 0) {
                TreeSet<Integer> indexes = window.get(nums[indexToRemove]);
                indexes.remove(indexToRemove);
                if (indexes.isEmpty()) {
                    window.remove(nums[indexToRemove]);
                }
            }

            TreeSet<Integer> indexes = addIndexByNumber(nums, window, i);
            if (checkDuplicate(k, i, indexes))
                return true;
        }
        return false;
    }

    private TreeSet<Integer> addIndexByNumber(int[] nums, Map<Integer, TreeSet<Integer>> window, int i) {
        TreeSet<Integer> indexes = window.get(nums[i]);
        if (indexes == null) {
            indexes = new TreeSet<>();
        }
        indexes.add(i);
        window.put(nums[i], indexes);
        return indexes;
    }

    private boolean checkDuplicate(int k, int i, TreeSet<Integer> indexes) {
        indexes.remove(i);
        if (!indexes.isEmpty()) {
            @SuppressWarnings("ConstantConditions")
            int closestFloor = indexes.floor(i);
            if (Math.abs(closestFloor - i) <= k) return true;

            @SuppressWarnings("ConstantConditions")
            int closestCeiling = indexes.ceiling(i);
            if (Math.abs(closestCeiling - i) <= k) return true;
        }

        indexes.add(i);
        return false;
    }
}
