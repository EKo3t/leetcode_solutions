package shadow.leetcode;

import shadow.leetcode.util.Node;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree">Task description</a>
 * Difficulty: easy
 */
public class MaximumDepthOfNTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;

        return getMaxDepth(root, 1);
    }

    private int getMaxDepth(Node node, int currentLevel) {
        int max = currentLevel;
        int childrenCount = node.children != null ? node.children.size() : 0;
        for (int i = 0; i < childrenCount; i++) {
            max = Integer.max(max, getMaxDepth(node.children.get(i), currentLevel + 1));
        }
        return max;
    }
}
