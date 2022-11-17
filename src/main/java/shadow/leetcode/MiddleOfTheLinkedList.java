package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Task description</a>
 * Difficulty: easy
 */
public class MiddleOfTheLinkedList {

    public IntListNode middleNode(IntListNode head) {
        IntListNode iterator = head;
        IntListNode x2SlowerIterator = head;
        boolean increasedSlower = false;
        while (iterator.next != null) {
            if (!increasedSlower) {
                x2SlowerIterator = x2SlowerIterator.next;
                increasedSlower = true;
            } else {
                increasedSlower = false;
            }
            iterator = iterator.next;
        }
        return x2SlowerIterator;
    }
}
