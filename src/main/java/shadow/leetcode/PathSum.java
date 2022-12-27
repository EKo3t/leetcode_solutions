package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/path-sum">Task description</a>
 * Difficulty: easy
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return hasLeafWithPathSumOfTarget(root, targetSum, root.val);
    }

    private boolean hasLeafWithPathSumOfTarget(TreeNode node, int targetSum, int currentSum) {
        if (isLeaf(node) && currentSum == targetSum)
            return true;

        return node.left != null && hasLeafWithPathSumOfTarget(node.left, targetSum, currentSum + node.left.val)
            || node.right != null && hasLeafWithPathSumOfTarget(node.right, targetSum, currentSum + node.right.val);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
