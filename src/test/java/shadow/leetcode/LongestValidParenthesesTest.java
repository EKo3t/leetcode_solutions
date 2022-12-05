package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestValidParenthesesTest {

    private static final LongestValidParentheses SOLUTION = new LongestValidParentheses();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, Integer expected) {
        Assertions.assertEquals(expected, SOLUTION.longestValidParentheses(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("(())(((((()))(((((", 6),
            Arguments.of("(())()(()(())()))(((((", 16),
            Arguments.of("()(((()(()))))", 14),
            Arguments.of("()(())", 6),
            Arguments.of("(()", 2),
            Arguments.of(")()())", 4),
            Arguments.of("))((", 0),
            Arguments.of("())((", 2),
            Arguments.of("", 0),
            Arguments.of("(())()()", 8),
            Arguments.of("(())(()()", 4),
            Arguments.of("(())", 4)
        );
    }
}
