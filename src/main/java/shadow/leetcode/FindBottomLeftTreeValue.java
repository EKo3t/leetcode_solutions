package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/find-bottom-left-tree-value">Task description</a>
 * Difficulty: medium
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = findMaxDepth(root, 0);
        return findFirstLeftAtDepth(root, 0, maxDepth);
    }

    private int findMaxDepth(TreeNode node, int currentDepth) {
        int leftMaxDepth = node.left != null ? findMaxDepth(node.left, currentDepth + 1) : currentDepth;
        int rightMaxDepth = node.right != null ? findMaxDepth(node.right, currentDepth + 1) : currentDepth;
        return Integer.max(leftMaxDepth, rightMaxDepth);
    }

    private Integer findFirstLeftAtDepth(TreeNode node, int currentDepth, int requiredDepth) {
        if (currentDepth == requiredDepth) {
            return node.val;
        }
        Integer firstLeftAtLeft = node.left != null ? findFirstLeftAtDepth(node.left, currentDepth + 1, requiredDepth) : null;
        if (firstLeftAtLeft != null) {
            return firstLeftAtLeft;
        }
        return node.right != null ? findFirstLeftAtDepth(node.right, currentDepth + 1, requiredDepth) : null;
    }
}
