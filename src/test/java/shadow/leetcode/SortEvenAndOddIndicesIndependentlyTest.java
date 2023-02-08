package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortEvenAndOddIndicesIndependentlyTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int[] expected) {
        var objectUnderTest = new SortEvenAndOddIndicesIndependently();
        Assertions.assertArrayEquals(expected, objectUnderTest.sortEvenOdd(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{4, 1, 2, 3}, new int[]{2, 3, 4, 1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 6, 3, 4, 5, 2, 7}),
            Arguments.of(new int[]{4, 1, 2, 3, 2}, new int[]{2, 3, 2, 1, 4})
        );
    }
}
