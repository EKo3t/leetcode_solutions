package shadow.leetcode.longest_common_prefix;

import java.util.Set;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
