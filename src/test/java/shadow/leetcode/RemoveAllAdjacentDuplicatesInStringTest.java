package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveAllAdjacentDuplicatesInStringTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, String expected) {
        var objectUnderTest = new RemoveAllAdjacentDuplicatesInString();
        Assertions.assertEquals(expected, objectUnderTest.removeDuplicates(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("abbaca", "ca"),
            Arguments.of("azxxzy", "ay"),
            Arguments.of("aaaaaa", ""),
            Arguments.of("aaaaa", "a"),
            Arguments.of("a", "a")
        );
    }
}
