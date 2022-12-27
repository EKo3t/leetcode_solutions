package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNode;

import java.util.stream.Stream;

public class PathSumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(TreeNode node, int targetSum, boolean expected) {
        var objectUnderTest = new PathSum();
        Assertions.assertEquals(expected, objectUnderTest.hasPathSum(node, targetSum));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(getNodeForTest1(), 22, true),
            Arguments.of(getNodeForTest2(), 5, false)
        );
    }

    private static TreeNode getNodeForTest1() {
        int[] values = new int[] {5, 4, 8, 11, 13, 4, 7, 2, 1};
        TreeNode[] nodes = new TreeNode[9];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new TreeNode(values[i]);

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];
        nodes[3].left = nodes[6];
        nodes[3].right = nodes[7];
        nodes[5].right = nodes[8];
        return nodes[0];
    }

    private static TreeNode getNodeForTest2() {
        int[] values = new int[] {1, 2, 3};
        TreeNode[] nodes = new TreeNode[3];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new TreeNode(values[i]);

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        return nodes[0];
    }


}
