package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Task description</a>
 * Difficulty: easy
 */
class RemoveLinkedListElements {

    public IntListNode removeElements(IntListNode head, int val) {
        IntListNode iterator = head;
        IntListNode root = new IntListNode();
        root.next = head;
        IntListNode previousNode = root;
        while (iterator != null) {
            if (iterator.val == val) {
                previousNode.next = iterator.next;
            } else {
                previousNode = iterator;
            }
            iterator = iterator.next;
        }
        return root.next;
    }

}
