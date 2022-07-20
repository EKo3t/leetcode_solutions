package shadow.leetcode.happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/happy-number/">Task description</a>
 */
class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();
        int currentNumber = n;
        boolean isCycled = false;
        while (currentNumber != 1 && !isCycled) {
            currentNumber = calculateSumOfSquaredDigits(currentNumber);
            if (hashSet.contains(currentNumber))
                isCycled = true;

            hashSet.add(currentNumber);
        }
        return currentNumber == 1;
    }

    private int calculateSumOfSquaredDigits(int n) {
        int result = 0;
        while (n > 0) {
            byte lastDigit = (byte) (n % 10);
            result += lastDigit * lastDigit;
            n /= 10;
        }
        return result;
    }


}
