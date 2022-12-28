package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/kth-missing-positive-number">Task description</a>
 * Difficulty: medium
 */
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int counter;
        int missedCounter = 0;
        int index = 0;
        for (counter = 1; counter <= k + arr.length + 1; counter++) {
            if (index < arr.length && arr[index] == counter) {
                index += 1;
                continue;
            }
            missedCounter++;
            if (missedCounter == k) break;
        }
        return counter;
    }
}
