package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PowerOf3Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int number, boolean expected) {
        var objectUnderTest = new PowerOf3();
        Assertions.assertEquals(expected, objectUnderTest.isPowerOfThree(number));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(5, false),
            Arguments.of(1, true),
            Arguments.of(9, true)
        );
    }
}
