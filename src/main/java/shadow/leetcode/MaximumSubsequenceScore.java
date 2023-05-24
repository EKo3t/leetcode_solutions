package shadow.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subsequence-score/">Task description</a>
 * Difficulty: medium
 */
public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            pairs[i] = new Pair(nums1[i], nums2[i]);
        Arrays.sort(pairs, Comparator.comparing(o -> o.value2, Comparator.reverseOrder()));
        long currentSum = 0;
        PriorityQueue<Integer> bestSum = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            bestSum.add(pairs[i].value1);
            currentSum += pairs[i].value1;
        }
        long max = Long.MIN_VALUE;
        for (int i = k - 1; i < pairs.length; i++) {
            max = Long.max((long) (currentSum + pairs[i].value1) * pairs[i].value2, max);
            if (k > 1 && pairs[i].value1 > bestSum.peek()) {
                currentSum -= bestSum.poll();
                bestSum.add(pairs[i].value1);
                currentSum += pairs[i].value1;
            }
        }
        return max;
    }

    private record Pair(int value1, int value2) {
    }
}
