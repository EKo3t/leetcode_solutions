package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/deepest-leaves-sum">Task description</a>
 * Difficulty: medium
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int maxDeep = getDeepestLevel(root, 0);
        return getSumOfLeavesOnDeep(root, maxDeep, 0);
    }

    private int getDeepestLevel(TreeNode node, int deepLevel) {
        int maxDeepLeft = node.left != null ? getDeepestLevel(node.left, deepLevel + 1) : -1;
        int maxDeepRight = node.right != null ? getDeepestLevel(node.right, deepLevel + 1) : -1;
        return maxDeepLeft == -1 && maxDeepRight == -1 ? deepLevel : Integer.max(maxDeepLeft, maxDeepRight);
    }

    private int getSumOfLeavesOnDeep(TreeNode node, int requiredDeepLevel, int currentDeepLevel) {
        return (node.left != null ? getSumOfLeavesOnDeep(node.left, requiredDeepLevel, currentDeepLevel + 1) : 0)
            + (node.right != null ? getSumOfLeavesOnDeep(node.right, requiredDeepLevel, currentDeepLevel + 1) : 0)
            + (node.left == null && node.right == null && currentDeepLevel == requiredDeepLevel ? node.val : 0);
    }
}
