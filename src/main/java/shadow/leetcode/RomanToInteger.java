package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/roman-to-integer">Task description</a>
 * Difficulty: easy
 */
public class RomanToInteger {

    private static final Map<Character, Integer> VALUE_BY_ROMAN = new HashMap<>();

    static {
        VALUE_BY_ROMAN.put('I', 1);
        VALUE_BY_ROMAN.put('V', 5);
        VALUE_BY_ROMAN.put('X', 10);
        VALUE_BY_ROMAN.put('L', 50);
        VALUE_BY_ROMAN.put('C', 100);
        VALUE_BY_ROMAN.put('D', 500);
        VALUE_BY_ROMAN.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            char next = i + 1 < chars.length ? chars[i + 1] : 'q';
            if (cur == 'C' && (next == 'D' || next == 'M')) {
                result += next == 'D' ? 400 : 900;
                i += 1;
                continue;
            }
            if (cur == 'X' && (next == 'L' || next == 'C')) {
                result += next == 'L' ? 40 : 90;
                i += 1;
                continue;
            }
            if (cur == 'I' && (next == 'V' || next == 'X')) {
                result += next == 'V' ? 4 : 9;
                i += 1;
                continue;
            }
            result += VALUE_BY_ROMAN.get(cur);
        }
        return result;
    }
}
