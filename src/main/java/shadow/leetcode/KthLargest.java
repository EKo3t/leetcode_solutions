package shadow.leetcode;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream">Task description</a>
 * Difficulty: easy
 */
public class KthLargest {

    private PriorityQueue<Integer> largest = new PriorityQueue<>();
    private int capacity;

    public KthLargest(int k, int[] nums) {
        largest = new PriorityQueue<>(k);
        this.capacity = k;
        for (int num : nums)
            add(largest, num);
    }

    public int add(int val) {
        return add(largest, val);
    }

    private int add(PriorityQueue<Integer> values, int value) {
        if (values.size() < capacity)
            values.add(value);
        else if (values.peek() < value) {
            values.poll();
            values.add(value);
        }
        return values.peek();
    }
}
