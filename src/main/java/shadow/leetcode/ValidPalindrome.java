package shadow.leetcode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < sb.length()) {
            char value = sb.charAt(index);
            if (value >= 'A' && value <= 'Z' || value >= 'a' && value <= 'z' || value >= '0' && value <= '9') {
                sb.setCharAt(index, Character.toLowerCase(value));
                index += 1;
            } else
                sb.delete(index, index + 1);
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
