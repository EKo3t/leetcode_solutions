package shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int index1 = 0, index2, index3;
        while (index1 < sortedNums.length - 2) {
            index2 = index1 + 1;
            index3 = sortedNums.length - 1;

            while (index3 > index2) {
                int sum = sortedNums[index1] + sortedNums[index2] + sortedNums[index3];
                if (sum == 0) {
                    triplets.add(Arrays.asList(sortedNums[index1], sortedNums[index2], sortedNums[index3]));
                }
                if (sum < 0) {
                    index2 += 1;
                }
                if (sum > 0) {
                    index3 -= 1;
                }
            }

            index1 += 1;
        }
        return triplets;
    }
}
