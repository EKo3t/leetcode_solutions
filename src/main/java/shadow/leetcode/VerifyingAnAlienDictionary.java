package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/verifying-an-alien-dictionary">Task description</a>
 * Difficulty: easy
 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++)
            if (compareUsingAlienOrder(words[i - 1], words[i], order) > 0)
                return false;

        return true;
    }

    private int compareUsingAlienOrder(String s1, String s2, String order) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (i >= chars2.length)
                return 1;
            if (chars1[i] != chars2[i]) {
                int index1 = order.indexOf(chars1[i]);
                int index2 = order.indexOf(chars2[i]);
                return Integer.compare(index1, index2);
            }
        }
        return 0;
    }
}
