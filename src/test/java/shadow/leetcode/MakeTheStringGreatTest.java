package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MakeTheStringGreatTest {

    private static final MakeTheStringGreat SOLUTION = new MakeTheStringGreat();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, String expected) {
        Assertions.assertEquals(expected, SOLUTION.makeGood(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("leEeetcode", "leetcode"),
            Arguments.of("abBAcC", "")
        );
    }
}
