package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNodes;

import java.util.stream.Stream;

public class SameTreeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] first, int[] second, boolean expected) {
        var objectUnderTest = new SameTree();
        Assertions.assertEquals(expected, objectUnderTest.isSameTree(
            TreeNodes.convertToNode(first),
            TreeNodes.convertToNode(second)
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, true),
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}, false),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 2}, false)
        );
    }
}
