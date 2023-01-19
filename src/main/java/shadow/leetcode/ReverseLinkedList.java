package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list">Task description</a>
 * Difficulty: easy
 */
public class ReverseLinkedList {

    public IntListNode reverseList(IntListNode head) {
        if (head == null) return null;

        IntListNode previousNode = null;
        IntListNode current = head;

        while (current != null) {
            IntListNode currentCopy = new IntListNode(current.val);
            currentCopy.next = previousNode;
            previousNode = currentCopy;

            current = current.next;
        }

        return previousNode;
    }
}
