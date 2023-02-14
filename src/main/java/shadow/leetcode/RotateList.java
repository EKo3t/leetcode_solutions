package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/rotate-list">Task description</a>
 * Difficulty: medium
 */
public class RotateList {

    public IntListNode rotateRight(IntListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        int nodesCount = countNodes(head);
        if (k >= nodesCount) k = k % nodesCount;
        if (k == 0) return head;

        IntListNode previous = null;
        var current = head;
        for (int i = 0; i < nodesCount - k; i++) {
            previous = current;
            current = current.next;
        }

        var newFirst = current;
        while (current.next != null) current = current.next;

        current.next = head;
        previous.next = null;

        return newFirst;
    }

    private int countNodes(IntListNode head) {
        int counter = 1;
        var current = head;
        while (current.next != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }
}
