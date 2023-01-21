package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNode;

import java.util.stream.Stream;

public class BalancedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(TreeNode node, boolean expected) {
        var objectUnderTest = new BalancedBinaryTree();
        Assertions.assertEquals(expected, objectUnderTest.isBalanced(node));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(createTest1(), true),
            Arguments.of(createTest2(), false),
            Arguments.of(createTest3(), false),
            Arguments.of(null, true)
        );
    }

    private static TreeNode createTest1() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        return node1;
    }

    private static TreeNode createTest3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node2.left = node3;
        return node1;
    }

    private static TreeNode createTest2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        return node1;
    }
}
