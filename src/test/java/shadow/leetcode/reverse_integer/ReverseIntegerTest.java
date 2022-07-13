package shadow.leetcode.reverse_integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseIntegerTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int given, int answer) {
        var objectUnderTest = new ReverseInteger();
        Assertions.assertEquals(answer, objectUnderTest.reverse(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(123, 321),
            Arguments.of(-123, -321),
            Arguments.of(120, 21),
            Arguments.of(1234567899, 0),
            Arguments.of(-1234567899, 0),
            Arguments.of(-901000, -109)
        );
    }
}
