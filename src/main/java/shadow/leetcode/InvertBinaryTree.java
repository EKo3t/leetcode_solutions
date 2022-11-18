package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree">Task description</a>
 * Difficulty: easy
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) iterateNodeChildren(root);
        return root;
    }

    private void iterateNodeChildren(TreeNode node) {
        if (node.left != null) iterateNodeChildren(node.left);
        if (node.right != null) iterateNodeChildren(node.right);
        swapChildren(node);
    }

    private void swapChildren(TreeNode node) {
        var temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
