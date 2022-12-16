package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SqrtXTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int number, int sqrt) {
        var objectUnderTest = new SqrtX();
        Assertions.assertEquals(sqrt, objectUnderTest.mySqrt(number));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(2, 1),
            Arguments.of(3, 1),
            Arguments.of(4, 2),
            Arguments.of(15, 3),
            Arguments.of(16, 4),
            Arguments.of(9999, 99),
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2000000000, 44721)
        );
    }
}
