package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int target, int[] expected) {
        var objectUnderTest = new FindFirstAndLastPositionOfElementInSortedArray();
        Assertions.assertArrayEquals(expected, objectUnderTest.searchRange(given, target));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{3, 3, 3}, 3, new int[]{0, 2}),
            Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
            Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
            Arguments.of(new int[]{}, 6, new int[]{-1, -1}),
            Arguments.of(new int[]{1}, 6, new int[]{-1, -1}),
            Arguments.of(new int[]{1}, 1, new int[]{0, 0}),
            Arguments.of(new int[]{1, 1}, 2, new int[]{-1, -1}),
            Arguments.of(new int[]{1, 1}, 1, new int[]{0, 1})
        );
    }
}
