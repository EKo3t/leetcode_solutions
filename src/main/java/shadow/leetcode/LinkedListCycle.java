package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Task description</a>
 * Difficulty: medium
 */
public class LinkedListCycle {

    public boolean hasCycle(IntListNode head) {
        IntListNode slowPointer = head;
        IntListNode fastPointer = head;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                return false;
            }
            fastPointer = fastPointer.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
