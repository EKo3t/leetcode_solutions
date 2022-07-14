package shadow.leetcode.valid_parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, boolean answer) {
        var objectUnderTest = new ValidParentheses();
        Assertions.assertEquals(answer, objectUnderTest.isValid(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("((()))", true),
            Arguments.of("((())", false),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("()", true),
            Arguments.of(")", false),
            Arguments.of("(", false),
            Arguments.of("(]{}{}()", false)
        );
    }
}
