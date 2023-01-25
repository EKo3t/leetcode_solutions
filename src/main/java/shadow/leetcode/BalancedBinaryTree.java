package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">Task description</a>
 * Difficulty: easy
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        try {
            calculateDepthAndCheckForBalance(root);
            return true;
        } catch (NotBalancedException ex) {
            return false;
        }
    }

    private int calculateDepthAndCheckForBalance(TreeNode node) throws NotBalancedException {
        if (node.left == null && node.right == null) return 1;

        int leftSubtreeDepth = node.left != null ? calculateDepthAndCheckForBalance(node.left) : 0;
        int rightSubtreeDepth = node.right != null ? calculateDepthAndCheckForBalance(node.right) : 0;

        if (isNotBalanced(leftSubtreeDepth, rightSubtreeDepth))
            throw new NotBalancedException();

        return Integer.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
    }

    private boolean isNotBalanced(int leftDepth, int rightDepth) {
        return Math.abs(leftDepth - rightDepth) > 1;
    }

    private static class NotBalancedException extends RuntimeException { }
}
