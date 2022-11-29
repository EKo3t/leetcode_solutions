package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindrome/">Task description</a>
 * Difficulty: easy
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> occurrenceByChar = new HashMap<>();

        for (char aChar : chars) {
            occurrenceByChar.compute(aChar, (character, integer) -> {
                if (integer == null)
                    return 1;
                return integer + 1;
            });
        }

        // for palindrome with odd length
        boolean hasOddValues = false;

        int palindromeLength = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : occurrenceByChar.entrySet()) {
            if (characterIntegerEntry.getValue() % 2 == 1) {
                if (!hasOddValues) palindromeLength++;
                hasOddValues = true;
            }

            palindromeLength += characterIntegerEntry.getValue() / 2 * 2;
        }
        return palindromeLength;
    }
}
