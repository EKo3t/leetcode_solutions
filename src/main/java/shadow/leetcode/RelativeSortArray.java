package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/relative-sort-array">Task description</a>
 * Difficulty: easy
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        int[] numbers = new int[1001];
        for (int num : arr1) numbers[num]++;

        int counter = 0;
        for (int i : arr2)
            if (numbers[i] > 0) {
                for (int j = 0; j < numbers[i]; j++) {
                    result[counter] = i;
                    counter++;
                }
                numbers[i] = 0;
            }

        int counter2 = 0;
        for (int i = 0; i <= 1000; i++)
            if (numbers[i] > 0)
                for (int j = 0; j < numbers[i]; j++) {
                    result[counter + counter2] = i;
                    counter2++;
                }

        return result;
    }
}
