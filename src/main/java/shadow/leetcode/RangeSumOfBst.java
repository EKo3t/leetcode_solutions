package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

public class RangeSumOfBst {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return rangeSumBST(root.left, low, high)
            + rangeSumBST(root.right, low, high)
            + (root.val >= low && root.val <= high ? root.val : 0);
    }
}
