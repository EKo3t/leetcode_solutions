package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DivideTwoIntegersTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int dividend, int divisor, int expected) {
        var objectUnderTest = new DivideTwoIntegers();
        Assertions.assertEquals(expected, objectUnderTest.divide(dividend, divisor));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(10, 3, 3),
            Arguments.of(2000000000, 1, 2000000000),
            Arguments.of(2000000000, 2, 1000000000),
            Arguments.of(Integer.MAX_VALUE, -1, Integer.MIN_VALUE + 1),
            Arguments.of(Integer.MIN_VALUE, -1, Integer.MAX_VALUE),
            Arguments.of(Integer.MIN_VALUE, 1, Integer.MIN_VALUE),
            Arguments.of(Integer.MIN_VALUE, 2, -1073741824),
            Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, -1),
            Arguments.of(-1010369383, -2147483648, 0),
            Arguments.of(-1010369383, -2147483647, 0)
        );
    }
}
