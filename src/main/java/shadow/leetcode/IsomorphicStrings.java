package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/isomorphic-strings">Task description</a>
 * Difficulty: easy
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> secCharByFirstChar = new HashMap<>();
        Map<Character, Character> firstCharBySecChar = new HashMap<>();

        char[] firstChars = s.toCharArray();
        char[] secondChars = t.toCharArray();

        for (int i = 0; i < firstChars.length; i++) {
            char currentSecondStrChar = secondChars[i];
            char currentFirstStrChar = firstChars[i];

            Character mappedSecMapChar = secCharByFirstChar.get(currentFirstStrChar);
            Character mappedFirstMapChar = firstCharBySecChar.get(currentSecondStrChar);
            if (mappedFirstMapChar == null && mappedSecMapChar == null) {
                secCharByFirstChar.put(currentFirstStrChar, currentSecondStrChar);
                firstCharBySecChar.put(currentSecondStrChar, currentFirstStrChar);
            }
            else if (mappedFirstMapChar == null || mappedSecMapChar == null)
                return false;
            else if ((mappedSecMapChar != currentSecondStrChar) || (mappedFirstMapChar != currentFirstStrChar))
                return false;
        }
        return true;
    }
}
