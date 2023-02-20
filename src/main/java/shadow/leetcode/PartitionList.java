package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/partition-list">Task description</a>
 * Difficulty: medium
 */
public class PartitionList {

    public IntListNode partition(IntListNode head, int x) {
        IntListNode lessThanXRoot = new IntListNode();
        IntListNode lessThanXCurrent = lessThanXRoot;
        IntListNode moreThanXRoot = new IntListNode();
        IntListNode moreThanXCurrent = moreThanXRoot;

        IntListNode current = head;
        while (current != null) {
            var copy = new IntListNode(current.val);
            if (current.val < x) {
                lessThanXCurrent.next = copy;
                lessThanXCurrent = copy;
            } else {
                moreThanXCurrent.next = copy;
                moreThanXCurrent = copy;
            }
            current = current.next;
        }
        lessThanXCurrent.next = moreThanXRoot.next;
        return lessThanXRoot.next;
    }
}
