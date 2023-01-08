package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/divide-two-integers">Task description</a>
 * Difficulty: medium
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            if (dividend != Integer.MIN_VALUE) return 0;
            return 1;
        }

        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        boolean isDividendMinValue = false;
        if (dividend == Integer.MIN_VALUE) {
            isDividendMinValue = true;
            dividend += 1;
        }

        if (dividend < 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        }
        boolean isNegativeResult = dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int remaining = dividend;
        int result = 0;
        int currentMultiplier = 1;
        int toSubstract = divisor;

        while (remaining > 0) {
            if (remaining - toSubstract >= toSubstract) {
                currentMultiplier += currentMultiplier;
                toSubstract += toSubstract;
            } else {
                if (currentMultiplier == 1 && remaining < toSubstract) {
                    break;
                }
                remaining -= toSubstract;
                result += currentMultiplier;
                currentMultiplier = 1;
                toSubstract = divisor;
            }
        }

        if (isDividendMinValue) remaining += 1;
        if (remaining >= toSubstract)
            result += currentMultiplier;

        return isNegativeResult ? -result : result;
    }
}
