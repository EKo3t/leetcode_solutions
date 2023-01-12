package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HowManyNumbersAreSmallerThanTheCurrentNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int[] expected) {
        var objectUnderTest = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        Assertions.assertArrayEquals(expected, objectUnderTest.smallerNumbersThanCurrent(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}),
            Arguments.of(new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0}),
            Arguments.of(new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3})
        );
    }
}
