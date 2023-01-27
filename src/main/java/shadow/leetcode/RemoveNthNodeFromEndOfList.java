package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">Task description</a>
 * Difficulty: medium
 */
public class RemoveNthNodeFromEndOfList {

    public IntListNode removeNthFromEnd(IntListNode head, int n) {
        IntListNode fakeRoot = new IntListNode();
        fakeRoot.next = head;
        IntListNode beforeNthNode = null;
        IntListNode nthNodeFromTheEnd = null;

        IntListNode current = head;
        int counter = 1;
        while (current != null) {
            if (counter >= n) {
                if (nthNodeFromTheEnd == null) {
                    nthNodeFromTheEnd = head;
                    beforeNthNode = fakeRoot;
                } else {
                    nthNodeFromTheEnd = nthNodeFromTheEnd.next;
                    beforeNthNode = beforeNthNode.next;
                }
            }
            current = current.next;
            counter++;
        }
        beforeNthNode.next = nthNodeFromTheEnd.next;
        return fakeRoot.next;
    }
}
