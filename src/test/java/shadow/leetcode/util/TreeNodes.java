package shadow.leetcode.util;

public class TreeNodes {

    public static TreeNode convertToNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createNode(array, 0);
    }

    public static TreeNode convertToNode(Integer[] array) {
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

    private static TreeNode createNode(Integer[] array, int counter) {
        TreeNode node = new TreeNode();
        node.val = array[counter];
        if (counter * 2 + 1 < array.length && array[counter * 2 + 1] != null) node.left = createNode(array, counter * 2 + 1);
        if (counter * 2 + 2 < array.length && array[counter * 2 + 2] != null) node.right = createNode(array, counter * 2 + 2);
        return node;
    }
}
