package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">Task description</a>
 * Difficulty: easy
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = root.left != null ? maxDepth(root.left) : -1;
        int rightDepth = root.right != null ? maxDepth(root.right) : -1;
        return Integer.max(leftDepth, rightDepth) + 1;
    }
}
