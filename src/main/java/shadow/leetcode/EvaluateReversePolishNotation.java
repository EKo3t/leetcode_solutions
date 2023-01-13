package shadow.leetcode;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">Task description</a>
 * Difficulty: medium
 */
public class EvaluateReversePolishNotation {

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPERATION_MAP;

    static {
        OPERATION_MAP = new HashMap<>();
        OPERATION_MAP.put('-', (o1, o2) -> o1 - o2);
        OPERATION_MAP.put('+', Integer::sum);
        OPERATION_MAP.put('*', (o1, o2) -> o1 * o2);
        OPERATION_MAP.put('/', (o1, o2) -> o1 / o2);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        for (String token : tokens) {
            if (token.matches("^[-]?\\d+$"))
                queue.add(Integer.parseInt(token));
            else {
                int secondOperand = queue.pollLast();
                int firstOperand = queue.pollLast();
                char operator = token.charAt(0);
                queue.add(OPERATION_MAP.get(operator).apply(firstOperand, secondOperand));
            }
        }
        return queue.poll();
    }
}
