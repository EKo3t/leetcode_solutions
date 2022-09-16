package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Task description</a>
 * Difficulty: easy
 */
class MergeTwoSortedLists {

    public IntListNode mergeTwoLists(IntListNode list1, IntListNode list2) {
        IntListNode root = new IntListNode();
        IntListNode mergeIterator = root;
        boolean takeFirst;
        IntListNode iterator1 = list1;
        IntListNode iterator2 = list2;
        while (iterator1 != null || iterator2 != null) {
            takeFirst = iterator1 != null && (iterator2 == null || iterator2.val >= iterator1.val);

            if (takeFirst) {
                mergeIterator.next = new IntListNode(iterator1.val);
                iterator1 = iterator1.next;
            } else {
                mergeIterator.next = new IntListNode(iterator2.val);
                iterator2 = iterator2.next;
            }
            mergeIterator = mergeIterator.next;
        }
        return root.next;
    }
}
