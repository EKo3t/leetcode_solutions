package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/">Task description</a>
 * Difficulty: medium
 */
public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int ySum = 0;
        for (char aChar : chars)
            if (aChar == 'Y') ySum++;

        int currentNSum = 0;
        int min = ySum;
        int minIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'N') {
                currentNSum++;
            } else {
                ySum--;
            }
            if (currentNSum + ySum < min) {
                min = currentNSum + ySum;
                minIndex = i + 1;
            }
        }
        return minIndex;
    }
}
