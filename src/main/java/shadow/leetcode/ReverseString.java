package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-string/">Task description</a>
 * Difficulty: easy
 */
public class ReverseString {

    public void reverseString(char[] s) {
        revertSubArray(s, 0, s.length);
    }

    private void revertSubArray(char[] elements, int l, int r) {
        for (int i = l; i < (r + l) / 2; i++) {
            char temp = elements[i];
            elements[i] = elements[r - i + l - 1];
            elements[r - i + l - 1] = temp;
        }
    }
}
