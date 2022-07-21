package shadow.leetcode.length_of_the_last_word;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LengthOfLastWordTest {

    private static final LengthOfLastWord SOLUTION = new LengthOfLastWord();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, int expected) {
        Assertions.assertEquals(expected, SOLUTION.lengthOfLastWord(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("Hello World", 5),
            Arguments.of("   fly me   to   the moon  ", 4),
            Arguments.of("luffy is still joyboy", 6)
        );
    }
}
