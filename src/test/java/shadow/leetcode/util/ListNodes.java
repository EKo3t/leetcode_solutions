package shadow.leetcode.util;

public final class ListNodes {

    public static IntListNode convert(int[] array) {
        IntListNode root = new IntListNode();
        IntListNode currentNode = root;
        for (int i : array) {
            currentNode.next = new IntListNode(i);
            currentNode = currentNode.next;
        }
        return root.next;
    }

    public static boolean areEqual(IntListNode node1, IntListNode node2) {
        IntListNode iterator1 = node1;
        IntListNode iterator2 = node2;
        while (iterator1 != null) {
            if (iterator2 == null || iterator2.val != iterator1.val) {
                return false;
            }
            iterator2 = iterator2.next;
            iterator1 = iterator1.next;
        }
        return iterator2 == null;
    }
}
