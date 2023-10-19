package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/backspace-string-compare">Task description</a>
 * Difficulty: easy
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return applyBackspace(s).equals(applyBackspace(t));
    }

    private String applyBackspace(String s) {
        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!sb.isEmpty())
                    sb.deleteCharAt(sb.length() - 1);
            } else
                sb.append(c);
        }
        return sb.toString();
    }

}
