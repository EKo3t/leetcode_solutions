package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumberComplementTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int number, int expectedComplement) {
        var objectUnderTest = new NumberComplement();
        Assertions.assertEquals(expectedComplement, objectUnderTest.findComplement(number));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(5, 2),
            Arguments.of(1, 0),
            Arguments.of(8, 7),
            Arguments.of(Integer.MAX_VALUE, 0),
            Arguments.of(Integer.MAX_VALUE - 1, 1)
        );
    }
}
