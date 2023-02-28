package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LetterTilePossibilitiesTest {

    private static final LetterTilePossibilities SOLUTION = new LetterTilePossibilities();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, int expected) {
        Assertions.assertEquals(expected, SOLUTION.numTilePossibilities(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("AAB", 8),
            Arguments.of("AAABBC", 188),
            Arguments.of("C", 1)
        );
    }
}
