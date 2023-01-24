package shadow.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Task description</a>
 * Difficulty: medium
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, Character[]> LETTERS_BY_DIGIT_IN_PHONE;

    static {
        LETTERS_BY_DIGIT_IN_PHONE = new HashMap<>();
        LETTERS_BY_DIGIT_IN_PHONE.put('2', new Character[]{'a', 'b', 'c'});
        LETTERS_BY_DIGIT_IN_PHONE.put('3', new Character[]{'d', 'e', 'f'});
        LETTERS_BY_DIGIT_IN_PHONE.put('4', new Character[]{'g', 'h', 'i'});
        LETTERS_BY_DIGIT_IN_PHONE.put('5', new Character[]{'j', 'k', 'l'});
        LETTERS_BY_DIGIT_IN_PHONE.put('6', new Character[]{'m', 'n', 'o'});
        LETTERS_BY_DIGIT_IN_PHONE.put('7', new Character[]{'p', 'q', 'r', 's'});
        LETTERS_BY_DIGIT_IN_PHONE.put('8', new Character[]{'t', 'u', 'v'});
        LETTERS_BY_DIGIT_IN_PHONE.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        char[] digitChars = digits.toCharArray();
        int length = digitChars.length;

        List<String> result = new ArrayList<>();

        byte currentIndex = 0;
        byte[] indexes = new byte[digitChars.length];
        StringBuilder combination = new StringBuilder();
        // when we iterate all letters for 0-th index digit it will be over
        while (notIteratedAllLetters(digitChars[0], indexes[0])) {
            char currentDigit = digitChars[currentIndex];
            byte letterIndex = indexes[currentIndex];
            boolean iteratedLettersForDigit = iteratedLettersForDigit(currentDigit, letterIndex);

            if (iteratedLettersForDigit) {
                nullifyCurrentIndex(indexes, currentIndex);
                combination.deleteCharAt(currentIndex);
                indexes[--currentIndex]++;
                continue;
            }

            if (combination.length() == currentIndex + 1)
                combination.deleteCharAt(currentIndex);

            appendLetterByIndexByDigit(combination, currentDigit, letterIndex);

            if (reachedStrLength(currentIndex, length)) {
                result.add(combination.toString());
                indexes[currentIndex]++;
            }

            if (notReachedStrLength(currentIndex, length))
                currentIndex++;
        }
        return result;
    }

    private boolean notReachedStrLength(byte currentIndex, int length) {
        return currentIndex < length - 1;
    }

    private boolean reachedStrLength(byte currentIndex, int length) {
        return currentIndex == length - 1;
    }

    private void nullifyCurrentIndex(byte[] indexes, byte currentIndex) {
        indexes[currentIndex] = 0;
    }

    private boolean iteratedLettersForDigit(char digit, int currentIndex) {
        return LETTERS_BY_DIGIT_IN_PHONE.get(digit).length <= currentIndex;
    }

    private boolean notIteratedAllLetters(char digit, int currentIndex) {
        return LETTERS_BY_DIGIT_IN_PHONE.get(digit).length > currentIndex;
    }

    private void appendLetterByIndexByDigit(StringBuilder sb, char digit, int letterIndex) {
        sb.append(LETTERS_BY_DIGIT_IN_PHONE.get(digit)[letterIndex]);
    }
}
