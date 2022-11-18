package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UglyNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int given, boolean answer) {
        var objectUnderTest = new UglyNumber();
        Assertions.assertEquals(answer, objectUnderTest.isUgly(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(6, true),
            Arguments.of(1, true),
            Arguments.of(14, false),
            Arguments.of(-1, false),
            Arguments.of(10, true),
            Arguments.of(50, true)
        );
    }
}
