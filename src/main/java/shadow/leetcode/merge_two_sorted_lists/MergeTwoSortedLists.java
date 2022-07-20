package shadow.leetcode.merge_two_sorted_lists;

/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Task description</a>
 */
class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode mergeIterator = root;
        boolean takeFirst;
        ListNode iterator1 = list1;
        ListNode iterator2 = list2;
        while (iterator1 != null || iterator2 != null) {
            takeFirst = iterator1 != null && (iterator2 == null || iterator2.val >= iterator1.val);

            if (takeFirst) {
                mergeIterator.next = new ListNode(iterator1.val);
                iterator1 = iterator1.next;
            } else {
                mergeIterator.next = new ListNode(iterator2.val);
                iterator2 = iterator2.next;
            }
            mergeIterator = mergeIterator.next;
        }
        return root.next;
    }
}
