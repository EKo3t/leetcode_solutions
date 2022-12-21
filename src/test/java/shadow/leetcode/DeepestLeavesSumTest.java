package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNodes;

import java.util.stream.Stream;

public class DeepestLeavesSumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(Integer[] given, int expected) {
        var objectUnderTest = new DeepestLeavesSum();
        Assertions.assertEquals(expected, objectUnderTest.deepestLeavesSum(TreeNodes.convertToNode(given)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8}, 15),
            Arguments.of(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}, 19)
        );
    }
}
