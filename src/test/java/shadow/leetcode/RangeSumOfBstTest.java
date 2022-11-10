package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNode;

import java.util.stream.Stream;

public class RangeSumOfBstTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(TreeNode root, int low, int high, int expected) {
        var objectUnderTest = new RangeSumOfBst();
        Assertions.assertEquals(expected, objectUnderTest.rangeSumBST(root, low, high));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(createTest1(), 6, 10, 23)
        );
    }

    private static TreeNode createTest1() {
        // [10,5,15,3,7,13,18,1,null,6]
        TreeNode root = new TreeNode(10);
        var node5 = new TreeNode(5);
        var node15 = new TreeNode(15);
        root.left = node5; root.right = node15;

        var node3 = new TreeNode(3);
        var node7 = new TreeNode(7);
        node5.left = node3; node5.right = node7;

        var node13 = new TreeNode(13);
        var node18 = new TreeNode(18);
        node15.left = node13; node15.right = node18;

        var node1 = new TreeNode(1);
        var node6 = new TreeNode(6);
        node3.left = node1; node7.left = node6;
        return root;
    }
}
