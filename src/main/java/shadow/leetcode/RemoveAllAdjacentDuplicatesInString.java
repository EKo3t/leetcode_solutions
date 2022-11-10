package shadow.leetcode;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;

        while (index < sb.length() - 1) {
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                sb.delete(index, index + 2);
                if (index > 0) {
                    index --;
                }
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
