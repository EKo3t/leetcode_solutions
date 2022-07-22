package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestPalindromicSubstringTest {

    private static final LongestPalindromicSubstring SOLUTION = new LongestPalindromicSubstring();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, String expected) {
        String answer = SOLUTION.longestPalindrome(given);
        Assertions.assertEquals(expected, answer);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("babad", "bab"),
            Arguments.of("qabcbaf", "abcba"),
            Arguments.of("q", "q"),
            Arguments.of("qqqqqq", "qqqqqq"),
            Arguments.of("cbbd", "bb"),
            Arguments.of("bb", "bb"),
            Arguments.of("abcda", "a")
        );
    }
}
