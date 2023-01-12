package shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(nums).boxed().toList());
        int len = nums.length;
        int[] p = new int[nums.length + 1];
        for (int i = 0; i <= len; i++) p[i] = i;
        int i = 1;
        while (i < len) {
            p[i]--;
            int j = i % 2 == 1 ? p[i] : 0;
            swap(nums, j, i);
            i = 1;
            while (p[i] == 0) {
                p[i] = i;
                i++;
            }
            result.add(Arrays.stream(nums).boxed().toList());
        }
        return result;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
