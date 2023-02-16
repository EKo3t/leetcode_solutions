package shadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;

/**
 * @see <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Task description</a>
 * Difficulty: medium
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> occurrencesByChar = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars)
            occurrencesByChar.compute(aChar, (character, integer) -> {
                if (integer == null) return 1;
                return integer + 1;
            });

        var entries = new ArrayList<>(occurrencesByChar.entrySet());
        entries.sort(reverseOrder(comparingInt(Map.Entry::getValue)));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        return sb.toString();
    }
}
