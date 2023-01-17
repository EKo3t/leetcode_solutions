package shadow.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/next-greater-element-i">Task description</a>
 * Difficulty: easy
 */
public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> firstBiggerElementByIndex = new HashMap<>();
        LinkedList<Integer> ints = new LinkedList<>();

        for (int value : nums2) {
            while (!ints.isEmpty() && ints.peekLast() < value)
                firstBiggerElementByIndex.put(ints.pollLast(), value);

            ints.add(value);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            result[i] = firstBiggerElementByIndex.getOrDefault(nums1[i], -1);

        return result;
    }
}
