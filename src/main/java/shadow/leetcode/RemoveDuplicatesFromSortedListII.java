package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">Task description</a>
 * Difficulty: medium
 */
public class RemoveDuplicatesFromSortedListII {

    public IntListNode deleteDuplicates(IntListNode head) {
        if (head == null) return null;

        IntListNode root = new IntListNode();
        int value = - 1000, counter = 0;
        IntListNode lastNode = root;
        IntListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.val != value) {
                if (counter == 1) {
                    lastNode.next = new IntListNode(value);
                    lastNode = lastNode.next;
                }
                counter = 1;
                value = currentNode.val;
            } else
                counter++;

            currentNode = currentNode.next;
        }
        if (counter == 1)
            lastNode.next = new IntListNode(value);

        return root.next;
    }
}
