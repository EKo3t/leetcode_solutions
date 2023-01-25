package shadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Task description</a>
 * Difficulty: medium
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagramsMap = new HashMap<>();
        for (String str : strs) {
            int[] charactersCounts = new int[26];
            char[] strChars = str.toCharArray();
            for (char strChar : strChars) {
                charactersCounts[strChar - 'a'] += 1;
            }
            StringBuilder keySb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charactersCounts[i] > 0) {
                    keySb.append(i).append(':').append(charactersCounts[i]).append(';');
                }
            }
            String key = keySb.toString();
            List<String> anagrams = groupedAnagramsMap.computeIfAbsent(key, k -> new ArrayList<>());
            anagrams.add(str);
        }
        return new ArrayList<>(groupedAnagramsMap.values());
    }
}
