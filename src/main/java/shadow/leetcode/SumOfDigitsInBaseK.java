package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/sum-of-digits-in-base-k">Task description</a>
 * Difficulty: easy
 */
public class SumOfDigitsInBaseK {

    public int sumBase(int n, int k) {
        String conversion = Integer.toString(n, k);
        return conversion.chars().sum() - 48 * conversion.length();
    }
}
