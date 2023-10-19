package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Task description</a>
 * Difficulty: medium
 */
public class ReverseLinkedListII {

    public IntListNode reverseBetween(IntListNode head, int left, int right) {
        IntListNode reversedPart = null;
        IntListNode fakeRoot = new IntListNode(0, head);
        IntListNode firstAfterReverse = null;
        var currentNode = head;
        int index = 1;
        while (currentNode != null) {
            if (index >= left && index <= right) {
                if (reversedPart != null)
                    reversedPart = new IntListNode(currentNode.val, reversedPart);
                else
                    reversedPart = new IntListNode(currentNode.val, null);
            }
            if (index == right + 1)
                firstAfterReverse = currentNode;
            currentNode = currentNode.next;
            index++;
        }

        currentNode = fakeRoot;
        index = 0;
        while (currentNode != null) {
            if (index == left - 1) {
                currentNode.next = reversedPart;
            }
            if (index == right) {
                currentNode.next = firstAfterReverse;
            }
            index++;
            currentNode = currentNode.next;
        }
        return fakeRoot.next;
    }
}
