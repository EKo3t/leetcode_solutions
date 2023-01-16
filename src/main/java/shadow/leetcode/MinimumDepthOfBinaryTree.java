package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">Task description</a>
 * Difficulty: easy
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = root.left != null ? minDepth(root.left) : 0;
        int rightDepth = root.right != null ? minDepth(root.right) : 0;
        return leftDepth == 0
            ? rightDepth + 1
            : rightDepth == 0 ? leftDepth + 1 : Integer.min(leftDepth, rightDepth) + 1;
    }
}
