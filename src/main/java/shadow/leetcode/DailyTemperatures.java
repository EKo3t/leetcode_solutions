package shadow.leetcode;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/daily-temperatures">Task description</a>
 * Difficulty: medium
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToWarmUp = new int[temperatures.length];
        LinkedList<Integer> daysExpectingWarmUp = new LinkedList<>();
        daysExpectingWarmUp.add(0);

        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            while (!daysExpectingWarmUp.isEmpty() && temperatures[daysExpectingWarmUp.peekLast()] < temperature) {
                int index = daysExpectingWarmUp.pollLast();
                daysToWarmUp[index] = i - index;
            }
            daysExpectingWarmUp.add(i);
        }

        return daysToWarmUp;
    }
}
