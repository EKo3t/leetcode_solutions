package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EvaluateReversePolishNotationTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] tokens, int answer) {
        var objectUnderTest = new EvaluateReversePolishNotation();
        Assertions.assertEquals(answer, objectUnderTest.evalRPN(tokens));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
            Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
            Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22),
            Arguments.of(new String[]{"-200", "-100", "+", "3", "*"}, -900)
        );
    }
}
