package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BreakAPalindromeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, String answer) {
        var objectUnderTest = new BreakAPalindrome();
        Assertions.assertEquals(answer, objectUnderTest.breakPalindrome(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("abccba", "aaccba"),
            Arguments.of("bbccbb", "abccbb"),
            Arguments.of("aazzaa", "aaazaa"),
            Arguments.of("aaaaaa", "aaaaab"),
            Arguments.of("baaaab", "aaaaab"),
            Arguments.of("abaaba", "aaaaba"),
            Arguments.of("aba", "abb"),
            Arguments.of("a", "")
        );
    }
}
