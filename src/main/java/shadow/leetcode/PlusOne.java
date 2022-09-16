package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/plus-one/">Task description</a>
 * Difficulty: easy
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (areAllDigitNines(digits)) {
            return createNumberWith1AndZeros(digits.length);
        }

        int digitToInc = 1;
        int[] response = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            response[i] += digits[i] + digitToInc;
            if (response[i] > 9) {
                digitToInc = 1;
                response[i] = 0;
            } else {
                digitToInc = 0;
            }
        }
        return response;
    }

    private int[] createNumberWith1AndZeros(int amountOfZeros) {
        int[] digit = new int[amountOfZeros + 1];
        digit[0] = 1;
        return digit;
    }

    private boolean areAllDigitNines(int[] digits) {
        boolean allNines = true;
        for (int digit : digits) {
            if (digit != 9) {
                allNines = false;
                break;
            }
        }
        return allNines;
    }
}
