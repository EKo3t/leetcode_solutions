package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringCompressionTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(char[] given, int answer) {
        var objectUnderTest = new StringCompression();
        Assertions.assertEquals(answer, objectUnderTest.compress(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, 6),
            Arguments.of(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, 4),
            Arguments.of(new char[]{'a'}, 1)
        );
    }
}
