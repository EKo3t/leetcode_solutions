package shadow.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/minimum-operations-to-halve-array-sum">Task description</a>
 * Difficulty: medium
 */
public class MinimumOperationsToHalveArraySum {

    public int halveArray(int[] nums) {
        double sum = 0;
        for (int num : nums) sum += num;

        PriorityQueue<Double> elements = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums)
            elements.add((double) num);

        double half = sum / 2.0;
        double currentSum = sum;
        int iterationCount = 0;
        while (!elements.isEmpty() && currentSum > half) {
            Double biggestElement = elements.poll();
            currentSum -= biggestElement / 2.0;
            elements.add(biggestElement / 2.0);
            iterationCount += 1;
        }
        return iterationCount;
    }
}
