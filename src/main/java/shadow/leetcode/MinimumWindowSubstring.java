package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring">Task description</a>
 * Difficulty: hard
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String minWindow = "";

        char[] firstStrChars = s.toCharArray();
        // only big and small latin letters. 26 + 26. Capitalized go first
        int[] charCount = toCharCount(t);
        int[] windowCharCount = new int[52];
        boolean[] filledChars = new boolean[52];

        int requiredCount = (int) Arrays.stream(charCount).filter(value -> value > 0).count();

        int l = 0;
        int filledCount = 0;
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < s.length(); r++) {
            result.append(firstStrChars[r]);
            filledCount = updateCounts(firstStrChars[r], windowCharCount, charCount, filledCount, filledChars);

            if (filledCount == requiredCount) {
                while (canDeleteCharacter(firstStrChars[l], windowCharCount, charCount)) {
                    windowCharCount[getIndexToIncrease(firstStrChars[l])]--;
                    l++;
                    result.delete(0, 1);
                }

                if (minWindow.equals("") || minWindow.length() > result.length())
                    minWindow = result.toString();
            }
        }

        return minWindow;
    }

    private int[] toCharCount(String str) {
        int[] result = new int[52];
        char[] chars = str.toCharArray();
        for (char aChar : chars)
            result[getIndexToIncrease(aChar)]++;

        return result;
    }

    private int updateCounts(char ch, int[] windowCharCount, int[] charCounts, int filledCount, boolean[] filledChars) {
        int index = getIndexToIncrease(ch);
        windowCharCount[index]++;
        if (charCounts[index] > 0 && windowCharCount[index] >= charCounts[index] && !filledChars[index]) {
            filledChars[index] = true;
            filledCount++;
        }
        return filledCount;
    }

    private boolean canDeleteCharacter(char ch, int[] windowCharCount, int[] charCount) {
        int index = getIndexToIncrease(ch);
        return charCount[index] == 0 || windowCharCount[index] - 1 >= charCount[index];
    }

    private int getIndexToIncrease(char ch) {
        return ch >= 'A' && ch <= 'Z' ? ch - 'A' : ch - 'a' + 26;
    }
}
