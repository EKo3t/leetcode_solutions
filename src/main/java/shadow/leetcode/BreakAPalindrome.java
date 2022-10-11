package shadow.leetcode;

public class BreakAPalindrome {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] palindromeChars = palindrome.toCharArray();

        boolean isChanged = false;
        for (int i = 0; i < palindromeChars.length; i++) {
            if (i == palindromeChars.length / 2) {
                continue;
            }

            if (palindromeChars[i] != 'a' ){
                palindromeChars[i] = 'a';
                isChanged = true;
                break;
            }
        }
        if (!isChanged) {
            palindromeChars[palindromeChars.length - 1] = 'b';
        }
        return new String(palindromeChars);
    }
}
