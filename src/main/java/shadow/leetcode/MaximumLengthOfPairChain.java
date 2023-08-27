package shadow.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">Task description</a>
 * Difficulty: medium
 */
public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        var test = new int[][] {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        var solution = new MaximumLengthOfPairChain().findLongestChain(test);
        System.out.println(solution);
    }

    public int findLongestChain(int[][] pairs) {
        int[] maxChain = new int[pairs.length];
        int max = 1;
        Arrays.sort(pairs, Comparator.comparing(ints -> ints[0]));

        maxChain[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            maxChain[i] = 1;
            var currentFirst = pairs[i][0];
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < currentFirst && (maxChain[j] + 1 > maxChain[i])) {
                    maxChain[i] = maxChain[j] + 1;
                    max = Integer.max(maxChain[i], max);
                }
            }
        }
        return max;
    }
}
