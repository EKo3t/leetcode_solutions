package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list">Task description</a>
 * Difficulty: easy
 */
public class RemoveDuplicatesFromSortedList {

    public IntListNode deleteDuplicates(IntListNode head) {
        if (head == null) return null;

        IntListNode previous = head;
        IntListNode current = head.next;

        while (current != null) {
            if (current.val == previous.val)
                previous.next = current.next;
            else
                previous = current;

            current = current.next;
        }
        return head;
    }
}
