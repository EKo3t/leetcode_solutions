package shadow.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements">Task description</a>
 * difficulty: medium
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberByOccurrence = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            numberByOccurrence.compute(nums[i], (key, value) -> value == null ? 1 : value + 1);

        int max = numberByOccurrence.values().stream().mapToInt(value -> value).max().getAsInt();

        Set<Integer>[] occurrences = new Set[max + 1];
        for (Map.Entry<Integer, Integer> entry : numberByOccurrence.entrySet()) {
            if (occurrences[entry.getValue()] == null) occurrences[entry.getValue()] = new HashSet<>();
            occurrences[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int counter = 0;
        for (int i = max; i >= 0; i--) {
            if (occurrences[i] != null)
                for (Integer integer : occurrences[i]) {
                    result[counter++] = integer;
                    if (counter == k)
                        break;
                }
            if (counter == k)
                break;
        }
        return result;
    }
}
