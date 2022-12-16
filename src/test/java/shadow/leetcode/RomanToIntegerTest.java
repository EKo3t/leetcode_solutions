package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanToIntegerTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, Integer expected) {
        var objectUnderTest = new RomanToInteger();
        Assertions.assertEquals(expected, objectUnderTest.romanToInt(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("III", 3),
            Arguments.of("LVIII", 58),
            Arguments.of("MCMXCIV", 1994)
        );
    }
}
