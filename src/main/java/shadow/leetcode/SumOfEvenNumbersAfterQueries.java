package shadow.leetcode;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] sumsAfterQueries = new int[queries.length];
        int sum = Arrays.stream(nums).filter(value -> value % 2 == 0).sum();

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int delta = query[0];
            int index = query[1];
            int oldValue = nums[index];
            nums[index] += delta;
            if (oldValue % 2 == 0)
                sum -= oldValue;

            if (nums[index] % 2 == 0)
                sum += nums[index];

            sumsAfterQueries[i] = sum;
        }
        return sumsAfterQueries;
    }
}
