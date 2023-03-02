package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/string-compression">Task description</a>
 * Difficulty: medium
 */
public class StringCompression {

    public int compress(char[] chars) {
        char currentChar = chars[0];
        int groupSize = 1;
        int compressedIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                groupSize += 1;
            } else {
                compressedIndex = appendCompressedData(chars, compressedIndex, currentChar, groupSize);
                currentChar = chars[i];
                groupSize = 1;
            }
        }
        compressedIndex = appendCompressedData(chars, compressedIndex, currentChar, groupSize);
        return compressedIndex;
    }

    private int appendCompressedData(char[] chars, int compressedIndex, char currentChar, int groupSize) {
        chars[compressedIndex++] = currentChar;
        if (groupSize > 1) {
            char[] numberAsChars = Integer.toString(groupSize).toCharArray();
            for (char numberAsChar : numberAsChars) chars[compressedIndex++] = numberAsChar;
        }
        return compressedIndex;
    }

}
