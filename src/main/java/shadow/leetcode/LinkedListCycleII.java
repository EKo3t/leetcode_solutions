package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii">Task description</a>
 * Difficulty: medium
 */
public class LinkedListCycleII {

    public IntListNode detectCycle(IntListNode head) {
        var current = head;
        Set<IntListNode> visited = new HashSet<>();
        while (current != null) {
            if (visited.contains(current))
                return current;

            visited.add(current);
            current = current.next;
        }
        return null;
    }
}
