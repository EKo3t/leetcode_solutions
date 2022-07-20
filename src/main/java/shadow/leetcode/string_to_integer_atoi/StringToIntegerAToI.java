package shadow.leetcode.string_to_integer_atoi;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class StringToIntegerAToI {

    private static final char ZERO = '0';
    
    public int myAtoi(String s) {
        // removing different trash from string
        String cleanStr = s.trim();
        if (cleanStr.isEmpty()) {
            return 0;
        }

        // converting
        int result = 0;
        boolean isPositive = true;
        State currentState = State.START;
        CharacterIterator iterator = new StringCharacterIterator(cleanStr);
        while (iterator.current() != CharacterIterator.DONE) {
            char chr = iterator.current();
            if (currentState == State.START) {
                if (isSign(chr)) {
                    currentState = State.SIGN;
                    if (chr == '-')
                        isPositive = false;
                } else if (Character.isDigit(chr)) {
                    result = chr - ZERO;
                    currentState = State.DIGIT;
                } else {
                    break;
                }
            } else if (currentState == State.SIGN && Character.isDigit(chr)) {
                result = chr - ZERO;
                currentState = State.DIGIT;
            } else if (currentState == State.DIGIT && Character.isDigit(chr)) {
                var isInBounds = isInBounds(result, chr - ZERO, isPositive);
                if (!isInBounds) {
                    result = isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    break;
                } else {
                    result = result * 10 + (chr - ZERO);
                }
            } else {
                break;
            }
            iterator.next();
        }
        return isPositive ? result : -result;
    }

    private boolean isInBounds(int result, int digit, boolean isPositive) {
        if (result == 0)
            return true;
        if (isPositive && (Integer.MAX_VALUE - digit) / result < 10)
            return false;
        if (!isPositive && (Integer.MIN_VALUE + digit) / result > -10)
            return false;

        return true;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private enum State {
        START,
        SIGN,
        DIGIT
    }
}
