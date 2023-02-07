package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/jewels-and-stones">Task description</a>
 * Difficulty: easy
 */
public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (char c : stones.toCharArray())
            result += jewels.indexOf(c) != -1 ? 1 : 0;
        return result;
    }
}
