package shadow.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/submissions/">Task description</a>
 * Difficulty: easy
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>();
        for (int num : nums) {
            if (distinctNums.contains(num))
                return true;
            distinctNums.add(num);
        }
        return false;
    }
}
