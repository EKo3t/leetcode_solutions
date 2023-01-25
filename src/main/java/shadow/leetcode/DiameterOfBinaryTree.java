package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Task description</a>
 * Difficulty: easy
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root).value;
    }

    private DiameterInfo getDiameter(TreeNode root) {
        DiameterInfo leftInfo = root.left != null ? getDiameter(root.left) : null;
        DiameterInfo rightInfo = root.right != null ? getDiameter(root.right) : null;
        int longestLeftPath = leftInfo != null ? leftInfo.radius : 0;
        int longestRightPath = rightInfo != null ? rightInfo.radius : 0;
        int leftDiameter = leftInfo != null ? leftInfo.value : 0;
        int rightDiameter = rightInfo != null ? rightInfo.value : 0;

        int maxDiameter = Math.max(Math.max(longestLeftPath + longestRightPath, leftDiameter), rightDiameter);
        return new DiameterInfo(maxDiameter, Math.max(longestLeftPath + 1, longestRightPath + 1));
    }

    private static class DiameterInfo {

        private final int value;
        private final int radius;

        public DiameterInfo(int value, int radius) {
            this.value = value;
            this.radius = radius;
        }
    }
}
