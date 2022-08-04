package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddBinaryTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String number1, String number2, String expected) {
        var objectUnderTest = new AddBinary();
        Assertions.assertEquals(expected, objectUnderTest.addBinary(number1, number2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("11", "1", "100"),
            Arguments.of("1", "11", "100"),
            Arguments.of("0", "0", "0"),
            Arguments.of("1010", "1011", "10101"),
            Arguments.of("1", "11111111111", "100000000000")
        );
    }
}
