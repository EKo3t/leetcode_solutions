package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNodes;

import java.util.stream.Stream;

public class DiameterOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int answer) {
        var objectUnderTest = new DiameterOfBinaryTree();
        Assertions.assertEquals(answer, objectUnderTest.diameterOfBinaryTree(TreeNodes.convertToNode(given)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4, 5}, 3),
            Arguments.of(new int[] {1, 2}, 1),
            Arguments.of(new int[] {1}, 0)
        );
    }
}
