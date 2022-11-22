package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PerfectSquaresTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int number, int expected) {
        var objectUnderTest = new PerfectSquares();
        Assertions.assertEquals(expected, objectUnderTest.numSquares(number));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(12, 3),
            Arguments.of(13, 2),
            Arguments.of(25, 1),
            Arguments.of(26, 2),
            Arguments.of(27, 3),
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(10000, 1),
            Arguments.of(9999, 4)
        );
    }
}
