package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.StringToIntegerAToI;

import java.util.stream.Stream;

public class StringToIntegerAtoITest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, int answer) {
        var objectUnderTest = new StringToIntegerAToI();
        Assertions.assertEquals(answer, objectUnderTest.myAtoi(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("   -42", -42),
            Arguments.of("42", 42),
            Arguments.of("  ----", 0),
            Arguments.of(" 9876543211   fdsfdsfdsf", 2147483647),
            Arguments.of("4193 with words", 4193),
            Arguments.of("words and 987", 0),
            Arguments.of("-91283472332", -2147483648),
            Arguments.of("00000-42a1234", 0)
        );
    }
}
