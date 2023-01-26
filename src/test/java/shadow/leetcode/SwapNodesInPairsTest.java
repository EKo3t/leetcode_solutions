package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class SwapNodesInPairsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int[] expected) {
        var objectUnderTest = new SwapNodesInPairs();
        Assertions.assertTrue(ListNodes.areEqual(ListNodes.convert(expected), objectUnderTest.swapPairs(ListNodes.convert(nums))));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}),
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5})
        );
    }
}
