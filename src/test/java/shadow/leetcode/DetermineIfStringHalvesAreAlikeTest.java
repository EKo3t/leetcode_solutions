package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DetermineIfStringHalvesAreAlikeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, boolean answer) {
        var objectUnderTest = new DetermineIfStringHalvesAreAlike();
        Assertions.assertEquals(answer, objectUnderTest.halvesAreAlike(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("book", true),
            Arguments.of("AbCdEfGh", true),
            Arguments.of("textbook", false)
        );
    }
}
