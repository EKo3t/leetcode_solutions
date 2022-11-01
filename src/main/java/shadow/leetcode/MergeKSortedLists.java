package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public IntListNode mergeKLists(IntListNode[] lists) {
        PriorityQueue<IntListNode> listsQueue = new PriorityQueue<>(
            Comparator.comparingInt(list -> list.val)
        );
        for (IntListNode list : lists) {
            if (list != null) {
                listsQueue.add(list);
            }
        }

        IntListNode root = new IntListNode();
        IntListNode current = root;
        while (!listsQueue.isEmpty()) {
            IntListNode node = listsQueue.poll();
            IntListNode newNode = new IntListNode();
            newNode.val = node.val;
            current.next = newNode;
            current = newNode;
            node = node.next;
            if (node != null) {
                listsQueue.add(node);
            }
        }
        return root.next;
    }
}
