package shadow.leetcode.util;

public class TreeNodes {

    public static TreeNode convert(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createNode(array, 0);
    }

    private static TreeNode createNode(int[] array, int counter) {
        TreeNode node = new TreeNode();
        node.val = array[counter];
        if (counter * 2 + 1 < array.length) node.left = createNode(array, counter * 2 + 1);
        if (counter * 2 + 2 < array.length) node.right = createNode(array, counter * 2 + 2);
        return node;
    }
}
