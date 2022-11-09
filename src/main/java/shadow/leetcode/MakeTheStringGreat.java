package shadow.leetcode;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

/**
 * @see <a href="https://leetcode.com/problems/make-the-string-great/">Task description</a>
 * Difficulty: easy
 */
public class MakeTheStringGreat {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);

        int index = 0;
        while (index < sb.length() - 1) {
            char curChar = sb.charAt(index);
            char nextChar = sb.charAt(index + 1);
            if (isUpperCase(curChar) && nextChar == toLowerCase(curChar) ||
                isUpperCase(nextChar) && curChar == toLowerCase(nextChar)
            ) {
                sb.delete(index, index + 2);
                if (index > 0)
                    index--;
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
