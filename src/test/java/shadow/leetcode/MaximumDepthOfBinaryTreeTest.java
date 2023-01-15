package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNode;

import java.util.stream.Stream;

public class MaximumDepthOfBinaryTreeTest {

    private static final MaximumDepthOfBinaryTree SOLUTION = new MaximumDepthOfBinaryTree();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(TreeNode given, int expected) {
        Assertions.assertEquals(expected, SOLUTION.maxDepth(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(Arguments.of(createTest1(), 3));
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
}
