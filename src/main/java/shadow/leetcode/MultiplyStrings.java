package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/multiply-strings">Task description</a>
 * Difficulty: medium
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        byte[] digits1 = convertDigitStringToByteArray(num1);
        byte[] digits2 = convertDigitStringToByteArray(num2);
        reverse(digits1);
        reverse(digits2);
        if (digits1.length < digits2.length) {
            byte[] temp = digits1;
            digits1 = digits2;
            digits2 = temp;
        }

        byte[] result = new byte[digits1.length + digits2.length];
        for (int i = 0; i < digits2.length; i++) {
            byte[] multiplyByDigit = multiplyByDigit(digits1, digits2[i]);
            sumSecondWithOffset(result, multiplyByDigit, i);
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : result) sb.append(b);

        String resultStr = sb.reverse().toString();
        return resultStr.charAt(0) == '0' ? resultStr.substring(1) : resultStr;
    }

    private void reverse(byte[] array) {
        byte temp;
        int len = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[len - 1 - i];
            array[len - 1 - i] = array[i];
            array[i] = temp;
        }
    }



    private byte[] convertDigitStringToByteArray(String number) {
        byte[] result = new byte[number.length()];
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result[i] = (byte) (chars[i] - '0');
        }
        return result;
    }

    private byte[] multiplyByDigit(byte[] digits, byte digit) {
        byte[] result = new byte[digits.length + 1];
        byte nextRankDigit = 0;
        for (int i = 0; i < digits.length; i++) {
            byte digitMultiply = (byte) (digits[i] * digit + nextRankDigit);
            nextRankDigit = (byte) (digitMultiply / 10);
            if (digitMultiply > 9)
                digitMultiply = (byte) (digitMultiply % 10);

            result[i] = digitMultiply;
        }
        if (nextRankDigit != 0) {
            result[digits.length] = nextRankDigit;
            return result;
        } else
            return Arrays.copyOf(result, digits.length);
    }

    private void sumSecondWithOffset(byte[] digits1, byte[] digits2, int offset) {
        byte nextRankDigit = 0;
        for (int i = 0; i < digits2.length || nextRankDigit > 0; i++) {
            digits1[i + offset] += (i >= digits2.length ? 0 : digits2[i]) + nextRankDigit;
            nextRankDigit = digits1[i + offset] > 9 ? (byte) 1 : (byte) 0;
            if (digits1[i + offset] > 9)
                digits1[i + offset] -= 10;
        }
    }
}
