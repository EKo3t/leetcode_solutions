package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs">Task description</a>
 * Difficulty: medium
 */
public class SwapNodesInPairs {

    public IntListNode swapPairs(IntListNode head) {
        if (head == null) return null;

        IntListNode fakeRoot = new IntListNode();
        fakeRoot.next = head;
        IntListNode previousNode = fakeRoot;
        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.next != null) {
                var nextNode = currentNode.next;
                currentNode.next = nextNode.next;
                nextNode.next = currentNode;
                previousNode.next = nextNode;
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else break;
        }
        return fakeRoot.next;
    }
}
