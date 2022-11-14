package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TwoSum2InputArrayIsSortedTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int target, int[] expectedIndexes) {
        var objectUnderTest = new TwoSum2InputArrayIsSorted();
        Assertions.assertArrayEquals(expectedIndexes, objectUnderTest.twoSum(given, target));
    }

    @Test
    public void shouldThrowExceptionIfSolutionHasntBeenFound() {
        var objectUnderTest = new TwoSum2InputArrayIsSorted();
        Assertions.assertThrows(IllegalStateException.class, () -> objectUnderTest.twoSum(new int[]{2, 7, 11, 15}, 27));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{3, 24, 50, 79, 88, 150, 345}, 200, new int[]{3, 6}),
            Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2}),
            Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
            Arguments.of(new int[]{2, 7, 11, 15}, 17, new int[]{1, 4}),
            Arguments.of(new int[]{2, 7, 11, 15}, 26, new int[]{3, 4})
        );
    }
}
