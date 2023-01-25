package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @see <a href="https://leetcode.com/problems/majority-element/">Task description</a>
 * Difficulty: easy
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int maxCount = 0;
        int max = 0;

        Map<Integer, Integer> countByNumber = new HashMap<>();
        for (int num : nums) {
            countByNumber.compute(num, (key, value) ->
                Optional.ofNullable(value).orElse(0) + 1
            );
            if (countByNumber.get(num) > maxCount) {
                maxCount = countByNumber.get(num);
                max = num;
            }
        }

        return max;
    }
}
