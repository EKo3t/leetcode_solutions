package shadow.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/add-to-array-form-of-integer">Task description</a>
 * Difficulty: easy
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int counter = num.length - 1;
        int oneToNextDigit = 0;
        while (counter >= 0 && k >= 0) {
            int current = num[counter] + k % 10 + oneToNextDigit;
            if (current > 9) {
                oneToNextDigit = 1;
                current -= 10;
            } else oneToNextDigit = 0;
            result.addFirst(current);
            counter--;
            k = k / 10;
        }
        if (k > 0) {
            k += oneToNextDigit;
            oneToNextDigit = 0;
            while (k > 0) {
                result.addFirst(k % 10);
                k /= 10;
            }
        }
        if (oneToNextDigit > 0)
            result.addFirst(1);
        return result;
    }

}
