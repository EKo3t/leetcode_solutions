package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestPalindromeTest {

    private static final LongestPalindrome SOLUTION = new LongestPalindrome();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, Integer expected) {
        Integer answer = SOLUTION.longestPalindrome(given);
        Assertions.assertEquals(expected, answer);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("abccccdd", "7"),
            Arguments.of("a", "1"),
            Arguments.of("aaab", "3")
        );
    }
}
