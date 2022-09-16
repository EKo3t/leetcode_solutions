package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Task description</a>
 * Difficulty: medium
 */
class ImplementStrStr_Naive {

    public int strStr(String haystack, String needle) {
        char[] subStrChars = needle.toCharArray();
        char[] strChars = haystack.toCharArray();

        for (int i = 0; i < strChars.length - subStrChars.length + 1; i++) {
            char strChar = strChars[i];
            if (strChar == subStrChars[0]) {
                boolean isSubstringFound = true;
                for (int j = 1; j < subStrChars.length; j++) {
                    if (subStrChars[j] != strChars[i + j]) {
                        isSubstringFound = false;
                        break;
                    }
                }
                if (isSubstringFound) {
                    return i;
                }
            }
        }
        return -1;
    }
}
