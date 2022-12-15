package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/smallest-value-of-the-rearranged-number">Task description</a>
 * Difficulty: medium
 */
public class SmallestValueOfTheRearrangedNumber {

    public long smallestNumber(long num) {
        if (num == 0)
            return 0;

        boolean isPositive = num > 0;
        char[] digits = toDigitArray(num);
        Arrays.sort(digits);
        if (isPositive) {
            int zeroCount = calcZeroCount(digits);

            String numberText = digits[zeroCount] + // first non-zero
                "0".repeat(zeroCount) +
                (zeroCount + 1 < digits.length ? String.valueOf(Arrays.copyOfRange(digits, zeroCount + 1, digits.length)) : "");

            return Long.parseLong(numberText);
        } else {
            reverse(digits);
            return Long.parseLong("-" + String.valueOf(digits));
        }
    }

    private void reverse(char[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private char[] toDigitArray(long number) {
        number = Math.abs(number);
        return Long.toString(number).toCharArray();
    }

    private int calcZeroCount(char[] chars) {
        int zeroCount = 0;
        for (char aChar : chars)
            if (aChar == '0')
                zeroCount = zeroCount + 1;

        return zeroCount;
    }
}
