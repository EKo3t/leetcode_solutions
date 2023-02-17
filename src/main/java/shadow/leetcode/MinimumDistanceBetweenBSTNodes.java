package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @see <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes">Task description</a>
 * Difficulty: easy
 */
public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        Set<Integer> values = new TreeSet<>(iterate(root));
        int min = Integer.MAX_VALUE;
        int previous = -500000;
        for (Integer value : values) {
            min = Math.min(min, value - previous);
            previous = value;
        }
        return min;
    }

    private Collection<Integer> iterate(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Set<Integer> values = new HashSet<>();
        values.addAll(iterate(root.left));
        values.addAll(iterate(root.right));
        values.add(root.val);
        return values;
    }
}
