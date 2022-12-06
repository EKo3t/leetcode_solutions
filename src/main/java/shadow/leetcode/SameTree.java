package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Task description</a>
 * Difficulty: easy
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.left != null && q.left == null || p.right != null && q.right == null
            || p.left == null && q.left != null || p.right == null && q.right != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return (p.left == null || isSameTree(p.left, q.left)) &&
            (p.right == null || isSameTree(p.right, q.right));
    }

}



