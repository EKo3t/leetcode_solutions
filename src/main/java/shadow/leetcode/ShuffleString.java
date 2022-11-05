package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/shuffle-string/">Task description</a>
 * Difficulty: easy
 */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] shuffled = new char[s.length()];
        char[] strChars = s.toCharArray();
        for (int i = 0; i < strChars.length; i++) {
            shuffled[indices[i]] = strChars[i];
        }
        return new String(shuffled);
    }
}
