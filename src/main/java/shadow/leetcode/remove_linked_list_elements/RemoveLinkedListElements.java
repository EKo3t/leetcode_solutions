package shadow.leetcode.remove_linked_list_elements;

class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode iterator = head;
        ListNode root = new ListNode();
        root.next = head;
        ListNode previousNode = root;
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
