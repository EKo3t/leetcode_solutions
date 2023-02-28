package shadow.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/letter-tile-possibilities">Task description</a>
 * Difficulty: medium
 */
public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        char[] chars = tiles.toCharArray();
        combineWords(new StringBuilder(), result, chars);

        return result.size();
    }

    private void combineWords(StringBuilder current, Set<String> result, char[] chars) {
        for (int i = 0; i < chars.length; i++) if (chars[i] != '#') {
            current.append(chars[i]);
            result.add(current.toString());

            char temp = chars[i];
            chars[i] = '#';

            combineWords(current, result, chars);

            current.deleteCharAt(current.length() - 1);
            chars[i] = temp;
        }
    }
}
