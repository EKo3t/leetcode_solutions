package shadow.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">Task description</a>
 */
class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty())
                    return false;

                if (c == '}' && stack.peekLast() != '{' ||
                    c == ']' && stack.peekLast() != '[' ||
                    c == ')' && stack.peekLast() != '('
                )
                    return false;
                else
                    stack.pollLast();
            }
        }
        return stack.isEmpty();
    }
}
