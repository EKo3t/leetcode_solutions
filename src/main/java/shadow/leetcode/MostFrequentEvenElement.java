package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/most-frequent-even-element/">Task description</a>
 * Difficulty: easy
 */
public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> numByOccurrence = new HashMap<>();
        int maxOccurrence = -1;
        int numb = Integer.MAX_VALUE;
        for (int num : nums)
            if (num % 2 == 0) {
                numByOccurrence.compute(num, (k, v) -> v == null ? 1 : v + 1);
                var occurrence = numByOccurrence.get(num);
                if (occurrence > maxOccurrence || occurrence == maxOccurrence && num < numb) {
                    numb = num;
                    maxOccurrence = occurrence;
                }
            }
        return numb == Integer.MAX_VALUE ? -1 : numb;
    }
}
