package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/ugly-number/">Task description</a>
 * Difficulty: easy
 */
public class UglyNumber {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] primeFactors = new int[] {2, 3, 5};
        for (int primeFactor : primeFactors) {
            while (n % primeFactor == 0) n /= primeFactor;
        }
        return n == 1;
    }
}
