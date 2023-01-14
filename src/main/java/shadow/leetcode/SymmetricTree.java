package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/symmetric-tree">Task description</a>
 * Difficulty: easy
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return areEqual(root.left, root.right);
    }

    public boolean areEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return areEqual(node1.left, node2.right) && areEqual(node1.right, node2.left);
    }
}
