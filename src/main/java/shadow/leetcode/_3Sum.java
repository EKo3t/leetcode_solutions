package shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/3sum">Task description</a>
 * difficulty: medium
 */
public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < sorted.length - 2; i++) {
            if (sorted[i] > 0) break;
            for (int j = i + 1; j < sorted.length - 1; j++) {
                if (sorted[j] + sorted[i] > 0) break;

                Integer index = findNumber(-sorted[i] - sorted[j], sorted, j + 1, sorted.length - 1);
                if (index != null)
                    result.add(List.of(sorted[i], sorted[j], sorted[index]));
            }
        }
        return new ArrayList<>(result);
    }

    private Integer findNumber(int number, int[] array, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (array[mid] > number) r = mid;

            if (array[mid] < number) l = mid + 1;
            if (array[mid] == number) break;
        }
        return array[(l + r) / 2] == number ? (l + r) / 2 : null;
    }
}
