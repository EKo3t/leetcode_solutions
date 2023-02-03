package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MultiplyStringsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String s1, String s2, String expected) {
        var objectUnderTest = new MultiplyStrings();
        Assertions.assertEquals(expected, objectUnderTest.multiply(s1, s2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("2", "3", "6"),
            Arguments.of("123", "456", "56088")
        );
    }
}
