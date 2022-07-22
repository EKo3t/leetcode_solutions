package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Task description</a>
 */
class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charsByIndex = new HashMap<>();
        int substringBeginIndex = 0;
        int maxLength = 0;

        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int substringEndIndex = 0; substringEndIndex < length; substringEndIndex++) {
            if (!charsByIndex.containsKey(chars[substringEndIndex])) {
                maxLength = returnMaximum(substringBeginIndex, substringEndIndex, maxLength);
            } else {
                int repeatedCharIndex = charsByIndex.get(chars[substringEndIndex]);
                while (substringBeginIndex <= repeatedCharIndex) {
                    charsByIndex.remove(chars[substringBeginIndex]);
                    substringBeginIndex++;
                }
            }
            charsByIndex.put(chars[substringEndIndex], substringEndIndex);
        }

        maxLength = returnMaximum(substringBeginIndex, length - 1, maxLength);
        return maxLength;
    }

    private int returnMaximum(int substringBeginIndex, int substringEndIndex, int maxLength) {
        if (maxLength < substringEndIndex - substringBeginIndex + 1) {
            maxLength = substringEndIndex - substringBeginIndex + 1;
        }
        return maxLength;
    }
}
