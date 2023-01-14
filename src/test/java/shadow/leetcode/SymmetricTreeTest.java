package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNode;

import java.util.stream.Stream;

public class SymmetricTreeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(TreeNode node, boolean expected) {
        var objectUnderTest = new SymmetricTree();
        Assertions.assertEquals(expected, objectUnderTest.isSymmetric(node));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(createTest1(), true),
            Arguments.of(createTest2(), false)
        );
    }

    private static TreeNode createTest1() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        root.right = node4;
        node4.left = node6;
        node4.right = node5;

        return root;
    }

    private static TreeNode createTest2() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        root.left = node1;
        node1.right = node2;
        root.right = node4;
        node4.right = node5;

        return root;
    }
}
