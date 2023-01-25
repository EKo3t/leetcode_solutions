package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Task description</a>
 * Difficulty: medium
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        // because we have numbers from -10000 but arrays start from 0
        int deltaToReduce = 10000;
        int[] numberOccurences = new int[20001];
        for (int num : nums) {
            numberOccurences[num + deltaToReduce] += 1;
        }
        int counter = 0;
        for (int i = 20000; i >= 0; i--) {
            int realNumber = i - deltaToReduce;
            counter += numberOccurences[i];
            if (counter >= k) {
                return realNumber;
            }
        }
        return -10000;
    }
}
