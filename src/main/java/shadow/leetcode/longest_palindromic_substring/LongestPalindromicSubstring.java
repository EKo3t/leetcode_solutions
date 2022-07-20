package shadow.leetcode.longest_palindromic_substring;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">Task description</a>
 */
class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int maxPalindromeLength = -1;
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {

            // i is assumed middle of palindrome, and binary search to find maximum palindrome length
            int oddPalindromSholder = getOddPalindromeSholder(s, i);
            int evenPalindromeShoulder = getEvenPalindromeShoulder(s, i);
            if (oddPalindromSholder * 2 + 1 > maxPalindromeLength) {
                maxPalindromeLength = oddPalindromSholder * 2 + 1;
                longestPalindrome = s.substring(i - oddPalindromSholder, i + oddPalindromSholder + 1);
            }

            if (evenPalindromeShoulder * 2 > maxPalindromeLength) {
                maxPalindromeLength = evenPalindromeShoulder * 2;
                longestPalindrome = s.substring(i - evenPalindromeShoulder + 1, i + evenPalindromeShoulder + 1);
            }
        }
        return longestPalindrome;
    }

    private int getOddPalindromeSholder(String s, int i) {
        int minLength = 0;
        int maxlength = Integer.min(i, s.length() - i - 1);
        while (minLength < maxlength) {
            int currentLength = (minLength + maxlength + 1) / 2;
            String leftPart = new StringBuilder(s.substring(i - currentLength, i + 1)).reverse().toString();
            String rightPart = s.substring(i, i + currentLength + 1);
            if (!leftPart.equals(rightPart)) {
                maxlength = currentLength - 1;
            } else {
                minLength = currentLength;
            }
        }
        return minLength;
    }

    private int getEvenPalindromeShoulder(String s, int i) {
        if (i == s.length() - 1) {
            return -1;
        }
        int minLength = 0;
        int maxLength = Integer.min(i + 1, s.length() - i - 1);
        if (maxLength == 1) {
            return s.charAt(i) == s.charAt(i + 1) ? 1 : -1;
        }
        while (minLength < maxLength) {
            int currentLength = (minLength + maxLength + 1) / 2;
            String leftPart = new StringBuilder(s.substring(i - currentLength + 1, i + 1)).reverse().toString();
            String rightPart = s.substring(i + 1, i + currentLength + 1);
            if (!leftPart.equals(rightPart)) {
                maxLength = currentLength - 1;
            } else {
                minLength = currentLength;
            }
        }
        return minLength;
    }
}
