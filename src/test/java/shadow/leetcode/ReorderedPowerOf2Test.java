package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReorderedPowerOf2Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int given, boolean answer) {
        var objectUnderTest = new ReorderedPowerOf2();
        Assertions.assertEquals(answer, objectUnderTest.reorderedPowerOf2(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(2, true),
            Arguments.of(3, false),
            Arguments.of(4, true),
            Arguments.of(45, false),
            Arguments.of(10, false),
            Arguments.of(11, false),
            Arguments.of(23, true),
            Arguments.of(821, true),
            Arguments.of(652, true),
            Arguments.of(870129365, true)
        );
    }
}
