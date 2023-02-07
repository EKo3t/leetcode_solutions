package shadow.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/sum-of-unique-elements">Task description</a>
 * Difficulty: easy
 */
public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        return Arrays
            .stream(nums)
            .boxed()
            .collect(Collectors.groupingBy((Integer value) -> value, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() < 2)
            .map(Map.Entry::getKey)
            .reduce(0, Integer::sum);
    }
}
