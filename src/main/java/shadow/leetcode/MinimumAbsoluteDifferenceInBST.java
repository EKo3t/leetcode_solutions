package shadow.leetcode;

import shadow.leetcode.util.TreeNode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst">Task description</a>
 * Difficulty: easy
 */
public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        int nodeCount = countNodes(root);
        int[] values = new int[nodeCount];
        int counter = 0;
        mapToArray(root, values, counter);
        Arrays.parallelSort(values);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.length; i++)
            if (values[i] - values[i - 1] < minDiff)
                minDiff = values[i] - values[i - 1];

        return minDiff;
    }

    private int mapToArray(TreeNode root, int[] values, int counter) {
        System.out.println(root.val + " " + counter);
        values[counter++] = root.val;
        if (root.left != null)
            counter = mapToArray(root.left, values, counter);

        if (root.right != null)
            counter = mapToArray(root.right, values, counter);
        return counter;
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
