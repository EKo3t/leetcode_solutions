package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, int answer) {
        var objectUnderTest = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertEquals(answer, objectUnderTest.lengthOfLongestSubstring(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("abcabcbbabcdefff", 6),
            Arguments.of("bbbbb", 1),
            Arguments.of("", 0)
        );
    }
}
